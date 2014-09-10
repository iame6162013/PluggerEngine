package src.plugger.view;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import src.plugger.common.GameLoop;
import static org.lwjgl.opengl.GL11.*;

public class PluggerFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("START");
		initDisplay();
		initGL();
		GameLoop.gameloop();
		System.out.println("out");
		cleanUp();
	}
	
	private static void initGL(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,Display.getWidth(),0,Display.getHeight(),-1,1);
		glMatrixMode(GL_MODELVIEW);
		
		glClearColor(0,0,0,1);
		
		glDisable(GL_DEPTH_TEST);
	}
	
	private static void cleanUp(){
		Display.destroy();
	}
	public static void initDisplay(){
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.setTitle("Display example");
			Display.create();
			Display.setVSyncEnabled(true);
			Display.sync(20);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
}
