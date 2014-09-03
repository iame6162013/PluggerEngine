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
