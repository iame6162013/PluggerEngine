package src.plugger.common;

public abstract class Block {
	protected float x;
	protected float y;
	protected float z;
	
	protected float sx;
	protected float sy;
	protected float sz;
	
	abstract void update();
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public float getZ(){
		return z;
	}public float getSX(){
		return sx;
	}
	public float getSY(){
		return sy;
	}
	public float getSZ(){
		return sz;
	}
}
