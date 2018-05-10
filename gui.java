import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

// login screen gui

@SuppressWarnings("serial")
public class gui extends JFrame {

	private JLabel user = new JLabel("Username");
	private JLabel pass = new JLabel("Password");

	private JTextField usertxt = new JTextField(5);
	private JTextField passtxt = new JTextField(5);

	private JButton login = new JButton("Login");
	private JButton quit = new JButton("Quit");

	public gui() {
		setLayout(new GridLayout(0, 1, 0, 1));
		add(user);
		add(usertxt);
		add(pass);
		add(passtxt);
		add(login);
		add(quit);
		//add(item1b,BorderLayout.WEST);

		login.addActionListener(handler);
		quit.addActionListener(handler2);
		quit.addActionListener(e -> this.dispose());
		login.addActionListener(e -> this.dispose());
	}

	loginHandler handler = new loginHandler();
	quitHandler handler2 = new quitHandler();

	
	private class quitHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//System.
		}
	} 
	
	private class loginHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			String password = passtxt.getText();
			String username = usertxt.getText();
			
			if (password.contains("admin") && username.contains("admin")) {
				passtxt.setText(null);
				usertxt.setText(null);
				JOptionPane.showMessageDialog(null, "Welcome"); 
				
			} 
			else {
				JOptionPane.showMessageDialog(null, "Invalid login details", "Login error", JOptionPane.ERROR_MESSAGE);
				passtxt.setText(null);
				usertxt.setText(null);
			}
			
		}
		
	}
	

	public static void main(String[] args) {
		gui frame = new gui();
		//gui frame2 = new gui();
		frame.setTitle("Welcome to NBAStats GUI");
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
