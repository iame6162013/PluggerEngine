package src.plugger.Player;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;

import src.plugger.client.renderer.Tessellator;
import src.plugger.common.renderer;
import src.plugger.view.Camera;

public class player {
	
	public static boolean HudOpen=false;
	
	
	
	public static void setHud(boolean hud){
		HudOpen=hud;
	}
	
	public static void Hud(){
		HudOpen=true;
		
		
		
		
		if(HudOpen==true){
			float[] array =new float[3];
			array =PivotCamera(1,4,2);//Camera.getX(),Camera.getY(),Camera.getZ()+2);
			drawCircle3D(array[0],array[1],array[2],1000,Camera.pitch(),Camera.yaw(),Camera.roll());
			
			
			//drawCircle3D(1,2,3,50000,1);
			
			//
		}
		
		
		
	}
	public static float[] PivotCamera(float x, float y, float z){
		float[] Retrnables=new float[3];
		
		float x2=x-Camera.getX();
		float y2=y-Camera.getZ();
		float z2=z-Camera.getY();
		
		Retrnables[0]=x;//+100*(Camera.yaw()/360);
		Retrnables[1]=y;//+10*(Camera.pitch()/360);
		Retrnables[2]=z;//*(Camera.roll()/360);
		return Retrnables;
	}
	public static void drawCircle3D(float x, float y, float z ,int num_segments, int Dir){
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
	

	
	
	public static void drawCircle3D(float x, float y, float z ,int num_segments, float DirP, float DirY, float DirR){
		double x2=0;double y2=0;double z2=0;float amt= 0.5f;float dirP=0;float dirY; float angle=0;
		
		
		
		float j= Camera.yaw()/360;
		boolean k=false;
		if (j>1){
			j--;
			k=true;
		}
		//System.out.println(j+"_"+k);
		
		
		
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor4f(0.4F,0.4F,0F,0);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawing(GL11.GL_LINE_LOOP);
		for(int i = 0; i < num_segments; i++) {
			angle = (float) (2.0f * Math.PI * i / num_segments);
			
			
			DirP=(float) Math.toRadians(180);
			dirP=DirP;
			DirY=1;
			dirY=DirY/360;
			
			
			
			
//			x2 =x+ amt*Math.sin(angle*1.7);
//			y2 =y+ amt*Math.cos(angle*0.6);
//			z2 =z+ amt*Math.sin(angle*0.0f);
			
			//j=-0.5f;
			float l=1.0f;
			
			
			y2 =y+ amt*Math.cos(angle);
			
			
			x2 =x+ amt*Math.sin(angle)*(opposite(j,0.5f));
			z2 =z+ amt*Math.sin(angle)*(opposite(-j,0.5f));
			
			
			
			
			
			
			
			//Working for j=0.75
//			y2 =y+ amt*Math.cos(angle);
//			x2 =x+ amt*Math.sin(angle*1)/(j+1);
//			z2 =z+ amt*Math.sin(angle)/(j+1);
			
			//Working for j=1
			//y2 =y+ amt*Math.cos(angle);
			//x2 =x+ amt*Math.sin(angle);
			//z2 =z+ amt*Math.sin(opposite(angle,0.5f)*opposite(j,1f));
			
			tessellator.addVertex(x2, y2, z2);
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
	}*/
	
	
	
	
	
	
	
	
	
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

	public static void Input() {
		Camera cam=renderer.cam;
		//FORWARD&BACK
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){cam.move(0.1f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){cam.move(-0.1f);}
		//LEFT&RIGHT
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){cam.moveYaw(0.1f,90f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){cam.moveYaw(-0.1f,90f);}
		//UP&DOWN
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){cam.moveY(0.1f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){cam.moveY(-0.1f);}
		//Roll
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD7)){cam.rotateZ(-2f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD9)){cam.rotateZ(2f);}
		//Yaw
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD4)){cam.rotateX(-2f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD6)){cam.rotateX(2f);}
		//Pitch
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD8)){cam.rotateY(-2f);}
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD2)){cam.rotateY(2f);}
		
		
		
		//Special ones!
		
		//turn Yaw 180°
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD3)){Camera.setYaw(Camera.yaw()+180);}
		//if(true){Camera.setYaw(Camera.yaw());}
		
		//output Yaw
		if(Keyboard.isKeyDown(Keyboard.KEY_Y)){System.out.println("Yaw:"+Camera.yaw()+"___"+Camera.yaw()/360);}
		//if(true){System.out.println("Yaw:"+Camera.yaw());}
		
		
		//Just to see what i'm doing must be changed often
		if(Keyboard.isKeyDown(Keyboard.KEY_O)){System.out.println("OUTPUT SPECIAL THINGY:"+			opposite(-0.5f,0.5f)	);}
		
	}
	
	
}
