package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class MenuFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 765);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		btnSellItem.setBounds(297, 229, 212, 59);
		contentPane.add(btnSellItem);
		
		JButton button = new JButton("SELL & RETURN ITEM ");
		button.setBounds(297, 303, 212, 59);
		contentPane.add(button);
		
		JLabel label = new JLabel(" Employee ID:");
		label.setBounds(6, 6, 98, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Draw#");
		label_1.setBounds(327, 6, 48, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Date:");
		label_2.setBounds(566, 6, 42, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Sat 12/02/2017 13:30:42");
		label_3.setBounds(603, 6, 185, 16);
		contentPane.add(label_3);
		
		JButton btnLogOutButton = new JButton("LOG OUT");
		btnLogOutButton.setForeground(Color.BLACK);
		btnLogOutButton.setBackground(Color.RED);
		btnLogOutButton.setOpaque(true);
		btnLogOutButton.setBounds(297, 374, 212, 48);
		btnLogOutButton.setBorderPainted(false);
		contentPane.add(btnLogOutButton);
	}
}
