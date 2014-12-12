package plugger.world.chunk;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import plugger.Element.Element;
import plugger.Element.Elements;
import plugger.world.chunk.PossitionId;

public class Chunk {
	public int chunkSize=6;
	public byte ChunkSize = 32;
	public List<PossitionId> PosId=new ArrayList<PossitionId>();
	
	
	int CHUNK_X;
	int CHUNK_Y;
	int CHUNK_Z;
	
	public int ObjInChunk(int chunk){
		return PosId.get(chunk).size();
	}
	
	public Vector3f getPos(int chunk, int numb){
		return PosId.get(chunk).getPos(numb);
	}
	
	public void setBlock(int x,int y,int z,Elements compostition){
		int ChunkX=0;int ChunkY=0;int ChunkZ=0;int i=1;

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
		while(PosId.size()<i){
			PosId.add(new PossitionId());
		}
		PosId.get(0).setBlock(new Vector3f(x, y, z), compostition);
	}
	
	public Elements getBlockInChunk(int x,int y, int z){
		int ChunkX=0;int ChunkY=0;int ChunkZ=0;int i=1;

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
		while(PosId.size()<i){
			PosId.add(new PossitionId());
		}
		return PosId.get(0).getBlock(new Vector3f(x,y,z));
	}

	
	
	
}
