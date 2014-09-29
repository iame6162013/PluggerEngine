package src.plugger.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import static org.lwjgl.opengl.GL11.*;

import src.plugger.common.GameLoop;
import src.plugger.view.HudElements;
import src.plugger.world.chunk.chunk;

public class GameLoop{
	private static final int maxFrameRate = 50;
	
	private static int frames=0;
	static int fps = 0;
	static int FpsRate=20;
	static int tick = 0;
	static int tickRate = 20;
	static int ticksPs = 0;
	static long secondStart = System.currentTimeMillis();
	static long secondStart2 = System.currentTimeMillis();
	static long tickStart = System.currentTimeMillis();
	static float x=0;
	
	
	/**Main game loop */
	public static void gameloop() {
		
		
		HudElements.Hud();
		
		
		/**
		 * WARNING
		 * 
		 * GAME LOOP
		 */
		if(Display.isCreated()){
			while (!Display.isCloseRequested()){
					//update();
					
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					/**TICKER*/
					if(tickStart+1000/tickRate<=System.currentTimeMillis()){
						tickStart= System.currentTimeMillis();
						tickStart= System.currentTimeMillis();
						updateTick();
						ticksPs+=1;
					}
					
					
					/**FRAME UPDATER*/
					if(secondStart2+1000/FpsRate<=System.currentTimeMillis()){
						secondStart2= System.currentTimeMillis();
						fps++;
						updateFrame();
						
					}
					/**THINGS TO DO ONCE PS*/
					if(secondStart+1000<=System.currentTimeMillis()){
						secondStart= System.currentTimeMillis();
						updateESO();
						ticksPs=0;fps=0;
					}
			}
		}
		
		
	}
	
	/**EVERY TICK OPERATIONS*/
	private static void updateTick(){
		chunk.getBlockInChunk(0, 0, 0);
	}
	/**EVERY FRAME OPERATIONS*/
	private static void updateFrame(){
		renderer.draw();
		
		Display.update();
	}
	/**EVERY SECOND OPERATIONS*/
	private static void updateESO(){
		System.out.println("TickRatePS:"+ticksPs);
		System.out.println("TickRate:"+tickRate);
		System.out.println("FPS:"+fps);
		System.out.println("FpsRate:"+FpsRate);
	}
	
	
	
	
	
	
}