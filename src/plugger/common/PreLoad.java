package src.plugger.common;

import src.plugger.Element.Element;
import src.plugger.view.Camera;
import src.plugger.world.chunk.Chunk;

public class PreLoad {
	
	public static void preLoad(){
		Chunk.ChunkInit();
		
		
		
		System.out.println(Element.forAtomicNumber(1));
	}
	
}
