package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame {

	private JFrame frame;
	private JTextField textFieldEmloyeeID;
	private JTextField textFieldEmployeePassword;

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
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 794, 765);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldEmloyeeID = new JTextField();
		textFieldEmloyeeID.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		textFieldEmloyeeID.setBounds(255, 253, 304, 59);
		frame.getContentPane().add(textFieldEmloyeeID);
		textFieldEmloyeeID.setColumns(10);
		
		textFieldEmployeePassword = new JTextField();
		textFieldEmployeePassword.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		textFieldEmployeePassword.setColumns(10);
		textFieldEmployeePassword.setBounds(255, 324, 304, 59);
		frame.getContentPane().add(textFieldEmployeePassword);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblEmployeeId.setBounds(100, 266, 143, 35);
		frame.getContentPane().add(lblEmployeeId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblPassword.setBounds(132, 333, 111, 35);
		frame.getContentPane().add(lblPassword);
		
		JComboBox comboBoxRegister = new JComboBox();
		comboBoxRegister.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBoxRegister.setBounds(255, 406, 75, 47);
		frame.getContentPane().add(comboBoxRegister);
		
		JLabel lblDrawer = new JLabel("Register #");
		lblDrawer.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblDrawer.setBounds(120, 407, 123, 35);
		frame.getContentPane().add(lblDrawer);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Login userLogIn = new Login();
				
				if(userLogIn.authenticate(textFieldEmloyeeID.getText(), Integer.parseInt(textFieldEmployeePassword.getText())))
				{
					MenuFrame frame = new MenuFrame();
					frame.setVisible(true);
				};
			}
		});
		btnLogIn.setBounds(614, 627, 130, 67);
		frame.getContentPane().add(btnLogIn);
	}


}
