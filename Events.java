
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Events {

	private JFrame frame;
	private final JButton createButton = new JButton("Create Event");
	private JTextField textField1;
	private JTextField textField2;
	JTextArea textArea1 = new JTextArea();

	
	

	/**
	 * Create the application.
	 */
	public Events() {
		createButton.setForeground(Color.black);
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eventNam = textField1.getText();
				String eventDescr = textField2.getText();
				textArea1.setText(eventNam + "\n" + eventDescr );
				
				
				
			}
		});
		initialize();
	}

	/**
	 * Initialize the contents of the frame..
	 */
	private void initialize() {
		frame = new JFrame();
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
		frame.getContentPane().setForeground(Color.blue);
		frame.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 15));
		frame.setBounds(100, 100, 596, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblNewLabel = new JLabel("EVENT BOARD");
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(218, 34, 128, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel eventNameLabel = new JLabel("Event Name");
		eventNameLabel.setForeground(Color.red);
		eventNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		eventNameLabel.setBounds(64, 137, 93, 14);
		frame.getContentPane().add(eventNameLabel);
		
		JLabel desLabel = new JLabel("Description");
		desLabel.setForeground(Color.red);
		desLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		desLabel.setBounds(64, 211, 93, 14);
		frame.getContentPane().add(desLabel);
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		createButton.setFont(new Font("Tahoma", Font.ITALIC, 16));
		createButton.setBounds(61, 286, 128, 31);
		frame.getContentPane().add(createButton);
		
		
		
		 textArea1 = new JTextArea();
		 textArea1.setForeground(Color.black);
		textArea1.setBounds(323, 286, 210, 130);
		frame.getContentPane().add(textArea1);
		
		textField1 = new JTextField();
		textField1.setForeground(Color.black);
		textField1.setBounds(321, 134, 212, 20);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setForeground(Color.black);
		textField2.setBounds(321, 208, 212, 20);
		frame.getContentPane().add(textField2);
		textField2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Home Page");
		btnNewButton_1.setForeground(Color.black);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Start_window();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnNewButton_1.setBounds(64, 405, 128, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Reset Event");
		btnNewButton.setForeground(Color.black);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea1.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(64, 352, 125, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
