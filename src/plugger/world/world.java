package src.plugger.world;

import src.plugger.world.chunk.Chunk;

public class world {
	
	
	
	




	public static int ChunkLoadRange=3;
	
	public static Chunk chunk=new Chunk();
	
	
	
	
	
	public static void LoadWorldFromCode(){
		
		addBlock(1, 1, 1, "Am^ha");
		addBlock(40, 1, 1, "Am^ha");
		
		addBlock(1, 1, 4, "Am^ha");
		for(int i=0;i<10;i++){
			
			System.out.print(addBlock(160,i, 4, "olplo?"));
		}
	}
	
	
	public static boolean addBlock(int x,int y,int z,String Compostition){
		boolean ret;
		ret = addBlock(x, y, z, Compostition,1,1,1);
		return ret;
	}
	public static boolean addBlock(int x,int y,int z,String Compostition,int sizeX,int sizeY, int sizeZ){
		boolean noProblems=true;
		int x2=0;
		int y2=0;
		int z2=0;
		
		while(x>=(chunk.getDefaultChunkSize())){
			x-=chunk.getDefaultChunkSize();
			x2++;
		}
		while(y>=(chunk.getDefaultChunkSize())){
			y-=chunk.getDefaultChunkSize();
			y2++;
		}
		while(z>=(chunk.getDefaultChunkSize())){
			z-=chunk.getDefaultChunkSize();
			z2++;
		}
		
		try{
			chunk.addBlock(x2,y2,z2, x, y, z, Compostition, sizeX, sizeY, sizeZ);
		}catch(Exception e){noProblems=false;}
		
		return noProblems;
	}
	public static boolean ischunkLoadedA(int ChunkX,int ChunkY,int ChunkZ){
		return chunk.isLoaded(ChunkX, ChunkY, ChunkZ);
	}
	public static boolean ischunkLoadedB(int x,int y,int z){
		int ChunkX=0;
		int ChunkY=0;
		int ChunkZ=0;
		
		while(x>=chunk.getDefaultChunkSize()){
			x-=chunk.getDefaultChunkSize();
			ChunkX++;
		}
		while(y>=chunk.getDefaultChunkSize()){
			y-=chunk.getDefaultChunkSize();
			ChunkY++;
		}
		while(z>=chunk.getDefaultChunkSize()){
			z-=chunk.getDefaultChunkSize();
			ChunkZ++;
		}
		
		return chunk.isLoaded(ChunkX, ChunkY, ChunkZ);
	}
	public static int ChunkLoadRange() {
		return ChunkLoadRange;
	}
	
	
	
}
