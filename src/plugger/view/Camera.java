package src.plugger.view;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

public class Camera {
	
	private float x;
	private float y;
	private float z;
	private float rx;
	private float ry;
	private float rz;
	
	private float fov;
	private float aspect;
	private float nearClip;
	private float farClip;
	
	
	public Camera(float fov, float aspect, float nearClip, float farClip){
		x=0;
		y=0;
		z=0;
		rx=0;
		ry=0;
		rz=0;
		
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
		
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_TEXTURE_2D);
		
	}
	
	public void useView(){
		//glTranslatef(-x,-y,-z);
		/*glRotatef(rx,1f,0f,0f);
		glRotatef(ry,0f,1f,0f);
		glRotatef(rz,0f,0f,1f);*/
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
	public float getRX(){
		return x;
		
	}
	public float getRY(){
		return y;
		
	}
	public float getRZ(){
		return z;
		
	}
	public void setRX(float rx){
		this.rx=rx;
	}
	public void setRY(float ry){
		this.ry=ry;
	}
	public void setRZ(float rz){
		this.ry=rz;
	}
	public void move(float amtX,float amtY,float amtZ, float dir){
	
	x += amtX * Math.cos(Math.toRadians(rx +90* dir));
	y += amtY * Math.cos(Math.toRadians(ry +90* dir));
	z += amtZ * Math.sin(Math.toRadians(rz +90* dir));
	}
	public void rotateY(float amt){
		System.out.println(ry);
		ry += amt;
	}
	public void rotateX(float amt){
		System.out.println(rx);
		rz += amt;
	}
	public void rotateZ(float amt){
		System.out.println(rz);
		rx += amt;
	}
	
	
}
