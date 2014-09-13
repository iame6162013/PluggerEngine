package src.plugger.client.renderer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.PriorityQueue;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import src.plugger.view.glRenderer;

public class Tessellator{
	
	
	
	
	public void addVertexWithUV(int coreMax, int coreMin, int coreMin2, int i, int j) {
		
		
	}
	
	public static void addHudElement(int x, int y, int sizeX, int sizeY) {
		glRenderer.drawRect(x, y, sizeX, sizeY, 0);
	}
	public static void addHudElementWithRot(int x, int y, int sizeX, int sizeY,int rot) {
		glRenderer.drawRect(x, y, sizeX, sizeY, 0);
	}
	
	
}