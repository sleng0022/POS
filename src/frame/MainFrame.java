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
import java.io.FileWriter;
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
		inventoryPanel inventoryP = new inventoryPanel();
		initialize();
		
		frame.getContentPane().setLayout(cl);
		frame.getContentPane().add(mainP, "1");
		frame.getContentPane().add(menuP, "2");
		frame.getContentPane().add(sellP, "3");
		frame.getContentPane().add(inventoryP, "4");
		
		JButton buttonSellMenu = new JButton("SELL & RETURN ITEM ");
		buttonSellMenu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				cl.show(frame.getContentPane(), "3");
				sellP.setEmployeeID(mainP.getEmployeeID());
				sellP.setDrawer(mainP.getDrawer());	//bug
			}
		});
		buttonSellMenu.setBounds(250, 218, 212, 29);
		menuP.add(buttonSellMenu);
		
		JButton buttonInventory = new JButton("INVENTORY MANAGEMENT");
		buttonInventory.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(frame.getContentPane(), "4");
			}
		});
		buttonInventory.setBounds(250, 259, 212, 29);
		menuP.add(buttonInventory);
		
		JButton buttonLogOut = new JButton("LOG OUT");
		buttonLogOut.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(frame.getContentPane(), "1");
			}
		});
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
					mainP.saveEmployeeTimeStamp();
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
		sellMenubutton.setBackground(SystemColor.window);
		sellMenubutton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(frame.getContentPane(), "2");
			}
		});
		sellMenubutton.setBounds(559, 664, 94, 56);
		sellP.add(sellMenubutton);
		
		JButton sellLogOutbutton = new JButton("Log Out");
		sellLogOutbutton.setBackground(SystemColor.window);
		sellLogOutbutton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(frame.getContentPane(), "1");
				sellP.saveEmployeeSaleToday(mainP.getEmployeeID(), menuP.getLogIn(), mainP.getDrawer());			
			}
		});
		sellLogOutbutton.setBounds(669, 664, 94, 56);
		sellP.add(sellLogOutbutton);
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(frame.getContentPane(), "2");
			}
		});
		btnMenu.setBounds(473, 679, 141, 44);
		inventoryP.add(btnMenu);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(frame.getContentPane(), "1");
			}
		});
		btnLogOut.setBounds(626, 679, 141, 44);
		inventoryP.add(btnLogOut);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 864, 765);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	
	

}
