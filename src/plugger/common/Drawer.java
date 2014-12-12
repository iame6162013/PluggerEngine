package plugger.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.util.vector.Vector3f;

import plugger.entities.Camera;
import plugger.entities.Entity;
import plugger.entities.Light;
import plugger.models.OBJLoader;
import plugger.models.RawModel;
import plugger.models.TexturedModel;
import plugger.textures.ModelTexture;
import plugger.world.world;
import plugger.world.chunk.Chunk;

public class Drawer {
	
	RawModel model;
	ModelTexture texturedModel;
	TexturedModel staticModel;
	ModelTexture texture ;
	List<Entity> allEntities = new ArrayList<Entity>();
	Light light;
	public Camera camera;
	Loader loader = new Loader();
	
	public MasterRenderer render = new MasterRenderer();
	
	Drawer(){
		light = new Light(new Vector3f(0,0,0), new Vector3f(1,1,1));
		camera = new Camera();
	}
	
	public void draw(){
		RawModel model = OBJLoader.loadObjModel("LitleHead", loader);
		TexturedModel TModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("Grass")));
		TModel.getTexture().setHasTransparency(true);
		TModel.getTexture().setUseFakeLighting(true);
		
		for(int i=0;i<world.chunk.ObjInChunk(0);i++){
			allEntities.add(new Entity("Fern", TModel, world.chunk.getPos(0,i), 0, 0, 0f, 1f));
		}
		
		light.setposition(camera.getPostition());
		for(Entity entity:allEntities){
			render.processEntity(entity);
		}
		render.render(light, camera);
		
		
		
	}
	public void cleanUp(){
		render.cleanUp();
	}
}
