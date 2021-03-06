package plugger.Entity;

import org.lwjgl.util.vector.Vector3f;

import plugger.models.TexturedModel;

public class Entity {
	


	private TexturedModel model;
	private Vector3f position;
	private float rotX,rotY,rotZ;
	private String id;
	private int weight;
	
	public Entity(String id,TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, int weight) {
		super();
		this.id=id;
		this.model=model;
		this.position=position;
		this.rotX=rotX;
		this.rotY=rotY;
		this.rotZ=rotZ;
		this.weight=weight;
	}
	
	public void changeId(String id){
		this.id=id;
	}
	
	public String getId(){
		return id;
	}
	public void increaseRotation(float dx, float dy, float dz){
		this.rotX+=dx;
		this.rotY+=dy;
		this.rotZ+=dz;
	}
	
	public void increasePosition(float dx, float dy, float dz){
		this.position.x+=dx;
		this.position.y+=dy;
		this.position.z+=dz;
	}
	
	public TexturedModel getModel() {
		return model;
	}

	public void setModel(TexturedModel model) {
		this.model = model;
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public float getRotX() {
		return rotX;
	}

	public void setRotX(float rotX) {
		this.rotX = rotX;
	}

	public float getRotY() {
		return rotY;
	}

	public void setRotY(float rotY) {
		this.rotY = rotY;
	}

	public float getRotZ() {
		return rotZ;
	}

	public void setRotZ(float rotZ) {
		this.rotZ = rotZ;
	}

	public int getWeihgt() {
		return weight;
	}

	public void setWseight(int weight) {
		this.weight = weight;
	}
	
	
	
	
}
