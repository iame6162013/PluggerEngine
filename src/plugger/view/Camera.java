package src.plugger.view;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

public class Camera {
	
	private static float x;
	private static float y;
	private static float z;
	private static float yaw;
	private static float pitch;
	private static float roll;
	
	private float fov;
	private float aspect;
	private float nearClip;
	private float farClip;
	
	
	public Camera(float fov, float aspect, float nearClip, float farClip){
		x=0;
		y=0;
		z=0;
		yaw=0;
		pitch=0;
		roll=0;
		
		
		
		this.fov=fov;
		this.aspect=aspect;
		this.nearClip=nearClip;
		this.farClip=farClip;
		initProjectuion();
	}
	
	private void initProjectuion(){
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(fov,aspect,nearClip,farClip);
		glMatrixMode(GL_MODELVIEW);
		
		glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);
		
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_TEXTURE_2D);
		
	}
	
	public void useView(){
		glRotatef(pitch,1.0f,0.0f,0.0f);
		glRotatef(yaw,0.0f,1.0f,0.0f);
		glRotatef(roll,0.0f,0.0f,1.0f);
		glTranslatef(x, y, z);
	}
	
	public static float getX(){
		return x;
		
	}
	public static float getY(){
		return y;
		
	}
	public static float getZ(){
		return z;
		
	}
	public void setX(float x){
		this.x=x;
	}
	public void setY(float y){
		this.y=y;
	}
	public void setZ(float z){
		this.z=z;
	}
	public static float yaw(){
		return yaw;
		
	}
	public static float pitch(){
		return pitch;
		
	}
	public static float roll(){
		return roll;
		
	}
	public static void setYaw(float i){
		yaw=i;
		while(yaw>360){
			yaw-=360;
		}
		while(yaw<0){
			yaw+=360;
		}
	}
	public static void setPitch(float i){
		pitch=i;
		while(pitch>360){
			pitch-=360;
		}
		while(pitch<0){
			pitch+=360;
		}
	}
	public static void setRoll(float i){
		roll=i;
		while(roll>360){
			roll-=360;
		}
		while(roll<0){
			roll+=360;
		}
	}
	
	
	
	public void move(float amt){
		//LEFT&RIGHT
		x += amt * Math.sin(Math.toRadians(-yaw));
		//FORWARD&BACK
		z += amt * Math.sin(Math.toRadians(yaw+90));
		//UP&DOWN
		y += amt * Math.cos(Math.toRadians(-pitch+90));
		
	}
	public void moveYaw(float amt, float yaw){
		//LEFT&RIGHT
		x += amt * Math.sin(Math.toRadians(this.yaw+yaw));
		//FORWARD&BACK
		z += amt * Math.sin(Math.toRadians(this.yaw-yaw+90));
	}
	public void moveY(float amt){
		//UP&DOWN
		y += amt;
	}
	public void rotateY(float amt){
		System.out.println(pitch);
		pitch += amt;
		while(pitch>360){
			pitch-=360;
		}
		while(pitch<0){
			pitch+=360;
		}
	}
	public void rotateX(float amt){
		System.out.println(yaw);
		yaw += amt;
		while(yaw>360){
			yaw-=360;
		}
		while(yaw<0){
			yaw+=360;
		}
	}
	public void rotateZ(float amt){
		System.out.println(roll);
		roll += amt;
		while(roll>360){
			roll-=360;
		}
		while(roll<0){
			roll+=360;
		}
	}
	
	
}
