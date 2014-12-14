package plugger.common;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import plugger.Entity.Camera;
import plugger.Entity.Entity;
import plugger.Entity.Light;
import plugger.models.OBJLoader;
import plugger.models.RawModel;
import plugger.models.TexturedModel;
import plugger.textures.ModelTexture;

public class Drawer {
	List<Entity> allEntities = new ArrayList<Entity>();
	Light light;
	public Camera camera;
	public Loader loader = new Loader();
	
	public MasterRenderer render = new MasterRenderer();
	
	Drawer(){
		light = new Light(new Vector3f(0,0,0), new Vector3f(1,1,1));
		camera = new Camera();
	}
	
	public void removeEntityFromWorld(int numb){
		allEntities.remove(numb);
	}
	
	public void addEntity(Entity entity){
		allEntities.add(entity);
	}
	
	public void addEntityFromWorld(int chunkN, int blockN){
		allEntities.add(new Entity("Fern", GameLoop.world.getChunk(chunkN).getModel(blockN), GameLoop.world.getChunk(chunkN).getPos(blockN), 0, 0, 0, 1f));
	}
	
	public int getEntityAmount(){
		return allEntities.size();
	}
	
	public void rebuild(){
		allEntities.clear();
		for(int numb=0;numb<GameLoop.world.getChunk(0).size();numb++){
			allEntities.add(new Entity("Fern", GameLoop.world.getChunk(0).getModel(numb), GameLoop.world.getChunk(0).getPos(numb), 0, 0, 0, 1f));
		}
	}
	
	public void draw(){
		light.setposition(camera.getPostition());
		for(Entity entity:allEntities){
			try{
				render.processEntity(entity);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		render.render(light, camera);
	}
	public void cleanUp(){
		
		render.cleanUp();
	}
}
