/**
 * 
 */
package src.plugger.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PluggerFrame extends JFrame {

	public PluggerFrame(String string) {
		super(string);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Create the frame.
		PluggerFrame frame = new PluggerFrame("Plugger");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		this.add(new HudComp(this));
		
		this.setVisible(true);
	}
}
