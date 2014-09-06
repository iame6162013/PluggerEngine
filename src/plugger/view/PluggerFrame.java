package src.plugger.view;

import javax.swing.*;

public class PluggerFrame extends JFrame {

	public PluggerFrame(String string) {
		super(string);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("START");
		frame();
	}
	public static void frame(){
		// Create the frame.
		PluggerFrame frame = new PluggerFrame("Plugger");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		//frame.setSize(100, 100);
		frame.add(new HudComp(frame));
		
		frame.setVisible(true);
	}
}
