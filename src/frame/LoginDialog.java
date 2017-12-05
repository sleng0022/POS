package frame;




import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LoginDialog extends JDialog {
 
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JTextField tfConfirmUserNAme;
    private JLabel lbUsername;
    private JLabel lbConfirmUserNAme;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean succeeded;
    private JButton btnLoginAsAdmin;
    private JTextField tfDrawer;
    private JLabel lbDrawer;
    
    public static void main1(String[] args) 
	{
    	LoginDialog Login= new LoginDialog(frame);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDialog window = new LoginDialog(null);
					window.getFrame().setVisible(false);
					window.getFrame().dispose();
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	
	}
    public LoginDialog(Frame parent) {
        super(parent, "Login", true);
        
        //
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        lbUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);
 
        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);
        
 
        lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);
 
        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        lbDrawer = new JLabel("Drawer: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 3;
        panel.add(lbDrawer, cs);
 
        tfDrawer = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 3;
        panel.add(tfDrawer, cs);
        panel.setBorder(new LineBorder(Color.GRAY));
//        public static void main(String[] args) {
        	
        btnLogin = new JButton("Login");
        btnLoginAsAdmin = new JButton("Log in As Admin");
 
        btnLogin.addActionListener(new ActionListener() {
        	
 
            public void actionPerformed(ActionEvent e) {
                try {
					if (Login.authenticate(getUsername(), getPassword())) {
					    JOptionPane.showMessageDialog(LoginDialog.this,
					            "Hi " + getUsername() + "! You have successfully logged in.",
					            "Login",
					            JOptionPane.INFORMATION_MESSAGE);
					    succeeded = true;
					    dispose();
					} else {
					    JOptionPane.showMessageDialog(LoginDialog.this,
					            "Invalid username or password",
					            "Login",
					            JOptionPane.ERROR_MESSAGE);
					    // reset username and password
					    tfUsername.setText("");
					    pfPassword.setText("");
					    succeeded = false;
 
					}
				} catch (HeadlessException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel bp = new JPanel();
        bp.add(btnLogin);
        bp.add(btnCancel);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
 
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
	
//    }
    JLabel Date = new JLabel("Date:");
	
	
	
	String timeStamp = new SimpleDateFormat("E MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()); 
	JLabel lblDate = new JLabel(timeStamp);
	private static JFrame frame;

 
    public String getUsername() {
        return tfUsername.getText().trim();
    }
 
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }
 
    public boolean isSucceeded() {
        return succeeded;
    }

	public String getDrawer() {
		return tfDrawer.getText().trim();
	}

	public void setTfDrawer(JTextField tfDrawer) {
		this.tfDrawer = tfDrawer;
	}

	public JLabel getLbDrawer() {
		return lbDrawer;
	}

	public void setLbDrawer(JLabel lbDrawer) {
		this.lbDrawer = lbDrawer;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
