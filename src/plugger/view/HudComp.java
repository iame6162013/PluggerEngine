package src.plugger.view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import src.plugger.common.GameRegistry;

public class HudComp extends JPanel implements Runnable{
	private Thread thread = new Thread(this);
	private Frame frame;
	private KeyHandler KeyHandler;
	public void update(){
		System.out.println(fps);
	}
	public HudComp(Frame frame){
		this.frame = frame;
		this.KeyHandler = new KeyHandler();
		this.frame.addKeyListener(this.KeyHandler);
		this.thread.start();
		
		
		HudElements.Hud();
	}
	private long maxFrameRate = 50;
	public static int fps=0;
	public void run() {
		int frames=0;
		long secondStart = System.currentTimeMillis();
		while(true){
			update();
			
			try {
				Thread.sleep(1000/this.maxFrameRate);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			repaint();
			
			if(secondStart+1000<=System.currentTimeMillis()){
				secondStart= System.currentTimeMillis();
				fps=frames;
				frames=0;
			}
			
			frames++;
		}
	}
	private static Image XPBar=null;
	public void paintComponent(Graphics g){
		g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
		if(XPBar!=null){
			g.drawImage(XPBar, frame.getWidth()/2-XPBar.getWidth(frame)*(frame.getWidth()/160), 20,XPBar.getWidth(frame)*(frame.getWidth()/80),XPBar.getHeight(frame)*(frame.getHeight()/80), frame);
		}else{
			XPBar=ImageLoader.getImage("assets/Bar.png");
		}
		
		System.out.println(GameRegistry.HudMessID);
		if (true){
		g.setColor(Color.BLACK);
			for (int pointer=0;pointer<=GameRegistry.HudMessID; pointer++){
				if (GameRegistry.HudMess[pointer]!=null){
					System.out.println("OUT");
					g.drawString(GameRegistry.HudMess[pointer], 10, 15+pointer*15);
				}else{
					System.out.println("[WARNING]trying to visuallize HudMess, HudMess="+GameRegistry.HudMess[pointer]+"_"+pointer+"_"+GameRegistry.HudMessID);
				}
			}
		}
		
		
		
	}
	
	private class KeyHandler implements KeyListener{
		public void keyPressed(KeyEvent e){
			//up z
			if(e.getKeyCode()==38 || e.getKeyCode()==87){
				System.out.println("up");
			}
			//Right d
			if(e.getKeyCode()==39 || e.getKeyCode()==68){
				System.out.println("Right");
			}
			//Down + s
			if(e.getKeyCode()==40 || e.getKeyCode()==83){
				System.out.println("Down");
			}
			//Left + q
			if(e.getKeyCode()==37 || e.getKeyCode()==65){
				System.out.println("Left");
			}
		}

		public void keyReleased(KeyEvent e){
			
		}

		public void keyTyped(KeyEvent e){
			
		}
		
	}
}
