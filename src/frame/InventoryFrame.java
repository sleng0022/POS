package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventoryFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryFrame frame = new InventoryFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InventoryFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 765);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MenuFrame frame = new MenuFrame();
				frame.setVisible(true);
			}
		});
		btnMenu.setBounds(282, 375, 141, 44);
		contentPane.add(btnMenu);
		
		JButton btnAddremoveItem = new JButton("Add/Remove Item");
		btnAddremoveItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnAddremoveItem.setBounds(282, 219, 141, 50);
		contentPane.add(btnAddremoveItem);
		
		JButton btnListOrder = new JButton("List Order");
		btnListOrder.setBounds(282, 297, 141, 50);
		contentPane.add(btnListOrder);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(282, 452, 141, 44);
		contentPane.add(btnLogOut);
	}

}
