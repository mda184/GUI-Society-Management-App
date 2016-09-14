/*This class contains the method for creating the first window to select create society and etc*/
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
public class Start_window extends society {

	

	JFrame frame;
	private ArrayList<String> societies;


	/**
	 * Create the application.
	 */
	public Start_window() {
		initialize(); // Calls initialize
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { //Creates the window
		
		frame = new JFrame(" MUN Society Managment");
		frame.setBounds(500, 500, 489, 357);
		frame.setLocation(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setBackground(Color.BLUE);
		
		//background image
		try {
			File currDir = new File(".");
	    String path = currDir.getAbsolutePath();
	    path = path.substring(0, path.length()-1);
	    System.out.println(path);
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(path + "src/img.jpg")))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//Creates create society button
		JButton btnNewButton = new JButton("Create Society");
		//btnNewButton.setBorder(BorderFactory.createLineBorder(Color.red));
		
		btnNewButton.addActionListener(new ActionListener() {
			//Performs the button click
			public void actionPerformed(ActionEvent event1) {
				frame.dispose();
				new NewSociety();//Calls the method newsociety to create new society
			}
		});
		
		btnNewButton.setBounds(10, 73, 146, 25);
		frame.getContentPane().add(btnNewButton);
		
		//Creates Jin society button
		
		JButton btnJoinSociety = new JButton("Join Society");
		//btnJoinSociety.setBorder(BorderFactory.createLineBorder(Color.red));

		//performs button click
		btnJoinSociety.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new JoinSociety();
			}
		});

		btnJoinSociety.setBounds(335, 73, 146, 25);
		frame.getContentPane().add(btnJoinSociety);
		
		//Creates Hold election button
		JButton btnHoldElection = new JButton("Hold Election");
		btnHoldElection.setBounds(10, 149, 146, 25);
		//btnHoldElection.setBorder(BorderFactory.createLineBorder(Color.red));
		frame.getContentPane().add(btnHoldElection);
		
		//performs button click
		btnHoldElection.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new holdElection();
				
			}
			
		});
		
		//Creates Message Society button
		JButton btnEvent = new JButton("Events");
		btnEvent.setBounds(335, 149, 146, 25);
		//btnMessageSociety.setBorder(BorderFactory.createLineBorder(Color.red));
		frame.getContentPane().add(btnEvent);
		btnEvent.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Events();
				frame.dispose();
				
			}
			
		});
		//Creates Label

		 
		JLabel lblWhatWouldYou = new JLabel("MUN Society Management");
		lblWhatWouldYou.setBounds(162, 27, 175, 16);

		lblWhatWouldYou.setForeground(Color.BLACK);
		frame.getContentPane().add(lblWhatWouldYou);
		
		//Creates Delete society button
		JButton btnDeleteSociety = new JButton("Delete Society");
		//btnDeleteSociety.setBorder(BorderFactory.createLineBorder(Color.red));
		btnDeleteSociety.addActionListener(new ActionListener() {
			
			//Performs the action of the button clicked
			public void actionPerformed(ActionEvent e) {
				try {
					deleteAuthorization();
					
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}//calls method to see if you are allowed to delete
				frame.dispose();
				
				
					
				
			}
		});
		btnDeleteSociety.setBounds(10, 223, 146, 25);
		frame.getContentPane().add(btnDeleteSociety);
		
		//Exit button
		//Login button
		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(335,223,146,25);
		frame.add(exitButton);
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				
			}
			
		});

		
	}
	
  
	
	
	


}
