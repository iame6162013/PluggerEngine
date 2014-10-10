package src.plugger.world;

import src.plugger.world.chunk.Chunk;

public class PossitionId {
	public int sizeChunk=32;
	public boolean isLoaded=true;
    public String[][][] IdentifierContainer=new String[sizeChunk][sizeChunk][sizeChunk];
    public double[][][] sizeBlockItemX=new double[sizeChunk][sizeChunk][sizeChunk];
    public double[][][] sizeBlockItemY=new double[sizeChunk][sizeChunk][sizeChunk];
    public double[][][] sizeBlockItemZ=new double[sizeChunk][sizeChunk][sizeChunk];
    
    public void addBlock(int x, int y, int z, String Id,double sizeX,double sizeY,double sizeZ){
    	IdentifierContainer[x][y][z]=Id;
    	sizeBlockItemX[x][y][z]=sizeX;
    	sizeBlockItemY[x][y][z]=sizeY;
    	sizeBlockItemZ[x][y][z]=sizeZ;
    }
    public String getBlock(int x,int y,int z){
    	return IdentifierContainer[x][y][z];
    }
    public int sizeChunk(){
    	return sizeChunk;
    }
    
}
