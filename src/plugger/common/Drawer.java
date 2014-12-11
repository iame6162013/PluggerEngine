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

public class Drawer {
	
	RawModel model;
	ModelTexture texturedModel;
	TexturedModel staticModel;
	ModelTexture texture ;
	List<Entity> allEntities;
	Light light;
	public Camera camera;
	Loader loader = new Loader();
	
	public MasterRenderer render = new MasterRenderer();
	
	Drawer(){
		model = OBJLoader.loadObjModel("untitled",loader);
		texturedModel = new ModelTexture(loader.loadTexture("MarbleTilesFancy3"));
		staticModel = new TexturedModel(model,texturedModel);
		texture = staticModel.getTexture();
		texture.setShineDamper(20);
		texture.setReflectivity(0.5f);
		allEntities = new ArrayList<Entity>();
		allEntities.add(new Entity(staticModel, new Vector3f(1, 1,-25),1,0,0,1));
		light = new Light(new Vector3f(0,0,0), new Vector3f(1,1,1));
		camera = new Camera();
	}
	
	public void draw(){
		//entity.increasePosition(0, 0, -0.4f);
		
		
		
		/*for (int x=0; x<5*Chunk.getDefaultChunkSize();x++){
			for (int y=0; y<5*Chunk.getDefaultChunkSize();y++){
				for (int z=0; z<5*Chunk.getDefaultChunkSize();z++){
					if (world.chunk.getBlockInChunk(x, y, z) != null){
						if(world.chunk.getBlockInChunk(x-1, y, z) == null || world.chunk.getBlockInChunk(x+1, y, z) == null || world.chunk.getBlockInChunk(x, y-1, z) == null || world.chunk.getBlockInChunk(x, y+1, z) == null || world.chunk.getBlockInChunk(x, y, z-1) == null || world.chunk.getBlockInChunk(x, y, z+1) == null)
						render.processEntity(entity);
					}
				}
			}
		}*/
		RawModel model = OBJLoader.loadObjModel("Grass", loader);
		TexturedModel Fern = new TexturedModel(model, new ModelTexture(loader.loadTexture("Grass2")));
		Fern.getTexture().setHasTransparency(true);
		Fern.getTexture().setUseFakeLighting(true);
		
		
		Random r = new Random(204);
		for(int i=0; i<100; i++){
			allEntities.add((new Entity(Fern, new Vector3f(r.nextFloat()*50,1,r.nextFloat()*50), 0, 0, 0f, 1f)));
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
