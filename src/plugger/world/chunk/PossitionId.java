package plugger.world.chunk;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import plugger.Element.Element;
import plugger.Element.Elements;
import plugger.world.chunk.Chunk;

public class PossitionId {
	private byte sizeChunk=32;
	public boolean isLoaded=true;
    private List<Elements> IdentifierContainer=new ArrayList<Elements>();
    private List<Vector3f> position = new ArrayList<Vector3f>();
    public PossitionId(){}
    
    public int size(){
    	return position.size();
    }
    public void setBlock(Vector3f poss, Elements compostition){
    	int j = position.size();
    	int i=0;
    	if(position.contains(poss)){
    		while(!position.get(i).equals(poss)){
        		i++;
        	}
    		position.add(poss);
        	IdentifierContainer.set(i, compostition);
    	}else{
    		position.add(poss);
    		IdentifierContainer.add(compostition);
    	}
    	
    }
    public Elements getBlock(Vector3f poss){
    	int i=0;
    	if(position.contains(poss)){
    		
    		while(!position.get(i).equals(poss)){
        		i++;
        	}
        	return IdentifierContainer.get(i);
    	}
    	return null;
    }
    public Vector3f getPos(int numb){
    	return position.get(numb);
    }
}
