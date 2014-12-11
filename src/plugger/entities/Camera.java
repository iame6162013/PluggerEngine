package plugger.entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
	
	private Vector3f postition = new Vector3f(0,0,0);
	private float yaw;
	private float pitch;
	private float roll;
	
	public Camera(){}
	
	
	public void move(float amt){
		//LEFT&RIGHT
		postition.x -= amt * Math.sin(Math.toRadians(-yaw));
		//FORWARD&BACK
		postition.z -= amt * Math.sin(Math.toRadians(yaw+90));
		//UP&DOWN
		postition.y -= amt * Math.cos(Math.toRadians(-pitch+90));
		
	}
	public void moveYaw(float amt, float yaw){
		//LEFT&RIGHT
		postition.x -= amt * Math.sin(Math.toRadians(this.yaw+yaw));
		//FORWARD&BACK
		postition.z -= amt * Math.sin(Math.toRadians(this.yaw-yaw+90));
	}
	public void moveY(float amt){
		//UP&DOWN
		postition.y -= amt;
	}
	public void rotateY(float amt){
		pitch += amt;
		while(pitch>360){
			pitch-=360;
		}
		while(pitch<0){
			pitch+=360;
		}
	}
	public void rotateX(float amt){
		yaw += amt;
		while(yaw>360){
			yaw-=360;
		}
		while(yaw<0){
			yaw+=360;
		}
	}
	public void rotateZ(float amt){
		roll += amt;
		while(roll>360){
			roll-=360;
		}
		while(roll<0){
			roll+=360;
		}
	}
	public Vector3f getPostition() {
		return postition;
	}
	public void setPostition(Vector3f postition) {
		this.postition = postition;
	}
	public float getYaw() {
		return yaw;
	}
	public float getPitch() {
		return pitch;
	}

	public float getRoll() {
		return roll;
	}
	
	
	
}
