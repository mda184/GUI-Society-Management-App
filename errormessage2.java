import javax.swing.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class errormessage2 implements ActionListener {
	private JFrame frame = new JFrame();
	private JLabel savemess;
	private JPanel panel; 
	private JButton button;
	
	public errormessage2(){
		savemess = new JLabel("No society to delete");
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
        panel.add(savemess, BorderLayout.CENTER);
        
        button = new JButton("OK");
        button.setBorder(BorderFactory.createLineBorder(Color.red));
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
