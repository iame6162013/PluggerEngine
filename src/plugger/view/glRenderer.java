package src.plugger.view;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.*;

public class glRenderer {
	public static void drawRect(float x, float y, float sx, float sy, float rot){
		glColor3f(0.25f,0f,0.75f);
		glPushMatrix();
		sx /=2;
		sy /=2;
		glTranslatef(x,y,0);
		glRotatef(rot,0,0,1);
		glBegin(GL_QUADS);{
			glVertex2f(-sx,-sy);
			glVertex2f(-sx,sy);
			glVertex2f(sx,sy);
			glVertex2f(sx,-sy);
			
		}
		glEnd();
		glPopMatrix();
	}
	
	public static void drawRect(float x, float y, float sx, float sy){
		glColor3f(0.25f,0f,0.75f);
		glPushMatrix();
		sx /=2;
		sy /=2;
		glTranslatef(x,y,0);
		glBegin(GL_QUADS);{
			glVertex2f(-sx,-sy);
			glVertex2f(-sx,sy);
			glVertex2f(sx,sy);
			glVertex2f(sx,-sy);
			
		}
		glEnd();
		glPopMatrix();
	}
	/*
	 * while (!Display.isCloseRequested()){
			glClear(GL_COLOR_BUFFER_BIT);
			glLoadIdentity();
			
			glRenderer.drawRect(0, 0, 64, 64, 0);
			glRenderer.drawRect(80, 80, 86, 86, 0);
			
			
			
			Display.update();
		}
	 */
}
