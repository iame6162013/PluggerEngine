package src.plugger.view;

import src.plugger.common.GameRegistry;
import java.lang.reflect.Field;

public class HudElements {
	
	
	public static void Hud(){
		//GameRegistery.addHudMess("This is the games hud here will stats be displayed");
		try {GameRegistry.addHudMess("FPS:",HudComp.class,"fps");} catch (NoSuchFieldException e) {e.printStackTrace();}
		
		
		
		
	}
	
	
}
