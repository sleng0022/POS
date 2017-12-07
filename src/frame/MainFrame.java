package frame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

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
	 * @throws IOException 
	 */
	public MainFrame() throws IOException 
	{
		sellItemPanel sellP = new sellItemPanel();	
		initialize();
		
		frame.getContentPane().setLayout(cl);
		frame.getContentPane().add(mainP, "1");
		frame.getContentPane().add(menuP, "2");
		frame.getContentPane().add(sellP, "3");
		JButton buttonSellMenu = new JButton("SELL & RETURN ITEM ");
		buttonSellMenu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(frame.getContentPane(), "3");
			}
		});
		buttonSellMenu.setBounds(250, 218, 212, 29);
		menuP.add(buttonSellMenu);
		
		JButton buttonInventory = new JButton("INVENTORY MANAGEMENT");
		buttonInventory.setBounds(250, 259, 212, 29);
		menuP.add(buttonInventory);
		
		JButton buttonLogOut = new JButton("LOG OUT");
		buttonLogOut.setOpaque(true);
		buttonLogOut.setForeground(Color.RED);
		buttonLogOut.setBackground(SystemColor.window);
		buttonLogOut.setBounds(250, 297, 212, 29);
		menuP.add(buttonLogOut);
		
		
		btnLogIn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				mainP.getTextValue();
				if(mainP.isUserValid())
				{
					menuP.setEmployeeID(mainP.getEmployeeID());
					menuP.setDrawer(mainP.getDrawer());
					menuP.setLogIn();
					cl.show(frame.getContentPane(), "2");
				}else
				{
					JOptionPane.showMessageDialog(frame, "Invalid Username/Password");
				}
			}
		});
		btnLogIn.setBounds(404, 341, 100, 37);
		mainP.add(btnLogIn);
		
		cl.show(frame.getContentPane(), "1");
		
		
		JButton sellMenubutton = new JButton("Menu");
		sellMenubutton.setBackground(Color.WHITE);
		sellP.add(sellMenubutton);
		
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
