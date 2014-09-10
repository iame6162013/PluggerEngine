package src.plugger.view;

import static org.lwjgl.opengl.GL11.GL_QUADS;

import org.lwjgl.opengl.GL11;

public class glRenderer {
	public static void drawRect(float x, float y, float sx, float sy, float rot){
		GL11.glColor3f(0.25f,0f,0.75f);
		//glClearDepth(1);
		GL11.glPushMatrix();
		sx /=2;
		sy /=2;
		GL11.glTranslatef(x,y,0);
		//glRotatef(rot,0,0,1);
		GL11.glBegin(GL_QUADS);{
			GL11.glVertex2f(-sx,-sy);
			GL11.glVertex2f(-sx,sy);
			GL11.glVertex2f(sx,sy);
			GL11.glVertex2f(sx,-sy);
			
		}
		GL11.glEnd();
		GL11.glPopMatrix();
	}
	
	public static void drawRect(float x, float y, float sx, float sy){
		GL11.glColor3f(0.25f,0f,0.75f);
		GL11.glPushMatrix();
		sx /=2;
		sy /=2;
		GL11.glTranslatef(x,y,0);
		GL11.glBegin(GL_QUADS);{
			GL11.glVertex2f(-sx,-sy);
			GL11.glVertex2f(-sx,sy);
			GL11.glVertex2f(sx,sy);
			GL11.glVertex2f(sx,-sy);
			
		}
		GL11.glEnd();
		GL11.glPopMatrix();
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
