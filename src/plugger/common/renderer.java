package src.plugger.common;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex3f;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Sphere;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import src.plugger.Player.player;
import src.plugger.client.renderer.Tessellator;
import src.plugger.view.Camera;
import src.plugger.world.PossitionId;
import src.plugger.world.world;
import src.plugger.world.chunk.Chunk;

public class renderer {
	
	public static Camera cam=new Camera(70,(float)Display.getWidth()/(float)Display.getHeight(),0.3f,1000);
	private static int x=0;
	
	
	
	
	
	
	
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
	
	
	public static void draw(){
		
		
		
		Marble.bind();
		//Marble.release();
		
		
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		cam.useView();
		
		for (int x=0; x<5*Chunk.getDefaultChunkSize();x++){
			for (int y=0; y<5*Chunk.getDefaultChunkSize();y++){
				for (int z=0; z<5*Chunk.getDefaultChunkSize();z++){
					if (world.chunk.getBlockInChunk(x, y, z) != null){
						renderBaseCube(x,y,z);
					}
				}
			}
		}
		
		player.Hud();
		
		
		
	}
	
	
	public static void renderBaseCube(float x,float y,float z){
		glPushMatrix();
			
			glTranslatef(x,y,z);
			glBegin(GL_QUADS);{
				float min=0f;
				float max=1f;
					
					//BackFace
					glColor3f(max,0.6f,max);
					glTexCoord2f(0,0);glVertex3f(min,min,min);
					glTexCoord2f(0,max);glVertex3f(min,max,min);
					glTexCoord2f(max,max);glVertex3f(max,max,min);
					glTexCoord2f(max,0);glVertex3f(max,min,min);
					//FrontFace
					glColor3f(max,0.5f,max);
					glTexCoord2f(max,0);glVertex3f(max,min,max);
					glTexCoord2f(max,max);glVertex3f(max,max,max);
					glTexCoord2f(0,max);glVertex3f(min,max,max);
					glTexCoord2f(0,0);glVertex3f(min,min,max);
					//LeftFace
					glColor3f(max,0.8f,max);
					glTexCoord2f(0,0);glVertex3f(min,min,min);
					glTexCoord2f(0,max);glVertex3f(min,min,max);
					glTexCoord2f(max,max);glVertex3f(min,max,max);
					glTexCoord2f(max,0);glVertex3f(min,max,min);
					//RightFace
					glColor3f(max,0.2f,max);
					glTexCoord2f(max,0);glVertex3f(max,max,min);
					glTexCoord2f(max,max);glVertex3f(max,max,max);
					glTexCoord2f(0,max);glVertex3f(max,min,max);
					glTexCoord2f(0,0);glVertex3f(max,min,min);
					//BottomFace
					glColor3f(max,0.3f,max);
					glTexCoord2f(0,0);glVertex3f(min,min,min);
					glTexCoord2f(0,max);glVertex3f(max,min,min);
					glTexCoord2f(max,max);glVertex3f(max,min,max);
					glTexCoord2f(max,0);glVertex3f(min,min,max);
					//TopFace
					glColor3f(max,0.4f,max);
					glTexCoord2f(max,0);glVertex3f(min,max,max);
					glTexCoord2f(max,max);glVertex3f(max,max,max);
					glTexCoord2f(0,max);glVertex3f(max,max,min);
					glTexCoord2f(0,0);glVertex3f(min,max,min);
					
					
			}
			glEnd();
		glPopMatrix();
	}
	
	
	
}
