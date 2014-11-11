package src.plugger.world;

import java.util.Random;

import src.plugger.Element.Element;
import src.plugger.Element.Elements;
import src.plugger.util.SimplexNoise;
import src.plugger.world.chunk.Chunk;

public class world {
	
	
	
	




	public static int ChunkLoadRange=3;
	public static Chunk chunk=new Chunk();
	public static Random random = new Random(200);
	
	public static void LoadWorldFromCode(){
		
		int amount=40;
		
		/*Elements[][][] compostition=new Elements[amount][amount][amount];
		for(int x=0; x<compostition.length;x++){
			for(int y=0; y<compostition.length;y++){
				for(int z=0; z<compostition.length;z++){
					compostition[x][y][z]=new Elements();
				}
			}
			
		}*/
		
		
		
		/*Element[] elem=new Element[amount*3];
		short[] perc=new short[amount*3];
		int[] comp=new int[amount*3];*/
		
		
		
		SimplexNoise simplexNoise=new SimplexNoise(4,1,random.nextInt()*5);
		short[][][] noise=new short[amount][amount][amount];
		System.out.println("LAG!!!");
		for(int x=0;x<amount;x++){
			for(int y=0;y<amount;y++){
				for(int z=0;z<amount;z++){
					if(true){//simplexNoise.getNoise(x,y,z)<=0){
//						
//						elem[x+y+z]=Element.forAtomicNumber((int) random.nextInt(100));
//						perc[x+y+z]=(short) random.nextInt();
//						comp[x+y+z]=(int) random.nextInt();
//						compostition[x][y][z].add(elem, perc, comp);
//						addBlock(x,y,z, compostition[x][y][z]);
						noise[x][y][z]=(short) Math.abs(simplexNoise.getNoise(x,y,z));
					}	
				}
			}
			//ImageWriter.greyWritePNG(noise[x], x);
			System.out.println(x);
		}
		noise[10][1][10]=1;
		ImageWriter.greyWriteGif(noise, 0);
		
		
		
		

		
		
		
		
		
		
	}
	
	
	public static boolean addBlock(int x,int y,int z,Elements arr){
		return addBlock(x, y, z, arr,1,1,1);
	}
	public static boolean addBlock(int x,int y,int z,Elements compostition,int sizeX,int sizeY, int sizeZ){
		boolean ret=false;
		try{chunk.addBlock(x, y, z, compostition, sizeX, sizeY, sizeZ);}catch(Exception e){System.out.println(e);ret=true;}
		
		return ret;
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
