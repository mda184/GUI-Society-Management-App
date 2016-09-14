/* This class contains the method of newsociety which creates a newsociety
 * it builds the frame work and it creates a file to store each society 
 * seperatly into a file containing its societies name*/


import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;

public class NewSociety extends society implements ActionListener{
		
    public JFrame nsframe = new JFrame();
    
    private JTextField society_name_text;
    private JTextField id_text;
    private JTextField major_text;
    private JTextField desc_text;
    private JTextField contact_text;
    private JTextField name_text;
    
    private JLabel society_name;
    private JLabel name;
    private JLabel id;
    private JLabel major;
    private JLabel desc;
    private JLabel contact;
    
    private JButton button;
    
    
    private JPanel input_panel;
    
    
    //code for creating the society
    public void createSociety(){
    	
    File f = new File(society_name_text.getText().toLowerCase() + ".txt");
	if(f.exists() && !f.isDirectory()) { 
	    new errormessage();
	    nsframe.dispose();
	}
	else{
	try {
	   BufferedWriter outfile = new BufferedWriter(new FileWriter(society_name_text.getText().toLowerCase() + ".txt"));
	   outfile.append("societies name: ");
	   outfile.append(society_name_text.getText());
	   outfile.append("Students name: ");
	   outfile.append(name_text.getText());
	   outfile.append("Students id: ");
	   outfile.append(id_text.getText());
	   outfile.append("Major: ");
	   outfile.append(major_text.getText());
	   outfile.append("Description: ");
	   outfile.append(desc_text.getText());
	   outfile.append("Contact Info: ");
	   outfile.append(contact_text.getText());
	   outfile.close();
	   setPres(name_text.getText());
	   System.out.println(getPres());
	   nsframe.dispose();
	   new savemessage();
	   new Start_window();
	   //updating the list of socities
	   try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./societies.txt",true)))) {
 		  out.println(society_name_text.getText());
 		  System.out.print("The society is added into the existing societies");
 	  }
 	  catch (IOException e) {
 		  System.out.println("IO Exception.");  
 	  }
	   				
	}
	
	   
   catch(FileNotFoundException e) {
       System.out.println("File not found.");
   }
   catch(NullPointerException j){
       System.out.println("Null.");
   }
   catch(IOException k){
       System.out.println("IO Exception.");            
   }
};
    }    
    

    public NewSociety() {
    		

        // the clickable button
        button = new JButton("Save Society");
        button.addActionListener(this);
        button.setBorder(BorderFactory.createLineBorder(Color.red));
        
        //textField
        society_name_text = new JTextField(15);
        id_text = new JTextField();
        major_text = new JTextField();
        desc_text = new JTextField();
        contact_text = new JTextField();
        name_text = new JTextField();
        
        //label
        society_name = new JLabel("Enter you society name");
        name= new JLabel("Enter your name: ");        
        id= new JLabel("Student ID: ");
        major= new JLabel("Major: ");
        desc= new JLabel("Description: ");
        contact= new JLabel("Contact Info: ");
        
        //home button
        JButton backButton= new JButton("Go back");
    		backButton.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    				nsframe.dispose();
    				new Start_window();
    				//new NewSo
    			}
    		});
        
        
        //ADD labels and input buttons TO PANEL
    		try {
    			File currDir = new File(".");
    	    String path = currDir.getAbsolutePath();
    	    path = path.substring(0, path.length()-1);
    	    System.out.println(path);
    			nsframe.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(path + "src/pic2.jpg")))));
    		} catch (IOException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    		input_panel = new JPanel();
        
        input_panel.setLayout(new GridLayout(0,1));
        input_panel.add(society_name);
        input_panel.add(society_name_text);
        input_panel.add(name);
        input_panel.add(name_text);
        input_panel.add(id);
        input_panel.add(id_text);
        input_panel.add(major);
        input_panel.add(major_text);
        input_panel.add(desc);
        input_panel.add(desc_text);
        input_panel.add(contact);
        input_panel.add(contact_text);
        input_panel.add(button, BorderLayout.WEST);
        input_panel.add(backButton, BorderLayout.LINE_START);
        
        // set up the frame and display it
        //frame.add(buttonpanel, BorderLayout.SOUTH);
    		//frame.getContentPane().add(buttonpanel);
        nsframe.setLayout(new GridLayout(0,2));
        
        nsframe.add(input_panel, BorderLayout.CENTER);
        nsframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nsframe.setTitle("Create a New Society");
        final int FRAME_WIDTH = 600;
        final int FRAME_HEIGHT = 600;
        nsframe.setLocation(400, 200);
        nsframe.setSize(FRAME_WIDTH, FRAME_HEIGHT);        
        nsframe.setVisible(true);
        nsframe.setBackground(Color.BLACK);
    }

    // process the button clicks
    public void actionPerformed(ActionEvent event) {
    	createSociety();
    }


}
