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
//				FileWriter writer = null;
//				String FILE_HEADER = "EmployeeID, Date, Time Log In, Time Log Out, Sale($)";
//				String DLIMETER_COMMA = ",";
//				String DLIMETER_NEW_LINE = "\n";
//				try 
//				{
//					writer = new FileWriter("./data/employee_sell_today.csv");
//					writer.append(FILE_HEADER.toString());
//					writer.append(DLIMETER_NEW_LINE);
//					writer.append(lblEmployeeID.getText());
//					writer.append(DLIMETER_COMMA);
//					writer.append(lblDate.getText());
//					writer.append(DLIMETER_COMMA);
//					writer.append(numFormat.format(cashierTotalSale));
//					writer.append(DLIMETER_NEW_LINE);
//					cashierTotalSale = 0;
//					writer.close();
//					sellframe.dispose();
//					MainFrame window = new MainFrame();
//					window.frame.setVisible(true);
//					
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				cl.show(frame.getContentPane(), "1");
			}
		});
		sellLogOutbutton.setBounds(669, 664, 94, 56);
		sellP.add(sellLogOutbutton);
		
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
