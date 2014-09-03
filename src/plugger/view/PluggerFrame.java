/**
 * 
 */
package src.plugger.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("ButtonListener.actionPerformed() was called.");
		
		// Create the frame.
		JFrame frame = new JFrame("Hi!");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// Get content pane
		Container contentPane = frame.getContentPane();
		
		// Create layout.
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
		
		// Add label.
		JLabel label = new JLabel("Good job!");
		contentPane.add(label);
		
		// Add constraints.
		layout.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, contentPane);
		
		// Display frame.
		frame.setSize(100, 100);
		frame.setVisible(true);
	}
	
}*/

public class PluggerFrame extends JFrame {
	public PluggerFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setUndecorated(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		
		this.add(new HudComp(this));
		
		this.setVisible(true);
	}
}
