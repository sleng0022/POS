package frame;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class mainPanel extends JPanel {
	
	private JTextField textFieldEmloyeeID;
	private JPasswordField textFieldEmployeePassword;
	CardLayout cl = new CardLayout();
	JPanel panelCont = new JPanel();
	private boolean isValidUser;
	Login userLogIn = new Login();
	private String logIn;
	JComboBox comboBoxRegister;
	/**
	 * Create the panel.
	 */
	public mainPanel() 
	{
		menuPanel menuP = new menuPanel();
		
		panelCont.add(menuP, "1");
		panelCont.setLayout(cl);
		isValidUser = false;
		
		setLayout(null);
		textFieldEmloyeeID = new JTextField();
		textFieldEmloyeeID.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		textFieldEmloyeeID.setBounds(297, 219, 210, 36);
		this.add(textFieldEmloyeeID);
		textFieldEmloyeeID.setColumns(10);
		
		textFieldEmployeePassword = new JPasswordField();
		textFieldEmployeePassword.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		textFieldEmployeePassword.setColumns(10);
		textFieldEmployeePassword.setBounds(297, 283, 210, 36);
		textFieldEmployeePassword.setEchoChar('*');
		this.add(textFieldEmployeePassword);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblEmployeeId.setBounds(154, 223, 131, 27);
		this.add(lblEmployeeId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblPassword.setBounds(185, 287, 100, 27);
		this.add(lblPassword);
		
		comboBoxRegister = new JComboBox();
		comboBoxRegister.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBoxRegister.setBounds(297, 344, 64, 27);
		this.add(comboBoxRegister);
		
		JLabel lblDrawer = new JLabel("Register #");
		lblDrawer.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblDrawer.setBounds(178, 339, 107, 27);
		this.add(lblDrawer);	
	}
	
	public boolean isUserValid()
	{
		return isValidUser;
	}
	
	public void getTextValue()
	{
		
		if(userLogIn.authenticate(textFieldEmloyeeID.getText(), textFieldEmployeePassword.getPassword()))
		{
			isValidUser = true;
		};
	}
	
	public String getEmployeeID()
	{
		return userLogIn.getUserName();
	}
	
	public String getDrawer()
	{
		return (String)comboBoxRegister.getSelectedItem();
	}
	
	public void setLogIn()
	{
		Calendar now = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy.MM.dd, HH:mm");
		logIn = df.format(now.getTime());
	}
	
	public void saveEmployeeTimeStamp()
	{
		FileWriter writer = null;
		String FILE_HEADER = "EmployeeID, Drawer, Date, Time Log In, Time Log Out, Sale($)";
		String DLIMETER_COMMA = ",";
		String DLIMETER_NEW_LINE = "\n";
		this.setLogIn();
		try 
		{
			writer = new FileWriter("./data/employee_sell_today.csv");
			writer.append(FILE_HEADER.toString());
			writer.append(DLIMETER_NEW_LINE);
			writer.append(userLogIn.getUserName());
			writer.append(DLIMETER_COMMA);
			writer.append((String)comboBoxRegister.getSelectedItem());
			writer.append(DLIMETER_COMMA);
			writer.append(logIn);
			writer.append(DLIMETER_COMMA);
			writer.append("");
			writer.append(DLIMETER_COMMA);
			writer.append("0.0");
			writer.append(DLIMETER_NEW_LINE);
			writer.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
