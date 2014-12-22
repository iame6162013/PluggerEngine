package plugger.common;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import plugger.Player.Player;
import plugger.common.GameLoop;
import plugger.world.World;

public class GameLoop{
	public int fpsN = 0,FpsRate=60, tickRate = 60, tpsN = 0, fps=0, tps = 0;
	private long secondStart = System.currentTimeMillis();
	private long secondStart2 = System.currentTimeMillis();
	private long tickStart = System.currentTimeMillis();
	public static Drawer draw = new Drawer();
	public static World world = new World();
	public static GameLoop gameloop = new GameLoop();
	
	public static void start(){
		world.player.loadHud();
		world.LoadWorldFromCode();
		draw.initT();
		gameloop.gameloop();
		
	}
	
	/**Main game loop */
	public void gameloop() {
		
		
		/**
		 * WARNING
		 * 
		 * GAME LOOP
		 */
		if(Display.isCreated()){
			while (!Display.isCloseRequested()){
					//update();
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					/**TICKER*/
					if(tickStart+1000/tickRate<=System.currentTimeMillis()){
						tickStart= System.currentTimeMillis();
						updateTick();
						tpsN+=1;
					}
					
					
					/**FRAME UPDATER*/
					if(secondStart2+1000/FpsRate<=System.currentTimeMillis()){
						secondStart2= System.currentTimeMillis();
						fpsN++;
						updateFrame();
						
					}
					/**THINGS TO DO ONCE PS*/
					if(secondStart+1000<=System.currentTimeMillis()){
						secondStart= System.currentTimeMillis();
						updateESO();
						tps=tpsN;fps=fpsN;
						tpsN=0;fpsN=0;
						
					}
			}
		}
		
		
	}
	
	/**EVERY TICK OPERATIONS*/
	private void updateTick(){
		world.player.Input();
	}
	/**EVERY FRAME OPERATIONS*/
	private void updateFrame(){
		
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		draw.draw();
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		draw.renderText();
		
		Display.update();
	}
	/**EVERY SECOND OPERATIONS*/
	private void updateESO(){
		//System.out.println("TPS:"+tpsN+" FPS:"+fpsN);
	}

	public void cleanUp() {
		draw.cleanUp();
	}
	
	public int tps(){
		return tps;
	}
	
	public int fps(){
		return fps;
	}
	
}