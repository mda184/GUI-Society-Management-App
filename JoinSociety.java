import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JoinSociety extends society{
	private JComboBox list;
	private JButton backButton;
	private JLabel search;
	private JPanel joinPanel;
	private JFrame joinFrame;
	private String[] societies;
	private JButton joinButton;
	private String memberName, selectedValue;
	private String[] societiesArray;
	
	public void readArray(){
		//reading every line from text file into an ArrayList strings
				BufferedReader input = null;
				try {
					input = new BufferedReader(new FileReader("./societies.txt"));
				}
				catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ArrayList<String> strings = new ArrayList<String>();
				try{
						String line = null;
						while ((line = input.readLine()) != null){
							strings.add(line);
						}
					}
				catch(IOException e){
					System.err.println("Error, file didn't exist");
					}
				finally{
					try {
						input.close();
					}
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//changing the strings in the arraylist to an array 
				societiesArray = strings.toArray(new String[]{});
	}
	public JoinSociety(){
		
		readArray();
		
		//adding the array to the the combobox
		list = new JComboBox(societiesArray);
		backButton = new JButton("Home Page");
		
		search = new JLabel("Search Society");
		
		//joinButton
		joinButton= new JButton("Join me");
		joinButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e1){
				selectedValue = list.getSelectedItem().toString();
				memberName= JOptionPane.showInputDialog("Please input your name:");
				System.out.println("The member name is: " + memberName);
				setMembers(selectedValue ,memberName);
				
			}
		});
		
		//button functionality
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				joinFrame.dispose();
				new Start_window();
				//new NewSo
			}
		});
		
		//add to panel
		
		joinPanel = new JPanel();
		
		joinPanel.add(search);
		joinPanel.add(list, BorderLayout.AFTER_LAST_LINE);
		joinPanel.add(backButton, BorderLayout.SOUTH);
		joinButton.setPreferredSize(new Dimension(100, 40));
		joinPanel.add(joinButton, new GridLayout());
		
		
		joinButton.setLocation(88, 0);
		
		
		
	//add to frame
		
		joinFrame= new JFrame();
		joinFrame.add(joinPanel);
		
		joinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		joinFrame.setTitle("Join Society");
		joinFrame.setVisible(true);
		joinFrame.setLocation(400,200);
		joinFrame.setSize(600, 600);
	}	
}


