package src.plugger.Player;

import org.lwjgl.opengl.*;

import src.plugger.client.renderer.Tessellator;
import src.plugger.view.Camera;

public class player {
	
	public static boolean HudOpen=false;
	
	
	
	public static void setHud(boolean hud){
		HudOpen=hud;
	}
	
	public static void Hud(){
		HudOpen=true;
		
		
		double x=Camera.getX();double x2;
		double y=Camera.getY();double y2;
		double z=Camera.getZ()+4;double z2;
		int num_segments=25;
		
		
		
		if(HudOpen==true){
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glColor4f(0.4F,0.4F,0F,0);
			Tessellator tessellator = Tessellator.instance;
			tessellator.startDrawing(GL11.GL_LINES);
			
			for(int i = 0; i < num_segments; i++) {
				float angle = (float) (2.0f * Math.PI * i / num_segments);
				
				x2 =-x+ 0.5f*Math.sin(angle);
				y2 =-y+ 0.5f*Math.cos(angle);
				z2 =-z+ 0.5f*Math.sin(angle);
				  
				tessellator.addVertex(x2, y2, z2);
			}
			System.out.println("X"+(int)x+" Y"+(int)y+" Z"+(int)z);
			tessellator.draw();
			GL11.glEnable(GL11.GL_TEXTURE_2D);

			
			
			
			
			
			
			
			
		}
		
		
		
	}
	
	
	
	
	
}
