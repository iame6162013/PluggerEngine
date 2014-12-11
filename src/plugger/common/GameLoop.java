package plugger.common;

import org.lwjgl.opengl.Display;

import plugger.Player.Player;
import plugger.common.GameLoop;

public class GameLoop{
	private static final int maxFrameRate = 50;
	
	private static int frames=0;
	static int fps = 0;
	static int FpsRate=60;
	static int tick = 0;
	static int tickRate = 20;
	static int ticksPs = 0;
	static long secondStart = System.currentTimeMillis();
	static long secondStart2 = System.currentTimeMillis();
	static long tickStart = System.currentTimeMillis();
	static float x=0;
	public static Drawer draw = new Drawer();
	public static Player player = new Player();
	
	public static void start(){
		
		
		//Chunk.ChunkInit();
		//world.LoadWorldFromCode();
		GameLoop.gameloop();
	}
	
	/**Main game loop */
	public static void gameloop() {
		
		
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
		player.Input();
		System.gc();
	}
	/**EVERY FRAME OPERATIONS*/
	private static void updateFrame(){
		draw.draw();
		Display.update();
		System.gc();
	}
	/**EVERY SECOND OPERATIONS*/
	private static void updateESO(){
		//System.out.println("TickRatePS:"+ticksPs);
		System.out.println("TickRate:"+tickRate+" FPS:"+fps);
		System.out.println();
		//System.out.println("FpsRate:"+FpsRate);*/
	}

	public static void cleanUp() {
		draw.cleanUp();
	}
	
	
	
	
	
	
}