package src.plugger.view;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.vector.Vector2f;

import src.plugger.common.GameLoop;
import src.plugger.world.galaxy.Galaxy;

public class PluggerFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("START");
		initDisplay();
		
		Galaxy.LoadWorldFromCode();
		
		GameLoop.gameloop();
		System.out.println("out");
		cleanUp();
	}
	
	private static void cleanUp(){
		Keyboard.destroy();
		Display.destroy();
		Mouse.destroy();
	}
	public static void initDisplay(){
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.setTitle("Plugger");
			Display.sync(20);
			Display.create();
			Keyboard.create();
			Mouse.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	public static void Render()
	{
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
}
