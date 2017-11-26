package frame;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MainFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main1(String[] args) 
	{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(false);
					window.frame.dispose();
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}public static void main(String[] args) {
    final JFrame frame = new JFrame("Point of sales  Demo");
    
    final JButton btnLoginAsCashier = new JButton("Register as Cashier");
    final JButton btnLoginAsAdmin = new JButton("Register as Admin");

    btnLoginAsCashier.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    LoginDialog loginDlg = new LoginDialog(frame);
                    loginDlg.setVisible(true);
                    // if logon successfully
                    if(loginDlg.isSucceeded()){
                    	btnLoginAsCashier.setText("Hi " + loginDlg.getUsername() + "!");
                    }
                }
            });
    btnLoginAsAdmin.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    LoginDialog loginDlg = new LoginDialog(frame);
                    loginDlg.setVisible(true);
                    // if logon successfully
                    if(loginDlg.isSucceeded()){
                    	btnLoginAsCashier.setText("Hi " + loginDlg.getUsername() + "!");
                    }
                }
            });


    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 200);
    frame.setLayout(new FlowLayout());
    frame.getContentPane().add(btnLoginAsCashier);
    frame.setVisible(true);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 200);
    frame.setLayout(new FlowLayout());
    frame.getContentPane().add(btnLoginAsAdmin);
    frame.setVisible(true);
    
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
		frame.setBounds(100, 100, 654, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame frame2 = new JFrame();
		frame2.setBounds(100, 100, 654, 386);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
