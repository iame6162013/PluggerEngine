package plugger.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.lwjgl.util.vector.Vector3f;

import plugger.Element.Element;
import plugger.Element.Elements;
import plugger.Entity.Entity;
import plugger.common.GameLoop;
import plugger.models.TexturedModel;

public class Chunk {
	private int CHUNK;
    
	private static int amount=0;
    private Map<TexturedModel,List<Entity>> entities = new LinkedHashMap<TexturedModel,List<Entity>>();
    
    public Chunk(int number){
    	this.CHUNK=number;
    }
    
    public void addBlock(Entity entity){
    	TexturedModel entityModel = entity.getModel();
    	List<Entity> batch = entities.get(entityModel);
    	if(batch!=null){
			batch.add(entity);
		}else{
			List<Entity> newBatch = new ArrayList<Entity>();
			newBatch.add(entity);
			entities.put(entityModel, newBatch);
		}
    	GameLoop.draw.addEntityFromWorld(0, amount);
    	amount++;
    }
    
    public void changePosBlock(int numb,Vector3f vector){
    	GameLoop.draw.removeEntityFromWorld(numb);int j=0;
    	for (Map.Entry<TexturedModel,List<Entity>> entry: entities.entrySet()){
    		if(j==numb){
    			entry.getValue().get(0).setPosition(vector);
    		}
    		j++;
    	}
    	GameLoop.draw.addEntityFromWorld(0, numb);
    }
    
    public String getId(int numb){
    	int j=0;
    	for (Map.Entry<TexturedModel,List<Entity>> entry: entities.entrySet()){
    		if(j==numb){
    			String pos = entry.getValue().get(0).getId();
    			return pos;
    		}
    		j++;
    	}
    	System.out.println("Returned null to get position from entity"+numb);
    	return null;
    }
    
    public void removeBlock(int numb){
    	GameLoop.draw.removeEntityFromWorld(numb);
    	amount--;
    }
    
    public Vector3f getPos(int numb){
    	int j=0;Vector3f pos;
    	for (Map.Entry<TexturedModel,List<Entity>> entry: entities.entrySet()){
    		if(j==numb){
    			pos = entry.getValue().get(0).getPosition();
    			return pos;
    			
    		}
    		j++;
    	}
    	System.out.println("Returned null to get position from entity"+numb);
    	return null;
    }
	
	public TexturedModel getModel(int numb){
		int j=0;
		for (Map.Entry<TexturedModel,List<Entity>> entry: entities.entrySet()){
    		if(j==numb){
    			TexturedModel TM = entry.getKey();
    			return TM;
    		}
    		j++;
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
