package plugger.world.chunk;

import plugger.Element.Element;
import plugger.Element.Elements;
import plugger.world.chunk.PossitionId;

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
	
	
	public void addBlock(int x,int y,int z,Elements compostition,int sizeX,int sizeY, int sizeZ){
		int x2=0;
		int y2=0;
		int z2=0;
		
		while(x>=(getDefaultChunkSize())){
			x-=getDefaultChunkSize();
			x2++;
		}
		while(y>=(getDefaultChunkSize())){
			y-=getDefaultChunkSize();
			y2++;
		}
		while(z>=(getDefaultChunkSize())){
			z-=getDefaultChunkSize();
			z2++;
		}
		
		
		PosId[x2][y2][z2].addBlock(x, y, z, compostition, sizeX, sizeY, sizeZ);
	}
	public Elements getBlockInChunk(int x,int y, int z){
		int x2=0;
		int y2=0;
		int z2=0;
		
		while(x>=(getDefaultChunkSize())){
			x-=getDefaultChunkSize();
			x2++;
		}
		while(y>=(getDefaultChunkSize())){
			y-=getDefaultChunkSize();
			y2++;
		}
		while(z>=(getDefaultChunkSize())){
			z-=getDefaultChunkSize();
			z2++;
		}
		return PosId[x2][y2][z2].getBlock(x,y,z);
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
	
	
	
}
