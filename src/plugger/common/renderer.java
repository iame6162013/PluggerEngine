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

import org.lwjgl.input.Keyboard;

public class renderer {
	
	
	public static render(){
		boolean forward = Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP);
		boolean backward = Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_DOWN);
		boolean left = Keyboard.isKeyDown(Keyboard.KEY_A);
		boolean right = Keyboard.isKeyDown(Keyboard.KEY_D);
		boolean up = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
		boolean down = Keyboard.isKeyDown(Keyboard.KEY_SPACE);
		
		if(forward)
		cam.move(0f,0f,0.1f,1);
		if(backward)
		cam.move(0f,0f,-0.1f,1);
		if(left)
		cam.move(0.1f,0f,0f,0);
		if(right)
		cam.move(-0.1f,0f,0f,0f);
		if(up)
		cam.move(0f,0.1f,0f,0);
		if(down)
		cam.move(0f,-0.1f,0f,0f);
		
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
					
					float min=1;
					float max=0;
					
					//BackFace
					glColor3f(max,0.6f,max);
					glTexCoord2f(0,0);glVertex3f(min,min,min);
					glTexCoord2f(0,max);glVertex3f(min,max,min);
					glTexCoord2f(max,max);glVertex3f(max,max,min);
					glTexCoord2f(max,0);glVertex3f(max,min,min);
					//FrontFace
					glColor3f(max,0.5f,max);
					glTexCoord2f(0,0);glVertex3f(min,min,max);
					glTexCoord2f(0,max);glVertex3f(min,max,max);
					glTexCoord2f(max,max);glVertex3f(max,max,max);
					glTexCoord2f(max,0);glVertex3f(max,min,max);
					//LeftFace
					glColor3f(max,0.4f,max);
					glTexCoord2f(0,0);glVertex3f(min,min,min);
					glTexCoord2f(0,max);glVertex3f(min,min,max);
					glTexCoord2f(max,max);glVertex3f(min,max,max);
					glTexCoord2f(max,0);glVertex3f(min,max,min);
					//RightFace
					glColor3f(max,0.2f,max);
					glTexCoord2f(0,0);glVertex3f(max,min,min);
					glTexCoord2f(0,max);glVertex3f(max,min,max);
					glTexCoord2f(max,max);glVertex3f(max,max,max);
					glTexCoord2f(max,0);glVertex3f(max,max,min);
					//BottomFace
					glColor3f(max,0.3f,max);
					glTexCoord2f(0,0);glVertex3f(min,min,min);
					glTexCoord2f(0,max);glVertex3f(0,min,min);
					glTexCoord2f(max,max);glVertex3f(max,min,max);
					glTexCoord2f(max,0);glVertex3f(min,min,max);
					//TopFace
					glColor3f(max,0.4f,max);
					glTexCoord2f(0,0);glVertex3f(min,max,min);
					glTexCoord2f(0,max);glVertex3f(max,max,min);
					glTexCoord2f(max,max);glVertex3f(max,max,max);
					glTexCoord2f(max,0);glVertex3f(min,max,max);
					
			}
			glEnd();
		glPopMatrix();
	}
	
	
	
}
