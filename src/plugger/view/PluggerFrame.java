/**
 * 
 */
package plugger.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class ButtonListener implements ActionListener {

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
	
}

/**
 * @author Leander
 *
 */
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
		
		// Get content pane
		Container contentPane = frame.getContentPane();
		
		// Create layout.
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		contentPane.setLayout(layout);
		
		// Add button.
		JButton button = new JButton("Hi!");
		contentPane.add(button);
		
		// Add event.
		button.addActionListener(new ButtonListener());
		
		// Display frame.
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
