package src.plugger.world;

import src.plugger.block.block;
import src.plugger.world.chunk.Chunk;

public class world {
	
	
	
	




	public static int ChunkLoadRange=3;
	//private static chunk[][][] chunkArray = new chunk[ChunkLoadRange][ChunkLoadRange][ChunkLoadRange];
	public static Chunk[][][] chunkArray=new Chunk[ChunkLoadRange][ChunkLoadRange][ChunkLoadRange];
	
	public static void LoadWorldFromCode(){
		
		
		
		/*for(int i=0;i<10;i++){
		
		addBlock(40,i, 4, "Lol", 1, 1, 1);
		}*/
		
		addBlock(40, 4, 4, "Lol", 1, 1, 1);
		//chunk.addBlock(8, 4, 4, "Lol", 1, 1, 1);
		//chunk.addBlock(4, 4, 4, "Lol", 1, 1, 1);
		
		

		
		
		
		
		
	}
	
	
	
	
	public static void addBlock(int x,int y,int z,String Compostition,int sizeX,int sizeY, int sizeZ){
		Chunk chunk = Chunk.instance;
		
		
		
		
		
		int x3=0;
		int y3=0;
		int z3=0;
		for (int x2=0;x>=(chunk.getChunkSize());x2++){
			x-=chunk.getChunkSize();
			x3++;
		}
		for (int y2=0;y>=(chunk.getChunkSize());y2++){
			x-=chunk.getChunkSize();
			y3=y2;
		}
		for (int z2=0;z>=(chunk.getChunkSize());z2++){
			x-=chunk.getChunkSize();
			z3=z2;
		}
		System.out.println("Chunk"+x3+"_"+y3+"_"+z3+"_");
		//chunkArray[x3][y3][z3].getBlockInChunk(x3, y3, z3);//.addBlock(x, y, z, Compostition, sizeX, sizeY, sizeZ);
		//chunkArray[x3][y3][z3].addBlock(x3, y3, z3, Compostition, sizeX, sizeY, sizeZ);
		//chunkArray[0][0][0].getBlockInChunk(1, 1, 1);
	}




	public static int ChunkLoadRange() {
		return ChunkLoadRange;
	}
	
	
	
}
