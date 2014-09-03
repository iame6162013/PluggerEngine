package src.plugger.view;

import src.plugger.common.GameRegistery;

public class HudElements {
	
	
	public static void Hud(){
		GameRegistery.addHudMess("This is the games hud here will stats be displayed");
		GameRegistery.addHudMess("FPS:"+ HudComp.fps);
		GameRegistery.addHudMess("FPS:",HudComp.class);
	}
	
	
}
