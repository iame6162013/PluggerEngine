package plugger.Player;

import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;

import org.lwjgl.opengl.GL11;

import plugger.common.GameLoop;
import plugger.entities.Camera;

public class Hud {
	/*
	
	
	public boolean HudOpen=false;
	
	public void setHud(boolean hud){
		HudOpen=hud;
	}
	
	public void Hud(){
		HudOpen=true;
		
		
		
		
		if(HudOpen==true){
			float[] array =new float[3];
			try{
			
//			drawCircle3D(0,0,-0.5f,0.3f,10,1,1,0);
//			drawCircle3D(10,0,-0.5f,200,1);
//			drawCircle3D(9,0,-0.5f,200,1);
//			drawCircle3D(14,0,-0.5f,200,1);
			drawCircle3D(0,0,-0.5f,0.3f,10);
	        
	        
			}catch(Exception e){
				System.out.println(e);
			}
			//drawCircle3D(1,2,3,50000,1);
			
			//
		}
		
		
		
	}
	public float[] PivotCamera(float x, float y, float z){
		float[] Retrnables=new float[3];
		
		Retrnables[0]=-x;//+100*(Camera.yaw()/360);
		Retrnables[1]=-y;//+10*(Camera.pitch()/360);
		Retrnables[2]=-z;//*(Camera.roll()/360);
		
		//glTranslatef(-Camera.getX()+x,-Camera.getY()+y,-Camera.getZ()+z);
		
		return Retrnables;
	}
	public void drawCircle3D(float x, float y, float z ,int num_segments, int Dir){
		double x2=0;double y2=0;double z2=0;float amt= 0.5f;float angle=0;
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor4f(0.4F,0.4F,0F,0);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawing(GL11.GL_LINE_LOOP);
		for(int i = 0; i < num_segments; i++) {
			angle = (float) (2.0f * Math.PI * i / num_segments);
			if(Dir==0){x2 =x+ amt*Math.sin(angle);y2 =y+ amt*Math.cos(angle);z2 =z+ amt*Math.sin(angle);}
			if(Dir==1){x2 =x;y2 =y+ amt*Math.cos(angle);z2 =z+ amt*Math.sin(angle);}
			if(Dir==2){x2 =x+amt*Math.sin(angle);y2 =y;z2 =z+ amt*Math.sin(angle);}
			if(Dir==3){x2 =x+ amt*Math.sin(angle);y2 =y+ amt*Math.cos(angle);z2 =z;}
			tessellator.addVertex(x2, y2, z2);
		}
		tessellator.draw();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
	

	
	
	public void drawCircle3D(float x, float y, float z ,float amt,int num_segments){
		Camera camera = GameLoop.draw.camera;
		
		double x2=0;double y2=0;double z2=0;float angle=0;
		
		glTranslatef(-camera.getYaw()+x,-camera.getYaw()+y,-camera.getYaw());
		glRotatef(-camera.getRoll(),0.0f,0.0f,1.0f);
		glRotatef(-camera.getYaw(),0.0f,1.0f,0.0f);
		glRotatef(-camera.getPitch(),1.0f,0.0f,0.0f);
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor4f(0.4F,0.4F,0F,0);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawing(GL11.GL_LINE_LOOP);
		for(int i = 0; i < num_segments; i++) {
			angle = (float) (2.0f * Math.PI * i / num_segments);
			y2 =y+ amt*Math.cos(angle);
			x2 =x+ amt*Math.sin(angle);
			z2 =z;
			tessellator.addVertex(x2, y2, z2);
		}
		tessellator.draw();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
	}
	public void drawCircle3D(float x, float y, float z ,float amt,int num_segments,float x2,float y2, float z2){
		double x3=0;double y3=0;double z3=0;float angle=0;
		
		glTranslatef(0,10,5);
		/*glRotatef(-Camera.roll(),0.0f,0.0f,1.0f);
		glRotatef(-Camera.yaw(),0.0f,1.0f,0.0f);
		glRotatef(-Camera.pitch(),1.0f,0.0f,0.0f);*//*
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor4f(0.4F,0.4F,0F,0);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawing(GL11.GL_LINE_LOOP);
		for(int i = 0; i < num_segments; i++) {
			angle = (float) (2.0f * Math.PI * i / num_segments);
			y3 =y+ amt*Math.cos(angle*x2);
			x3 =x+ amt*Math.sin(angle*y2);
			z3 =z+1*Math.sin(angle*z2);
			tessellator.addVertex(x3, y3, z3);
		}
		tessellator.draw();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
	
	
	public static float opposite(float x,float base){
		float ret;float Dif=base-x;
		ret=base+Dif;
		return ret;
	}
	/*@Deprecated
	public static float opposite(float x, float amt){
		float x2=0;float ret=0;
		/*if (x>0){
		ret=x-1;
		}else if (x<0){
		ret=x+1;
		}else{
		ret=-1;
		}
		ret=x-amt;
		return ret;
	}*//*
	public static void drawLine3D(float x, float y, float z,float x2, float y2, float z2){
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor4f(0.4F,0.4F,0F,0);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawing(GL11.GL_LINE_LOOP);
		tessellator.addVertex(x, y, z);
		tessellator.addVertex(x2, y2, z2);
		tessellator.draw();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
	public static void drawLine3D(float[] x, float[] y, float[] z){
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor4f(0.4F,0.4F,0F,0);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawing(GL11.GL_LINE_LOOP);
		boolean j=true;
		for(int i=0; i<x.length&&j==true;i++){
			tessellator.addVertex(x[i], y[i], z[i]);
		}
		tessellator.draw();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
	public static void drawViewLine3D(float x, float y, float z){
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor4f(0.4F,0.4F,0F,0);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawing(GL11.GL_LINE_LOOP);
		GL11.glColor4f(0,1,0,0);
		tessellator.addVertex(x, y, z);
		tessellator.addVertex(x+1, y, z);
		
		tessellator.addVertex(x, y, z);
		tessellator.addVertex(x, y+1, z);
		
		tessellator.addVertex(x, y, z);
		tessellator.addVertex(x, y, z+1);
		
		tessellator.draw();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
	*/
}
