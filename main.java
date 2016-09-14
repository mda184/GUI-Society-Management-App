/*This is the main method that starts the program Amirb j*/


import java.awt.EventQueue;
/*Launch the application*/


public class main {
	// create one Frame
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start_window window = new Start_window(); // Calls the start window method
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
