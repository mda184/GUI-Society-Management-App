/*
 * This class holds methods that every class should have such as presidents and members
 */

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class society {
private JTextField text;
private JFrame frame;
public String temppres;
public String president;
public String members;
public String society;
public String val;
public Map<String, Integer> numofvotes= new TreeMap<String, Integer>();
	//Sets a new president into president file
	public void setPres(String pres){
		president = pres;
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("presidents.txt",true)))) {
   		  out.println(president);
   		  System.out.print("The president is added into the existing presidents");
   	  }
   	  catch (IOException e) {
   		  System.out.println("IO Exception.");  
   	  }
	}
	//gets the president file
	public File getPres(){
		File f = new File("presidents.txt");
		return f;
		}
	//Checks the president file for the entered president name
	public void checkPresDelete(String temppres) throws IOException{
		Scanner scanner = new Scanner(getPres());
		List<String> list = new ArrayList<>();
		while(scanner.hasNextLine()){
			list.add(scanner.nextLine());
		}
		if(list.contains(temppres)){//if name entered is a president you are allowed to delete
			new DeleteSociety();
		}
		else{//if name entered is not a president you aren't allowed to delete
			authordenied();
			
		}		
	}
	
	//Presidential Authorization
	public void deleteAuthorization() throws IOException{
	//Label for GUI presidential authorization
	JLabel label = new JLabel("Please enter your name");
	
	//Button for GUI presidential authorization
	JButton button = new JButton("OK!");
	button.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent e) {	
			temppres = text.getText();//gets text from text field
			try {
				checkPresDelete(temppres);//setsVal method
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//Searches for that name
			frame.dispose();
			
		}
	});
	
	//Text Field for authorization
	text = new JTextField();
	
	//Panel for authorization
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(3,1));
	panel.add(label);
	panel.add(text);
	panel.add(button);
	
	//Frame for authorization
	frame = new JFrame();
	frame.add(panel);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("President Aurthorization");
	final int FRAME_WIDTH = 600;
    final int FRAME_HEIGHT = 600;
    frame.setLocation(400, 200);
    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);        
    frame.setVisible(true);
    frame.setBackground(Color.BLACK);
 
	}
   
	
	
	
	
	//Authorization denied window
	public void authordenied(){
		//Label for authorization denied
		JLabel label2 = new JLabel("Authorization Denied");
		
		//Button for DENIED acceptance
		JButton button2 = new JButton("OK!");
		button2.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e1) {
				frame.dispose();				
			}				
		});
		
		//Panel for authorization denied
		JPanel panel2 = new JPanel();
		panel2.add(label2);
		panel2.add(button2);
		//Frame for authorization denied
		frame = new JFrame();
		frame.add(panel2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("President Aurthorization Denied");
		final int FRAME_WIDTH = 600;
	    final int FRAME_HEIGHT = 600;
	    frame.setLocation(400, 200);
	    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);        
	    frame.setVisible(true);
	    frame.setBackground(Color.BLACK);
	}
	
	//every class has members 
		public void setMembers(String society , String name){
			members = name;
			this.society =society;
				try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(society +"members.txt",true)))) {
			   		  out.println(members);
				} 
				catch (IOException e) {
				e.printStackTrace();
				}
			
		}
		
		public File getMembers(String society){
			File f = new File(society + "members.txt");
			return f;
		}
		


}

