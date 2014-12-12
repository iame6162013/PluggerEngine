package plugger.Player;

import org.lwjgl.input.Keyboard;

import plugger.common.Drawer;
import plugger.common.GameLoop;
import plugger.common.MasterRenderer;
import plugger.common.EntityRenderer;
import plugger.entities.Camera;

public class Player {
	
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

		
		
	}
	
	
}
