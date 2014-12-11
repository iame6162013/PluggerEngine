package plugger.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import plugger.Element.Element;
import plugger.Element.Elements;
import plugger.util.ImageWriter;
import plugger.util.SimplexNoise;
import plugger.world.chunk.Chunk;
import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;
public class world {
	
	
	
	
	public static int ChunkLoadRange=3;
	public static Chunk chunk=new Chunk();
	public static Random random = new Random(200);
	
	public static void LoadWorldFromCode(){
		
		int amount=40;
		
		List<Elements> compostition=new ArrayList<Elements>();
		
		
		
		List<Element> elem=new ArrayList<Element>();
		List<Short> perc=new ArrayList<Short>();
		List<Integer> comp=new ArrayList<Integer>();

		
		SimplexNoise simplexNoise=new SimplexNoise(50,0.5,207);
		//ByteBuffer buffer = BufferUtils.createByteBuffer(amount*amount*amount);
		//System.out.println("LAG!!!");
		//short pixel=0;
		for(int x=0;x<amount;x++){
			for(int y=0;y<amount;y++){
				for(int z=0;z<amount;z++){
					if(simplexNoise.getNoise(x,y,z)>=0.5f){
						
						elem.add(Element.forAtomicNumber((int) random.nextInt(100)));
						perc.add((short) random.nextInt());
						comp.add((int) random.nextInt());
						compostition.add(new Elements(elem, perc, comp));
						//addBlock(x,y,z, compostition.get(x));
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