package plugger.common;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;
//import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

import plugger.Entity.Camera;
import plugger.Entity.Entity;
import plugger.Entity.Light;
import plugger.util.FontUtil;

public class Drawer{
	private int amountEntities;
	List<Entity> worldEntities = new ArrayList<>();
	List<Entity> extraEntities = new ArrayList<>();
	Light light;
	public Camera camera;
	public Loader loader = new Loader();
	
	public MasterRenderer render = new MasterRenderer();
	
	Drawer(){
		light = new Light(new Vector3f(0,0,0), new Vector3f(1,1,1));
		camera = new Camera();
	}
	
	public void removeEntityFromWorld(int numb){
		worldEntities.remove(numb);
		amountEntities--;
	}
	
	public void addEntity(Entity entity){
		extraEntities.add(entity);
		amountEntities++;
	}
	
	public void addEntityFromWorld(int chunkN, int blockN){
		worldEntities.add(new Entity(GameLoop.world.getChunk(chunkN).getId(blockN), GameLoop.world.getChunk(chunkN).getModel(blockN), GameLoop.world.getChunk(chunkN).getPos(blockN), 0, 0, 0,1));
		amountEntities++;
	}
	
	public int getEntityAmount(){
		return amountEntities;
	}
	
	public void rebuild(){
		amountEntities-=worldEntities.size();
		worldEntities.clear();
		System.out.println(GameLoop.world.chunk.size());
		for(int chunkN=0;chunkN<GameLoop.world.chunk.size();chunkN++){
			for(int numb=0;numb<GameLoop.world.getChunk(0).size();numb++){
				worldEntities.add(new Entity(GameLoop.world.getChunk(0).getId(numb), GameLoop.world.getChunk(0).getModel(numb), GameLoop.world.getChunk(0).getPos(numb), 0, 0, 0,1));
			}
		}
		amountEntities+=worldEntities.size();
	}
	
	public void draw(){
		light.setposition(camera.getPostition());
		for(Entity entity:worldEntities){
			try{
				render.processEntity(entity);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		for(Entity entity:extraEntities){
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
	
	
	//////////////////////////////////////TEXT DRAWER!///////////////////////////////////////
	
	
	private Font f = new Font("Arial", Font.PLAIN, 20);
	private FontUtil fUtil = new FontUtil(f, Color.WHITE, true);
	
	public void initT(){
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glViewport(0,0,Display.getWidth(),Display.getHeight());
	}
	
	public void renderText(){
		GameRegistry.UpdateHudMess();
		for (int pointer=0;pointer<GameRegistry.amountHudMesh; pointer++){
			fUtil.drawString(GameRegistry.hudMesh.get(pointer), 10, 15+pointer*2*15);
		}
	}
	
	
	
	
	
}
