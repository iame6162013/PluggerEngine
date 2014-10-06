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
import org.lwjgl.util.glu.Sphere;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import src.plugger.block.block;
import src.plugger.client.renderer.Tessellator;
import src.plugger.view.Camera;
import src.plugger.world.PossitionId;
import src.plugger.world.world;
import src.plugger.world.chunk.Chunk;

public class renderer {
	
	private static Camera cam=new Camera(70,(float)Display.getWidth()/(float)Display.getHeight(),0.3f,1000);
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
		
		//FORWARD&BACK
		if(Keyboard.isKeyDown(Keyboard.KEY_W))
		cam.move(0.1f);
		if(Keyboard.isKeyDown(Keyboard.KEY_S))
		cam.move(-0.1f);
		
		//LEFT&RIGHT
		if(Keyboard.isKeyDown(Keyboard.KEY_A))
		cam.moveYaw(0.1f,90f);
		if(Keyboard.isKeyDown(Keyboard.KEY_D))
		cam.moveYaw(-0.1f,90f);
		
		
		//UP&DOWN
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
		cam.moveY(0.1f);
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		cam.moveY(-0.1f);
		
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD7))
		cam.rotateZ(-2f);
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD9))
		cam.rotateZ(2f);
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD4))
		cam.rotateX(-2f);
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD6))
		cam.rotateX(2f);
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD8))
		cam.rotateY(-2f);
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD2))
		cam.rotateY(2f);
		
		
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		cam.useView();
		
		
		
		
		
		
		
		
		

		
		
		Marble.bind();
		
		
		
		/*Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();{
		
		glTranslatef(0,0,-2);
		glColor3f(1f,0.6f,0f);
		tessellator.addVertexWithUV(0,0, 0,0,1);
		tessellator.addVertexWithUV(0,1,0,1,1);
		tessellator.addVertexWithUV(1,1,0,1,0);
		tessellator.addVertexWithUV(1,0, 0,0,0);
		}
		tessellator.draw();*/
		
		/*glPushMatrix();
	    glTranslatef(0, 0, -4);
	    Sphere s = new Sphere();
	    s.draw(0.9f, 4, 4);
	    glPopMatrix();*/
		
		
		Chunk chunk = Chunk.instance;
		
		for(int i=0;i<world.ChunkLoadRange(); i++){
			for(int j=0;j<world.ChunkLoadRange(); j++){
				for(int k=0;k<world.ChunkLoadRange(); k++){
					
					
					int x2=0;
					int y2=0;
					int z2=0;
					for (int x=0; x<world.chunkArray[i][j][k].getChunkSize();x++){
						for (int y=0; y<world.chunkArray[i][j][k].getChunkSize();y++){
							for (int z=0; z<world.chunkArray[i][j][k].getChunkSize();z++){
								if (world.chunkArray[i][j][k].getBlockInChunk(x, y, z) != null){
									
									x2=x;
									y2=y;
									z2=z;
									
									for(int l=i;l>0;l--){
										//System.out.println("out x"+l);
										x2+=chunk.getChunkSize();
									}
									for(int l=j;l>0;l--){
										//System.out.println("out y"+l);
										y2+=chunk.getChunkSize();
										}
									for(int l=k;l>0;l--){
										//System.out.println("out z"+l);
										z2+=chunk.getChunkSize();
									}
									renderBaseCube(x2,y2,z2);
									
									
									
								}
							}
						}
					}
					
					
					
					
					
				}
			}
		}
		
		
		
		//block.renderBlock(0, 0, -12);
		
	}
	
	
	public static void renderBaseCube(float x,float y,float z){
		glPushMatrix();
			
			glTranslatef(x,y,z);
			glBegin(GL_QUADS);{
				float min=-0.5f;
				float max=0.5f;
					
					//Marble.bind();
					
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
