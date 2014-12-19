package plugger.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import plugger.Entity.Entity;
import plugger.Player.Player;
import plugger.common.GameLoop;
import plugger.models.OBJLoader;
import plugger.models.RawModel;
import plugger.models.TexturedModel;
import plugger.textures.ModelTexture;
import plugger.util.SimplexNoise;
import plugger.world.Chunk;

import org.lwjgl.util.vector.Vector3f;
public class World {
	public byte ChunkSize = 32;
	
	public int ChunkLoadRange=3;
	public List<Chunk> chunk=new ArrayList<Chunk>();
	public Random random = new Random(200);
	public Player player;
	
	public World(){
		RawModel model = OBJLoader.loadObjModel("LitleHead", GameLoop.draw.loader);
		TexturedModel playerModel = new TexturedModel(model, new ModelTexture(GameLoop.draw.loader.loadTexture("Cube_Map - kopie")));
		player = new Player("Player", playerModel, new Vector3f(0,0,0), 0, 0, 0, 1);
		GameLoop.draw.addEntity(player);
	}
	
	public void addBlock(int x,int y,int z){
		int ChunkX=0;int ChunkY=0;int ChunkZ=0;int i=0;

		while(x>=ChunkSize){
			x-=ChunkSize;
			ChunkX++;
		}
		while(y>=ChunkSize){
			y-=ChunkSize;
			ChunkY++;
		}
		while(z>=ChunkSize){
			z-=ChunkSize;
			ChunkZ++;
		}
		while(chunk.size()<=i){
			chunk.add(new Chunk(i));
		}
		
		RawModel model = OBJLoader.loadObjModel("Cube", GameLoop.draw.loader);
		TexturedModel TModel = new TexturedModel(model, new ModelTexture(GameLoop.draw.loader.loadTexture("Cube_Map - kopie")));
		try{chunk.get(0).addBlock(new Entity("block", TModel,new Vector3f(x, y, z), 0,0,0,1));}catch(Exception e){e.printStackTrace();}
	}
	
	public Chunk getChunk(int chunkN){
		return chunk.get(chunkN);
	}
	
	public void LoadWorldFromCode(){
		System.out.println("out");
		int amount=2;
		SimplexNoise simplexNoise=new SimplexNoise(10,0.5f,207);
		for(int x=0;x<amount;x++){
			for(int y=0;y<amount;y++){
				for(int z=0;z<amount;z++){
					if(simplexNoise.getNoise(x,1,0)>=0.0f){
						addBlock(x,y,z);
					}
				}
			}
			System.out.println(x);
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
	
}