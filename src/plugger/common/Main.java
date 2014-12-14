package plugger.common;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.vector.Vector2f;


public class Main {
	
	private static final int WIDTH = 1280; 
	private static final int HEIGHT = 720; 
	private static final int FPS_CAP = 60;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initDisplay();
		GameLoop.start();
		cleanUp();
		System.exit(0);
	}
	
	public static void initDisplay(){
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.setTitle("Plugger");
			Display.sync(FPS_CAP);
			Display.create();
			Keyboard.create();
			Mouse.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	public static void Render(){
		Display.update();
	}
	public static boolean IsCloseRequested()
	{
		return Display.isCloseRequested();
	}
	
	public static int GetWidth()
	{
		return Display.getDisplayMode().getWidth();
	}
	
	public static int GetHeight()
	{
		return Display.getDisplayMode().getHeight();
	}
	
	public static String GetTitle()
	{
		return Display.getTitle();
	}

	public Vector2f GetCenter()
	{
		return new Vector2f(GetWidth()/2, GetHeight()/2);
	}
	private static void cleanUp(){
		
		GameLoop.cleanUp();
		Keyboard.destroy();
		Display.destroy();
		Mouse.destroy();
	}
}
