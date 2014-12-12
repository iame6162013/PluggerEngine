package plugger.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import plugger.Element.Element;
import plugger.Element.Elements;
import plugger.entities.Entity;
import plugger.models.TexturedModel;
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
		
		int amount=2;
		
		List<Elements> compostition=new ArrayList<Elements>();
		List<Element> elem=new ArrayList<Element>();
		List<Byte> perc=new ArrayList<Byte>();
		List<Byte> comp=new ArrayList<Byte>();
		SimplexNoise simplexNoise=new SimplexNoise(4,0.5,207);
		
		
		
		
		elem.add(Element.forAtomicNumber(random.nextInt(100)));
		perc.add((byte)random.nextInt());
		comp.add((byte)random.nextInt());
		compostition.add(new Elements(elem, perc, comp));
		
		for(int x=0;x<amount;x++){
			for(int y=0;y<amount;y++){
				for(int z=0;z<amount;z++){
					if(simplexNoise.getNoise(x,y,z)>=0.0f){
						setBlock(x,y,z, compostition.get(0));
					}
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
//		//ByteBuffer buffer = BufferUtils.createByteBuffer(amount*amount*amount);
//		//short pixel=0;
//		for(int x=0;x<amount;x++){
//			for(int y=0;y<amount;y++){
//				for(int z=0;z<amount;z++){
//					if(simplexNoise.getNoise(x,y,z)>=0.5f){
//						
//						elem.add(Element.forAtomicNumber((int) random.nextInt(100)));
//						perc.add((short) random.nextInt());
//						comp.add((int) random.nextInt());
//						compostition.add(new Elements(elem, perc, comp));
//						addBlock(x,y,z, compostition.get(x));
//					}
//					//pixel = (short) (simplexNoise.getNoise(x,y,z)*255);
//					//if (pixel<0){pixel=0;}
//					//buffer.put((byte)((pixel)& 0xFF));
//				}
//			}
//			
//			System.out.println("_"+x);
//		}
//		//System.out.println("_"+((byte)(simplexNoise.getNoise(0,0,40)*255)));
//		//buffer.flip();
//		//ImageWriter.greyWriteBigAPng(buffer, 0);
		
		
		
		
	}
	
	/*
	public void processEntity(Entity entity){
		TexturedModel entityModel = entity.getModel();
		List<Entity> batch = entities.get(entityModel);
		if(batch!=null){
			batch.add(entity);
		}else{
			List<Entity> newBatch = new ArrayList<Entity>();
			newBatch.add(entity);
			entities.put(entityModel, newBatch);
		}
	}*/
	
	
	public static boolean setBlock(int x,int y,int z,Elements compostition){
		boolean ret=false;
		try{chunk.setBlock(x, y, z, compostition);}catch(Exception e){System.out.println(e);ret=true;}
		return ret;
	}
	
}