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

import src.plugger.client.renderer.Tessellator;
import src.plugger.common.GameLoop;
import src.plugger.view.Camera;
import src.plugger.view.HudElements;
import src.plugger.view.glRenderer;

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
	
	static Camera cam=new Camera(70,(float)Display.getWidth()/(float)Display.getHeight(),0.3f,1000);
	
<<<<<<< HEAD
	/**Main game loop */
=======
	public static Texture LoadTexture(String Key){
		try {
		return	TextureLoader.getTexture("png", new FileInputStream(new File("resources/assets/"+Key+".png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	static Texture Marble = LoadTexture("MarbleTilesFancy");
	static Texture Bar = LoadTexture("Bar");
	
>>>>>>> FETCH_HEAD
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
		
	}
	/**EVERY FRAME OPERATIONS*/
	private static void updateFrame(){
		/*glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		
		
		//glRenderer.drawRect(0, 0, 86, 86);
		//glRenderer.drawRect(400, 400, 64, 64, 0);
		
		
		Tessellator.addHudElement(100,100,50,100);
		
		Display.update();*/
		
		
		
		
		
		
		
		
		
		
		boolean forward = Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP);
		boolean backward = Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_DOWN);
		boolean left = Keyboard.isKeyDown(Keyboard.KEY_A);
		boolean right = Keyboard.isKeyDown(Keyboard.KEY_D);

		if(forward)
		cam.move(0.1f,1);
		if(backward)
		cam.move(-0.1f,1);
		if(left)
		cam.move(0.1f,0);//cam.rotateY(-0.1f);
		if(right)
		cam.move(-0.1f,0);//cam.rotateY(0.1f);

		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
		cam.rotateY(-1f);
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
		cam.rotateY(1f);
		
		
		
		
		
		
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		cam.useView();
		
		
		
		glPushMatrix();
			
			glTranslatef(0,0,-10);
			glRotatef(x,1,1,0);
			
			Bar.bind();
			
			glBegin(GL_QUADS);{
					
					//BackFace
					glColor3f(1.0f,0.6f,1f);
					glTexCoord2f(0,0);glVertex3f(-1,-1,-1);
					glTexCoord2f(0,1);glVertex3f(-1,1,-1);
					glTexCoord2f(1,1);glVertex3f(1,1,-1);
					glTexCoord2f(1,0);glVertex3f(1,-1,-1);
					//FrontFace
					glColor3f(1.0f,0.5f,1f);
					glTexCoord2f(0,0);glVertex3f(-1,-1,1);
					glTexCoord2f(0,1);glVertex3f(-1,1,1);
					glTexCoord2f(1,1);glVertex3f(1,1,1);
					glTexCoord2f(1,0);glVertex3f(1,-1,1);
					//LeftFace
					glColor3f(1.0f,0.1f,1f);
					glTexCoord2f(0,0);glVertex3f(-1,-1,-1);
					glTexCoord2f(0,1);glVertex3f(-1,-1,1);
					glTexCoord2f(1,1);glVertex3f(-1,1,1);
					glTexCoord2f(1,0);glVertex3f(-1,1,-1);
					//RightFace
					glColor3f(1.0f,0.2f,1f);
					glTexCoord2f(0,0);glVertex3f(1,-1,-1);
					glTexCoord2f(0,1);glVertex3f(1,-1,1);
					glTexCoord2f(1,1);glVertex3f(1,1,1);
					glTexCoord2f(1,0);glVertex3f(1,1,-1);
					//BottomFace
					glColor3f(1.0f,0.3f,1f);
					glTexCoord2f(0,0);glVertex3f(-1,-1,-1);
					glTexCoord2f(0,1);glVertex3f(1,-1,-1);
					glTexCoord2f(1,1);glVertex3f(1,-1,1);
					glTexCoord2f(1,0);glVertex3f(-1,-1,1);
					//TopFace
					glColor3f(1.0f,0.4f,1f);
					glTexCoord2f(0,0);glVertex3f(-1,1,-1);
					glTexCoord2f(0,1);glVertex3f(1,1,-1);
					glTexCoord2f(1,1);glVertex3f(1,1,1);
					glTexCoord2f(1,0);glVertex3f(-1,1,1);
					
			}
			glEnd();
		glPopMatrix();
		
		x+=4f;
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