package frame;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame {

	JFrame frame;
	private JTextField textFieldEmloyeeID;
	private JPasswordField textFieldEmployeePassword;
	
	
	mainPanel mainP = new mainPanel();
	menuPanel menuP = new menuPanel();
	CardLayout cl = new CardLayout();
	private final JButton btnLogIn = new JButton("LogIn");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() 
	{
		initialize();
		
		
		frame.getContentPane().setLayout(cl);
		frame.getContentPane().add(mainP, "1");
		btnLogIn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				mainP.getTextValue();
				if(mainP.isUserValid())
				{
					cl.show(frame.getContentPane(), "2");
				}else
				{
					JOptionPane.showMessageDialog(frame, "Invalid Username/Password");
				}
			}
		});
		btnLogIn.setBounds(404, 337, 100, 37);
		mainP.add(btnLogIn);
		
		
		frame.getContentPane().add(menuP, "2");
		cl.show(frame.getContentPane(), "1");
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 794, 765);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}


}
