package plugger.world;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.lwjgl.util.vector.Vector3f;

import plugger.Entity.Entity;
import plugger.common.GameLoop;
import plugger.models.TexturedModel;

public class Chunk {
	private int CHUNK;
    
	private static int amount=0;
    private List<Entity> entities = new LinkedList<Entity>();
    
    public Chunk(int number){
    	this.CHUNK=number;
    }
    
    public void addBlock(Entity entity){
    	entities.add(entity);
    	GameLoop.draw.addEntityFromWorld(CHUNK, amount);
    	amount++;
    }
    
    public void changePosBlock(int numb,Vector3f vector){
    	GameLoop.draw.removeEntityFromWorld(numb);int j=0;
    	entities.get(numb).setPosition(vector);
    	GameLoop.draw.addEntityFromWorld(CHUNK, numb);
    }
    
    public String getId(int numb){
    	try{
    		return entities.get(numb).getId();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	System.out.println("Returned null to get position from entity"+numb);
    	return null;
    }
    
    public void removeBlock(int numb){
    	GameLoop.draw.removeEntityFromWorld(numb);
    	amount--;
    }
    
    public Vector3f getPos(int numb){
    	try{
    		return entities.get(numb).getPosition();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	System.out.println("Returned null to get position from entity"+numb);
    	return null;
    }
	
    public int getWeight(int numb){
    	try{
    		return entities.get(numb).getWeihgt();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	System.out.println("Returned null to get weight from entity"+numb);
    	return 0;
    }
    
	public TexturedModel getModel(int numb){
		try{
    		return entities.get(numb).getModel();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	System.out.println("Returned null to get model from entity"+numb);
		return null;
    	
	}
	
	public int getChunk(){
		return CHUNK;
	}
	
    public int size(){
    	return amount;
    }
	
	
}
