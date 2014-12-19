package plugger.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import plugger.Entity.Camera;
import plugger.Entity.Entity;
import plugger.Entity.Light;
import plugger.models.TexturedModel;
import plugger.shaders.StaticShader;

public class MasterRenderer {
	

	private static final float FOV=70;
	private static final float NEAR_PLANE=0.3f;
	private static final float FAR_PLANE=1000;
	private Matrix4f projectionMatrix;
	
	private static Vector3f skyColor =new Vector3f(0.5f,0.1f, 0.0f); 
	
	public StaticShader shader = new StaticShader();
	private EntityRenderer renderer;
	
	
	private Map<TexturedModel,List<Entity>> entities = new HashMap<TexturedModel,List<Entity>>();
	
	MasterRenderer(){
		createProjectionMatrix();
		GL11.glLoadIdentity();
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		renderer = new EntityRenderer(shader, projectionMatrix);
	}
	
	public static void enableCulling(){
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glCullFace(GL11.GL_BACK);
	}
	public static void disableCulling(){
		GL11.glDisable(GL11.GL_CULL_FACE);
	}
	
	public void render(Light sun, Camera camera){
		prepare();
		shader.start();
		shader.loadSkyColor(skyColor);
		shader.loadLight(sun);
		shader.loadViewMatrix(camera);
		renderer.render(entities);
		shader.stop();
		entities.clear();
	}
	
	public void processEntity(Entity entity){
		TexturedModel entityModel = entity.getModel();
		List<Entity> batch = entities.get(entityModel);
		if(batch!=null){
			batch.add(entity);
		}else{
			List<Entity> newBatch = new ArrayList<Entity>();
			newBatch.add(entity);
			entities.put(entityModel, newBatch);
		}
	}
	
	
	public void cleanUp(){
		shader.cleanUp();
	}
	
	public void prepare(){
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glClearColor(skyColor.x, skyColor.y, skyColor.z, 1);
	}
	
	private void createProjectionMatrix(){
		float aspectRatio = (float) Display.getWidth()/(float) Display.getHeight();
		float y_scale = (float) ((1f/Math.tan(Math.toRadians(FOV/2f)))*aspectRatio);
		float x_scale = y_scale/aspectRatio;
		float frustrum_length = FAR_PLANE - NEAR_PLANE;
		
		projectionMatrix = new Matrix4f();
		projectionMatrix.m00 = x_scale;
		projectionMatrix.m11 = y_scale;
		projectionMatrix.m22 = -((FAR_PLANE+NEAR_PLANE)/frustrum_length);
		projectionMatrix.m23 = -1;
		projectionMatrix.m32 = -((2*NEAR_PLANE*FAR_PLANE)/frustrum_length);
		projectionMatrix.m33 = 0;
	}
}
