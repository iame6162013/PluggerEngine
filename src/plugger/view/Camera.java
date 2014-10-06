package src.plugger.view;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

public class Camera {
	
	private float x;
	private float y;
	private float z;
	private float yaw;
	private float pitch;
	private float roll;
	
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
		
		System.out.println("out");
		
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
		glTranslatef(x,y,z);
	}
	
	public float getX(){
		return x;
		
	}
	public float getY(){
		return y;
		
	}
	public float getZ(){
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
	public float yaw(){
		return yaw;
		
	}
	public float pitch(){
		return pitch;
		
	}
	public float roll(){
		return roll;
		
	}
	public void setYaw(float yaw){
		this.yaw=yaw;
	}
	public void setPitch(float pitch){
		this.pitch=pitch;
	}
	public void setRoll(float roll){
		this.roll=roll;
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
		pitch += amt;
	}
	public void rotateX(float amt){
		yaw += amt;
	}
	public void rotateZ(float amt){
		roll += amt;
	}
	
	
}
