import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class holdElection extends society{
	
	private JFrame frame;
	private JFrame frame2;
	private JButton button;
	private JComboBox list;
	private String selectedValue;
	private JButton button2;
	public int total = 0;
	public Map<String, Integer> votes= new TreeMap<String, Integer>();
	
	public void createFrame1(){ //Creates frame to select the society to hold an election
		//set up label for frame
				JLabel label = new JLabel("What society would you like to hold the election for");
		//set up combobox
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
				String[] societiesArray = strings.toArray(new String[]{});
				
				
				
				//adding the array to the the combobox
				list = new JComboBox(societiesArray);
				
				//Pick Button
				button= new JButton("Hold Election");
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e1){
						//int n =1;
						selectedValue = list.getSelectedItem().toString();
						/*String path = "./"+selectedValue + list.getSelectedIndex();
						File file = new File(path);
						if(file.exists()){
							System.out.println("File exists");
							try {
								BufferedReader bf = new BufferedReader(new FileReader(file));
								String string ="";
								int line;
								try {
									while((bf.readLine()) !=null){
										string = bf.readLine(); // reading string
										line = Integer.parseInt(string); // converting string to int
										line += n; // adding one vote
										FileWriter fw = new FileWriter(file,false);	
										fw.write(Integer.toString(line));
										fw.close();
									}
									bf.close();
								}
								catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else{
								File newfile = new File(selectedValue + list.getSelectedIndex()+ ".txt");
								try {
									PrintWriter out = new PrintWriter(newfile);									
									out.write(Integer.toString(n));
									out.close();
								}
								catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						System.out.println("vote is added");
						frame.dispose();*/
						createFrame2(getMembers(selectedValue));
				}
				});
				
				//add to panel
				JPanel Panel = new JPanel();
				Panel.add(label);
				Panel.add(list, BorderLayout.AFTER_LAST_LINE);
				Panel.add(button);
				
				
			//add to frame
				frame= new JFrame();
				
				frame.add(Panel);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Which society");
				frame.setVisible(true);
				frame.setLocation(400,200);
				frame.setSize(600, 600);
			}
	
	public void createFrame2(File file){//Creates frame of members to select to vote for
		//set up label for frame
		JLabel label = new JLabel("What member would you like to vote for president");
//set up combobox
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(file));
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
		String[] societiesArray = strings.toArray(new String[]{});
		
		
		
		//adding the array to the the combobox
		list = new JComboBox(societiesArray);
		
		//Vote Button 
		button= new JButton("Vote");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e1){//vote button doesnt't do anything yet
				selectedValue = list.getSelectedItem().toString();
				//addVote(selectedValue);
				frame.dispose();
				new Start_window();
							
		}
		});
		
		button2 = new JButton("Vote over");
		button2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//getVotes();
				frame.dispose();
				new Start_window();
				
			}
			
		});
		
		//add to panel
		JPanel Panel = new JPanel();
		Panel.add(label);
		Panel.add(list, BorderLayout.AFTER_LAST_LINE);
		Panel.add(button);
		
		
	//add to frame
		frame2= new JFrame();
		
		frame2.add(Panel);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setTitle("Which society");
		frame2.setVisible(true);
		frame2.setLocation(400,200);
		frame2.setSize(600, 600);
	}		
	
	
	
	public holdElection(){
		createFrame1();
		
	}

}
