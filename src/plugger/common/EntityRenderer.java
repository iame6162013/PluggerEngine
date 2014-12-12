package plugger.common;

import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;


import plugger.shaders.StaticShader;
import plugger.textures.ModelTexture;
import plugger.util.Maths;
import plugger.entities.Entity;
import plugger.models.RawModel;
import plugger.models.TexturedModel;

public class EntityRenderer {
	StaticShader shader;
	
	
	public EntityRenderer(StaticShader shader2, Matrix4f projectionMatrix){
		this.shader=shader2;
		shader.start();
		shader.loadProjectionMatrix(projectionMatrix);
		shader.stop();
		
	}

	public void render(Map<TexturedModel,List<Entity>> entities){
		for(TexturedModel model:entities.keySet()){
			prepareTexturedModel(model);
			List<Entity> batch = entities.get(model);
			for(Entity entity:batch){
				prepareInstance(entity);
				GL11.glDrawElements(GL11.GL_TRIANGLES, model.getRawModel().getVertexCount(),GL11.GL_UNSIGNED_INT, 0);
			}
			unbindTexturedModel();
		}
	}
	
	private void prepareTexturedModel(TexturedModel model){
		RawModel rawModel = model.getRawModel();
		GL30.glBindVertexArray(rawModel.getVaoID());
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		GL20.glEnableVertexAttribArray(2);
		ModelTexture texture = model.getTexture();
		if(texture.isHasTransparency()){
			MasterRenderer.disableCulling();
		}
		shader.loadFakeLightingVariable(texture.isUseFakeLighting());
		shader.loadShineVariable(texture.getShineDamper(), texture.getReflectivity());
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, model.getTexture().getID());
	}
	
	private void unbindTexturedModel(){
		MasterRenderer.enableCulling();
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		GL20.glDisableVertexAttribArray(2);
		GL30.glBindVertexArray(0);
	}
	
	private void prepareInstance(Entity entity){
		Matrix4f transformationMatrix = Maths.createTransforMationMatrix(entity.getPosition(), entity.getRotX(), entity.getRotY(), entity.getRotZ(), entity.getScale());
		shader.loadTransformationMatrix(transformationMatrix);
	}
}
