package src.plugger.world;

import src.plugger.Element.Element;
import src.plugger.world.chunk.Chunk;

public class PossitionId {
	public int sizeChunk=32;
	public boolean isLoaded=true;
    public Element[][][] IdentifierContainer=new Element[sizeChunk][sizeChunk][sizeChunk];
    public double[][][] sizeBlockItemX=new double[sizeChunk][sizeChunk][sizeChunk];
    public double[][][] sizeBlockItemY=new double[sizeChunk][sizeChunk][sizeChunk];
    public double[][][] sizeBlockItemZ=new double[sizeChunk][sizeChunk][sizeChunk];
    
    public void addBlock(int x, int y, int z, Element h,double sizeX,double sizeY,double sizeZ){
    	IdentifierContainer[x][y][z]=h;
    	sizeBlockItemX[x][y][z]=sizeX;
    	sizeBlockItemY[x][y][z]=sizeY;
    	sizeBlockItemZ[x][y][z]=sizeZ;
    }
    public Element getBlock(int x,int y,int z){
    	return IdentifierContainer[x][y][z];
    }
    public int sizeChunk(){
    	return sizeChunk;
    }
    
}
