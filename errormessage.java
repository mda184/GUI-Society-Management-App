/*
 * This class contains the method for error message window 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class errormessage implements ActionListener {
	private JFrame frame = new JFrame();
	private JLabel savemess;
	private JPanel panel; 
	private JButton button;
//	
	public errormessage(){
		savemess = new JLabel("Error as occured Society is already created");
		savemess.setFont(new Font("Courier",Font.ROMAN_BASELINE,12));
		savemess.setForeground(Color.MAGENTA);
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
        panel.add(savemess, BorderLayout.CENTER);
        
        button = new JButton("OK");
        button.addActionListener(this);
        panel.add(button, BorderLayout.SOUTH);
		
		// set up the frame and display it
        
		frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Save message");
        final int FRAME_WIDTH = 300;
    	final int FRAME_HEIGHT = 400;
    	frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);        
        frame.setVisible(true);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		
	}

}
