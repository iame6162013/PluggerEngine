package src.plugger.common;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GetInput {
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
