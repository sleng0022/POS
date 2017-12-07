package frame;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		JComboBox comboBoxRegister = new JComboBox();
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
		Login userLogIn = new Login();
		if(userLogIn.authenticate(textFieldEmloyeeID.getText(), textFieldEmployeePassword.getPassword()))
		{
			isValidUser = true;
		};
	}

}
