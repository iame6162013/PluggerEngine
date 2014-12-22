package plugger.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import plugger.Entity.Camera;
import plugger.Entity.Entity;
import plugger.common.GameLoop;
import plugger.common.GameRegistry;
import plugger.models.TexturedModel;

public class Player extends Entity{
	
	List<Object> obj = new ArrayList<Object>();
	int weight=70;
	
	
	public Player(String id, TexturedModel model, Vector3f position,float rotX, float rotY, float rotZ, int weight) {
		super(id, model, position, rotX, rotY, rotZ, weight);
	}
	
	public void move(){
		Input();
		super.increasePosition(1, 1, 1);
	}
	
	public void increaseWeight(){
		
	}
	
	public int getWeight(){
		return weight;
	}
	
	public void Input() {
		Camera cam=GameLoop.draw.camera;
		
		
		//FORWARD&BACK
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){cam.move(0.5f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){cam.move(-0.5f);}
		//LEFT&RIGHT
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){cam.moveYaw(0.5f,90f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){cam.moveYaw(-0.5f,90f);}
		//UP&DOWN
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){cam.moveY(0.5f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){cam.moveY(-0.5f);}
		//Roll
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD7)){cam.rotateZ(-2f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD9)){cam.rotateZ(2f);}
		//Yaw
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD4)){cam.rotateX(-10f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD6)){cam.rotateX(10f);}
		//Pitch
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD8)){cam.rotateY(-10f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD2)){cam.rotateY(10f);}

		int i= GameLoop.world.getChunk(0).size()-1;
		if(Keyboard.isKeyDown(Keyboard.KEY_O)){obj.add(GameLoop.world.getChunk(0).getId(i));obj.add(GameLoop.world.getChunk(0).getModel(i));obj.add(GameLoop.world.getChunk(0).getPos(i));GameLoop.world.getChunk(0).removeBlock(i);}
		if(Keyboard.isKeyDown(Keyboard.KEY_P)){GameLoop.world.getChunk(0).addBlock(new Entity((String)obj.get(0), (TexturedModel)obj.get(1), (Vector3f)obj.get(2), 0, 0, 0,60));}
		if(Keyboard.isKeyDown(Keyboard.KEY_I)){System.out.println("WORLD NUMBER ENTITIES: "+GameLoop.world.getChunk(0).size()+" DRAWER: "+GameLoop.draw.getEntityAmount());}
		if(Keyboard.isKeyDown(Keyboard.KEY_U)){GameLoop.world.getChunk(0).changePosBlock(3, new Vector3f(4,4,4));}
		if(Keyboard.isKeyDown(Keyboard.KEY_Y)){GameLoop.draw.rebuild();}
	}

	public void loadHud() {
		GameRegistry.addHudMess("This is the games hud here will stats be displayed");
		GameRegistry.addHudMess2("TPS: ",GameLoop.class,"tps", GameLoop.gameloop);
		GameRegistry.addHudMess2("FPS: ",GameLoop.class,"fps", GameLoop.gameloop);
		GameRegistry.addHudMess2("Weight: ", Player.class, "getWeight", GameLoop.gameloop.world.player);
		GameRegistry.addHudMess("End");
	}
	
	
}
