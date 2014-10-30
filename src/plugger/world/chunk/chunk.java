package src.plugger.world.chunk;

import src.plugger.Element.Element;
import src.plugger.world.PossitionId;

public class Chunk {
	public static int chunkSize=6;
	
	public static PossitionId[][][] PosId=new PossitionId[chunkSize][chunkSize][chunkSize];
	
	int CHUNK_X;
	int CHUNK_Y;
	int CHUNK_Z;
	
	public static void ChunkInit(){
		int l=chunkSize-1;
		for (int i=0; i<l; i++){
			for (int j=0; j<l; j++){
				for (int k=0; k<l; k++){
					PosId[i][j][k]= new PossitionId();
	}	}	}	}
	
	
	public void addBlock(int ChunkX,int ChunkY,int ChunkZ,int x,int y,int z,Element Compostition,int sizeX,int sizeY, int sizeZ){
		PosId[ChunkX][ChunkY][ChunkZ].addBlock(x, y, z, Compostition, sizeX, sizeY, sizeZ);
	}
	public Element getBlockInChunk(int ChunkX,int ChunkY,int ChunkZ,int x,int y, int z){
		return PosId[ChunkX][ChunkY][ChunkZ].getBlock(x,y,z);
	}
	public int getChunkSize(int ChunkX,int ChunkY,int ChunkZ){
		return PosId[ChunkX][ChunkY][ChunkZ].sizeChunk();
	}
	public boolean isLoaded(int ChunkX,int ChunkY,int ChunkZ){
		return PosId[ChunkX][ChunkY][ChunkZ].isLoaded;
	}
	public static int getDefaultChunkSize() {
		return 32;
	}

	

	
	
	
	
//	x2=x/size;
//	x3=(Math.floor(x2 * 1e0) / 1e0);
//	y2=x/size;
//	y3=(Math.floor(y2 * 1e0) / 1e0);
//	z2=x/size;
//	z3=(Math.floor(z2 * 1e0) / 1e0);
//	
//	
//	double x2= x;
//	double x3;
//	double y2= y;
//	double y3;
//	double z2= z;
//	double z3;
//	double Rand3= 30.567;
	
	
	
	
	
	
	
	
	
	
	/*public static void renderAllBlocks(){
		block.renderBlock(0,0,-12);
	}*/
	
	
	
}
