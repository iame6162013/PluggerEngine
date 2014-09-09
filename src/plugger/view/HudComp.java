package src.plugger.view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import src.plugger.common.GameRegistry;

public class HudComp{
	/*public void update(){
		System.out.println(fps);
	}*//*
	public HudComp(Frame frame){
		
		
		
		HudElements.Hud();
	}
	private long maxFrameRate = 50;
	public static int fps=0;
	private static Image XPBar=null;
	public void paintComponent(Graphics g){
		/**main white background*//*
		g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
		
		/**XPBar just used as an image right now*//*
		if(XPBar!=null){
			g.drawImage(XPBar, frame.getWidth()/2-XPBar.getWidth(frame)*(frame.getWidth()/160), 20,XPBar.getWidth(frame)*(frame.getWidth()/80),XPBar.getHeight(frame)*(frame.getHeight()/80), frame);
		}else{
			XPBar=ImageLoader.getImage("assets/Bar.png");
		}
		
		GameRegistry.UpdateHudMess();
		/**Something to display the Hud*//*
		if (true){
			g.setColor(Color.BLACK);
			
			for (int pointer=0;pointer<=GameRegistry.HudMessID; pointer++){
				if (GameRegistry.HudMess[pointer]!=null){
					g.drawString(GameRegistry.HudMess[pointer], 10, 15+pointer*15);
				}else{
					System.out.println("[WARNING]trying to visuallize HudMess, HudMess="+GameRegistry.HudMess[pointer]+"_"+pointer+"_"+GameRegistry.HudMessID);
				}
			}
		}
		
		
		
	}*/
	

}
