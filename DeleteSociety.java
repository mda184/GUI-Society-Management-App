import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DeleteSociety extends society{
	private JFrame frame = new JFrame();
	private JLabel label;
	private JButton button;
	private JComboBox combo;
	private JPanel panel;
	private JPanel button_panel;
	private String contents;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	

	public DeleteSociety() throws IOException{
		
		//Checks the  authorization if name equals president delete is good to go if not not allowed to delete
		
		
		
        //Create label
        label = new JLabel("Select the name of the Society you would like to delete");
        
        //Set up combobox
        
        
        BufferedReader input = new BufferedReader(new FileReader("societies.txt"));
        ArrayList<String> strings = new ArrayList<String>();
        try {
          String line = null;
          while (( line = input.readLine()) != null){
            strings.add(line);
          }
        }

        catch (FileNotFoundException e) {
            System.err.println("Error, file " + "societies.txt" + " didn't exist.");
        }
        
            try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        

        String[] lineArray = strings.toArray(new String[]{});

        combo = new JComboBox(lineArray);
      
        //Create button to click
      		button = new JButton("Delete Society");
      	    button.setSize(12,18);
            
      		button.addActionListener(new ActionListener(){
      			public void actionPerformed(ActionEvent e1){
      				contents = combo.getSelectedItem().toString();
      				File f = new File(contents + ".txt");
      		      	if(f.exists() && !f.isDirectory()) { 
      		      		
      		      		f.delete();
      		      	
      		      	File inputFile = new File("societies.txt");
          		    File tempFile = new File("myTempFile.txt");

          		    
    				try {
    					reader = new BufferedReader(new FileReader(inputFile));
    				} catch (FileNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
          		   
    				try {
    					writer = new BufferedWriter(new FileWriter(tempFile));
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}

          		    String lineToRemove = contents;
          		    String currentLine;

          		    try {
    					while((currentLine = reader.readLine()) != null) {
    					    // trim newline when comparing with lineToRemove
    					    String trimmedLine = currentLine.trim();
    					    if(trimmedLine.equals(lineToRemove)) continue;
    					    writer.write(currentLine + System.getProperty("line.separator"));
    					}
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
          		    try {
    					writer.close();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} 
          		    try {
    					reader.close();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
          		            				
          		inputFile.delete();
          		tempFile.renameTo(inputFile);
      		      		frame.dispose();
      		      		new deletedmessage();
      		      	}
      		      	
      		       
      		      	else{
      		      		frame.dispose();
      		      		new errormessage2();
      		      	};
      		    
      			}});
      		button.setBorder(BorderFactory.createLineBorder(Color.blue));
      		
      	   
        
        //Add button to South position of panel
        button_panel = new JPanel();
        button_panel.setLayout(new BorderLayout());
      
        button_panel.add(button, BorderLayout.NORTH);
        button.setPreferredSize(new Dimension(100, 40));
        //Add label and text field to panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(6,2));
        panel.add(label);
        panel.add(combo);
        
     // set up the frame and display it
        frame.add(button_panel, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Create a New Society");
        final int FRAME_WIDTH = 300;
    	final int FRAME_HEIGHT = 400;
    	frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);        
        frame.setVisible(true);
        
     


		
	}
	
	

	
	
}
