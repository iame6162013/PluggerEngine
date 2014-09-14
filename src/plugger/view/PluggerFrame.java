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
		glRenderer.setupOpenGL();
		GameLoop.gameloop();
		System.out.println("out");
		cleanUp();
	}
	
	private static void cleanUp(){
		Display.destroy();
	}
	public static void initDisplay(){
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
<<<<<<< HEAD
			Display.setTitle("Display");
			PixelFormat pixelFormat = new PixelFormat();
			ContextAttribs contextAtrributes = new ContextAttribs(3, 2)
				.withForwardCompatible(true)
				.withProfileCore(true);
		
			Display.create(pixelFormat, contextAtrributes);
			Display.setVSyncEnabled(true);
=======
			Display.setTitle("Plugger");
>>>>>>> FETCH_HEAD
			Display.sync(20);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
}
