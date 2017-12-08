package frame;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import common.EmptyExceptions;
import java.awt.FlowLayout;

public class menuPanel extends JPanel 
{

	private JLabel labelUserID;
	private JLabel lblDrawer;
	private String logIn;
	/**
	 * Create the panel.
	 */
	public menuPanel() 
	{
		logIn = "";
		
		
		JLabel label = new JLabel(" Employee ID:");
		label.setBounds(6, 11, 86, 16);
		this.add(label);
		
		JLabel label_1 = new JLabel("Draw#");
		label_1.setBounds(276, 11, 40, 16);
		this.add(label_1);
		
		JLabel label_2 = new JLabel("Date:");
		label_2.setBounds(477, 11, 33, 16);
		this.add(label_2);
		
		JLabel label_3 = new JLabel();
		label_3.setBounds(533, 11, 163, 16);
		this.add(label_3);
		Timer simpleTimer = new Timer(500, new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Calendar now = Calendar.getInstance();
				label_3.setText(DateFormat.getDateTimeInstance().format(now.getTime()));
		     }
		}
		);
		simpleTimer.setRepeats(true);
		simpleTimer.setCoalesce(true);
		simpleTimer.start();
		setLayout(null);
		
		lblDrawer = new JLabel("");
		lblDrawer.setBounds(328, 11, 61, 16);
		add(lblDrawer);
		
		labelUserID = new JLabel("");
		labelUserID.setBounds(104, 11, 78, 16);
		add(labelUserID);
		
	}
	
	public void setEmployeeID(String name)
	{
		labelUserID.setText(name);
	}
	
	public void setDrawer(String num)
	{
		lblDrawer.setText(num);
	}
	
	public void setLogIn()
	{
		Calendar now = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy.MM.dd, HH:mm");
		logIn = df.format(now.getTime());
	}
	
	public String getLogIn()
	{
		return logIn;
	}
}
