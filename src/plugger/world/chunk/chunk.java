package src.plugger.world.chunk;

import src.plugger.block.block;
import src.plugger.client.renderer.Tessellator;
import src.plugger.world.PossitionId;
import src.plugger.world.galaxy.Galaxy;

public class Chunk {
//	static int ChunkX;
//	static int ChunkY;
//	static int ChunkZ;
//	
//	public static int getChunkX() {
//		return ChunkX;
//	}
//	public static void setChunkX(int chunkX) {
//		ChunkX = chunkX;
//	}
//	public static int getChunkY() {
//		return ChunkY;
//	}
//	public static void setChunkY(int chunkY) {
//		ChunkY = chunkY;
//	}
//	public static int getChunkZ() {
//		return ChunkZ;
//	}
//	public static void setChunkZ(int chunkZ) {
//		ChunkZ = chunkZ;
//	}
	
	
	
	
	
	
	static PossitionId PosId=new PossitionId();
	//public chunk instance;
	
	 public static final Chunk instance = new Chunk(20);
	
	
	
	private Chunk(int i)
    {
    }
	public void addBlock(int x,int y,int z,String Compostition,int sizeX,int sizeY, int sizeZ){
		PosId.addBlock(x, y, z, Compostition, sizeX, sizeY, sizeZ);
	}
	public String getBlockInChunk(int x,int y, int z){
		return PosId.getBlock(x,y,z);
	}
	
	public int getChunkSize(){
		return PosId.sizeChunk();
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
