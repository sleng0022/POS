package frame;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
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
	/**
	 * Create the panel.
	 */
	public menuPanel() 
	{

		JButton btnSellItem = new JButton("SELL & RETURN ITEM ");
		btnSellItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				sellFrame frame;
				try {
					frame = new sellFrame();
					frame.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		setLayout(null);
		btnSellItem.setBounds(142, 136, 212, 29);
		this.add(btnSellItem);
		
		JButton btnInventoryManagement = new JButton("INVENTORY MANAGEMENT");
		btnInventoryManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				InventoryFrame InventoryFrame ;
				try {
					InventoryFrame = new InventoryFrame();
					InventoryFrame.setVisible(true);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnInventoryManagement.setBounds(142, 168, 212, 29);
		this.add(btnInventoryManagement);
		
		JLabel label = new JLabel(" Employee ID:");
		label.setBounds(6, 11, 86, 16);
		this.add(label);
		
		JLabel label_1 = new JLabel("Draw#");
		label_1.setBounds(208, 11, 40, 16);
		this.add(label_1);
		
		JLabel label_2 = new JLabel("Date:");
		label_2.setBounds(399, 11, 33, 16);
		this.add(label_2);
		
		JLabel label_3 = new JLabel();
		label_3.setBounds(246, 53, 0, 0);
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
		
		JButton btnLogOutButton = new JButton("LOG OUT");
		btnLogOutButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MainFrame window = new MainFrame();
				window.frame.setVisible(true);
			}
		});
		btnLogOutButton.setForeground(Color.RED);
		btnLogOutButton.setBackground(SystemColor.window);
		btnLogOutButton.setOpaque(true);
		btnLogOutButton.setBounds(142, 198, 212, 29);
		this.add(btnLogOutButton);
		
	}

}
