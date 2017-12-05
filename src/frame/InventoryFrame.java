package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import common.ReadInventory;
import common.itemList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class InventoryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField SearchtextField;
	private JTextField IDtextField;
	private JTextField textFieldRCdate;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	
	/* Items List */
	Object[] itemListcolumns  = {"Id", "Description", "Last Order", "Current Qty"};
	DefaultTableModel modelItemList = new DefaultTableModel ();
	
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
	 * @throws IOException 
	 */
	public InventoryFrame() throws IOException {
		
		ReadInventory item = new ReadInventory();
		
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
		btnMenu.setBounds(473, 679, 141, 44);
		contentPane.add(btnMenu);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(626, 679, 141, 44);
		contentPane.add(btnLogOut);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"List Items", "Current Quantity", "Sale Today", "Add/Remove Items", "Ordering", "Last Order"}));
		comboBox.setBounds(76, 47, 184, 27);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Option");
		lblNewLabel.setBounds(19, 51, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblSearch = new JLabel("Search ");
		lblSearch.setBounds(382, 51, 61, 16);
		contentPane.add(lblSearch);
		
		SearchtextField = new JTextField();
		SearchtextField.setBounds(439, 46, 130, 26);
		contentPane.add(SearchtextField);
		SearchtextField.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(19, 108, 61, 16);
		contentPane.add(lblId);
		
		IDtextField = new JTextField();
		IDtextField.setColumns(10);
		IDtextField.setBounds(76, 103, 130, 26);
		contentPane.add(IDtextField);
		
		JLabel lblReceiveOrderDate = new JLabel("Receive Order Date");
		lblReceiveOrderDate.setBounds(382, 108, 135, 16);
		contentPane.add(lblReceiveOrderDate);
		
		textFieldRCdate = new JTextField();
		textFieldRCdate.setColumns(10);
		textFieldRCdate.setBounds(516, 103, 147, 26);
		contentPane.add(textFieldRCdate);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(19, 160, 61, 16);
		contentPane.add(lblPrice);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(76, 155, 130, 26);
		contentPane.add(textField);
		
		JLabel lblTotalQuantity = new JLabel("Total Quantity");
		lblTotalQuantity.setBounds(382, 160, 135, 16);
		contentPane.add(lblTotalQuantity);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(516, 155, 147, 26);
		contentPane.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 317, 747, 308);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(531, 276, 117, 29);
		contentPane.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(644, 276, 117, 29);
		contentPane.add(btnRemove);
		
		
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				scrollPane.setViewportView(table);
				modelItemList.setColumnIdentifiers(itemListcolumns);
				table.setModel(modelItemList);
				
				if((String)comboBox.getSelectedItem()=="List Items")
				{
					
					for(int i=0; i<item.getSize(); i++)
					{
						modelItemList.addRow(new Object[] {item.getId(i), item.getItemDescription(i), item.getLastOrderDate(i), item.getcurrentInStockQty(i)});
					}
				}
			}
		});
		btnGo.setBounds(253, 46, 47, 29);
		contentPane.add(btnGo);
	}
}
