package src.plugger.Player;

import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;

import src.plugger.common.renderer;
import src.plugger.view.Camera;

public class player {
	
	public static void Input() {
		Camera cam=renderer.cam;
		
		
		//FORWARD&BACK
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){cam.move(0.1f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){cam.move(-0.1f);}
		//LEFT&RIGHT
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){cam.moveYaw(0.1f,90f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){cam.moveYaw(-0.1f,90f);}
		//UP&DOWN
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){cam.moveY(0.1f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){cam.moveY(-0.1f);}
		//Roll
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD7)){cam.rotateZ(-2f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD9)){cam.rotateZ(2f);}
		//Yaw
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD4)){cam.rotateX(-2f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD6)){cam.rotateX(2f);}
		//Pitch
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD8)){cam.rotateY(-2f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD2)){cam.rotateY(2f);}
		
		
		
		//Special ones!
		
		//turn Yaw 180°
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD3)){Camera.setYaw(Camera.yaw()+180);}
		//if(true){Camera.setYaw(Camera.yaw());}
		
		//output Yaw
		if(Keyboard.isKeyDown(Keyboard.KEY_Y)){System.out.println("Yaw:"+Camera.yaw()+"___"+Camera.yaw()/360);}
		//if(true){System.out.println("Yaw:"+Camera.yaw());}
		
		
		//Just to see what i'm doing must be changed often
		if(Keyboard.isKeyDown(Keyboard.KEY_O)){System.out.println("OUTPUT SPECIAL THINGY:"	);}

		
		
	}
	
	
}
