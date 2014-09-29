package src.plugger.block;

import org.newdawn.slick.opengl.Texture;

import src.plugger.common.renderer;

public class block {
	
	private String id;
	private boolean isActive;
	
	public block(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setId(){
		this.id=id;
	}
	public boolean isActive(){
		return isActive;
	}
	public void setActive(boolean isActive){
		this.isActive=isActive;
	}
	
	/*
	static Texture Bar = renderer.LoadTexture("Bar");
	public static void renderBlock(int x,int y,int z){
		Bar.bind();
		renderer.renderBaseCube(x,y,z);
	}*/
	
	
	
	
	
	
	
	
	
	
	
}
