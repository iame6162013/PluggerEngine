package src.plugger.world.chunk;

import java.util.ArrayList;

import src.plugger.block.block;
import src.plugger.world.PossitionId;

public class chunk {
	
	private static int blockInChunk;
	private static String[] blocksId;
	//static int[][][] blockXYZ=new int[16][16][16];
	static int blockX;
	static int blockY;
	static int blockZ;
	
	static ArrayList<PossitionId> PosId =new ArrayList<PossitionId>();
	
	public static void addBlock(String id,int x,int y,int z){
		blockInChunk++;
		PosId.add("aa");
	}
	public static String getBlockInChunk(int x,int y, int z){
		
		/*System.out.println(blockXYZ[0][0][0]);
		
		if(blockXYZ[x][y][z]!=0){
			System.out.println("out");
			
			
		}*/
		
		return null;
	}
	
	/*public static void renderAllBlocks(){
		block.renderBlock(0,0,-12);
	}*/
	
	
	
}
