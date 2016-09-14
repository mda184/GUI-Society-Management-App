import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;



public class window{

	public static void main(String[] args){	
		window win = new window();
	}
	private JFrame frame;
	private JLabel item1;
	private JTextField name;
	private JLabel item2;
	private JTextField id;
	private JLabel item3;
	private JTextField desc;
	private JLabel item4;
	private JTextField major;
	private JLabel item5;
	private JTextField contact;
	
	public window(){
		
		frame = new JFrame("Society Window"); //title bar
		frame.setLayout(new GridLayout(0,1));
	    JPanel panel= new JPanel(new GridLayout(0,2));
		//creating object of handler
		//thehandler handler = new thehandler();
		
		item1= new JLabel("Enter Your Name: ");
		item1.setToolTipText("This is the name of the person who is going to be set as the creator of the new Society");
		panel.add(item1); //add it to JFrame
		name = new JTextField(15);
		//name.addActionListener(handler);
		panel.add(name);
		
		
		
		item2= new JLabel("Enter Your id: ");
		item2.setToolTipText("This is the Student Id of the creator");
		panel.add(item2); //add it to JFrame
		id= new JTextField(15);
		panel.add(id);
		

		item3= new JLabel("Enter a brief description: ");
		item3.setToolTipText("Decribe the society in a few words");
		panel.add(item3); //add it to JFrame
		desc = new JTextField(20);
		panel.add(desc);
		

		item4= new JLabel("Enter Your Major: ");
		item4.setToolTipText("This is the Major of the creator in the University");
		panel.add(item4); //add it to JFrame
		major = new JTextField(15);
		panel.add(major);
		

		item5= new JLabel("Enter Your Contact: ");
		item5.setToolTipText("The email address of the creator");
		panel.add(item5); //add it to JFrame
		contact= new JTextField(15);
		panel.add(contact);
		
		JButton submit = new JButton("Submit");
		panel.add(submit, BorderLayout.CENTER);
	    submit.addActionListener(new ActionListener(){
	    		int i;
	    		@Override
	    		
	    		public void actionPerformed(ActionEvent e) {
	    			
	    			String string="";
	    			
	    			// TODO Auto-generated method stub
	    		/*	if(e.getSource() == name)
	    				string = String.format("field 1: %s", e.getActionCommand());
	    			
	    			JOptionPane.showMessageDialog(null,string);*/
	    			
	    				string= ("Name:" + name.getText() + " ID:" +id.getText() + " Description:" + desc.getText() + " Major:" +major.getText()+
	    						" Contact:" + contact.getText());
	    	   			try {
	    					PrintWriter out = new PrintWriter(new FileWriter(name.getText()));
	    				      out.write(i +": " +string + "\n");
	    				      out.close();
	    				} catch (Exception exc) {
	    				     exc.printStackTrace();
	    				}
	    			i++;
	    		}
	    			
	    }); // adding the hadler to the actionlistener which listens when something happens to this button
	    
	    

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(475, 400);
		frame.setVisible(true);
		frame.add(panel);
		frame.pack();
		}
	
	
}	


	