package src.plugger.world;

import java.util.Random;

import src.plugger.Element.Element;
import src.plugger.Element.Elements;
import src.plugger.util.ImageWriter;
import src.plugger.util.SimplexNoise;
import src.plugger.world.chunk.Chunk;
import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;
public class world {
	
	
	
	
	public static int ChunkLoadRange=3;
	public static Chunk chunk=new Chunk();
	public static Random random = new Random(200);
	
	public static void LoadWorldFromCode(){
		
		int amount=40;
		
		Elements[][][] compostition=new Elements[amount][amount][amount];
		for(int x=0; x<compostition.length;x++){
			for(int y=0; y<compostition.length;y++){
				for(int z=0; z<compostition.length;z++){
					compostition[x][y][z]=new Elements();
				}
			}
			
		}
		
		
		
		Element[] elem=new Element[100];
		short[] perc=new short[100];
		int[] comp=new int[100];

		
		SimplexNoise simplexNoise=new SimplexNoise(50,0.5,207);
		//ByteBuffer buffer = BufferUtils.createByteBuffer(amount*amount*amount);
		//System.out.println("LAG!!!");
		//short pixel=0;
		for(int x=0;x<amount;x++){
			for(int y=0;y<amount;y++){
				for(int z=0;z<amount;z++){
					if(simplexNoise.getNoise(x,y,z)>=0.5f){
						
						elem[0]=Element.forAtomicNumber((int) random.nextInt(100));
						perc[0]=(short) random.nextInt();
						comp[0]=(int) random.nextInt();
						compostition[x][y][z].add(elem, perc, comp);
						addBlock(x,y,z, compostition[x][y][z]);
					}
					//pixel = (short) (simplexNoise.getNoise(x,y,z)*255);
					//if (pixel<0){pixel=0;}
					//buffer.put((byte)((pixel)& 0xFF));
				}
			}
			
			System.out.println("_"+x);
		}
		//System.out.println("_"+((byte)(simplexNoise.getNoise(0,0,40)*255)));
		//buffer.flip();
		//ImageWriter.greyWriteBigAPng(buffer, 0);
		
		
		
		
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
		
		/*while(x>=chunk.getDefaultChunkSize()){
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
		}*/
		
		return chunk.isLoaded(ChunkX, ChunkY, ChunkZ);
	}
	public static int ChunkLoadRange() {
		return ChunkLoadRange;
	}
	
	
	
}
