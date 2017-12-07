package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import common.EmployeeSale;
import common.ReadInventory;
import common.TrackEachRegisterSaleToday;
import common.itemList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InventoryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField SearchtextField;
	private JTextField IDtextField;
	private JTextField textFieldRCdate;
	private JTextField textFieldPrice;
	private JTextField textFieldTotal;
	private JTable table;
	private JScrollPane scrollPane;
	private ReadInventory item;
	private TrackEachRegisterSaleToday registerSaleToday;
	private EmployeeSale saleEmployee;
	
	/* Items List */
	Object[] itemListcolumns  = {"Id", "Description", "Last Order", "Current Qty"};
	Object[] saleTodayColumn = {"RegisterID", "Date", "TotalSale"};
	Object[] employeeSaleColumn = {"Employee ID", "Date", "Time Log In", "Time Log Out", "Sale"};
	DefaultTableModel modelItemList = new DefaultTableModel ();
	private JTextField textFieldSupplier;
	private JTextField textFieldThreshold;
	private JTextField textFieldExpiration;
	private JTextField textFieldComment;
	private JTextField textFieldDescription;
	
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
		
		item = new ReadInventory();
		registerSaleToday = new TrackEachRegisterSaleToday();
		saleEmployee = new EmployeeSale();
		
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
//				MenuFrame frame = new MenuFrame();
//				frame.setVisible(true);
			}
		});
		btnMenu.setBounds(473, 679, 141, 44);
		contentPane.add(btnMenu);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
//				MainFrame window = new MainFrame();
//				window.frame.setVisible(true);
			}
		});
		btnLogOut.setBounds(626, 679, 141, 44);
		contentPane.add(btnLogOut);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"List Items", "Employee Sale Today", "Register Sale Today", "Outstanding Order", "Add/Remove Item"}));
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
		lblId.setBounds(40, 108, 25, 16);
		contentPane.add(lblId);
		
		IDtextField = new JTextField();
		IDtextField.setColumns(10);
		IDtextField.setBounds(76, 103, 130, 26);
		contentPane.add(IDtextField);
		
		JLabel lblReceiveOrderDate = new JLabel("Receive Order Date");
		lblReceiveOrderDate.setBounds(253, 108, 135, 16);
		contentPane.add(lblReceiveOrderDate);
		
		textFieldRCdate = new JTextField();
		textFieldRCdate.setColumns(10);
		textFieldRCdate.setBounds(382, 103, 147, 26);
		contentPane.add(textFieldRCdate);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(40, 147, 35, 16);
		contentPane.add(lblPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(76, 141, 130, 26);
		contentPane.add(textFieldPrice);
		
		JLabel lblTotalQuantity = new JLabel("Total Quantity");
		lblTotalQuantity.setBounds(273, 147, 102, 16);
		contentPane.add(lblTotalQuantity);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setColumns(10);
		textFieldTotal.setBounds(382, 141, 147, 26);
		contentPane.add(textFieldTotal);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 317, 747, 308);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				modelItemList.addRow(new Object[] {IDtextField.getText(), textFieldDescription.getText(), textFieldRCdate.getText(), textFieldTotal.getText()});
			}
		});
		btnAdd.setBounds(530, 276, 117, 29);
		contentPane.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int[] row = table.getSelectedRows();
				for(int i=0;i<row.length;i++)
				{
					modelItemList.removeRow(row[i]-i);
				}

			}
		});
		btnRemove.setBounds(644, 276, 117, 29);
		contentPane.add(btnRemove);
		
		JLabel lblSupplier = new JLabel("Supplier");
		lblSupplier.setBounds(19, 194, 61, 16);
		contentPane.add(lblSupplier);
		
		textFieldSupplier = new JTextField();
		textFieldSupplier.setColumns(10);
		textFieldSupplier.setBounds(76, 189, 130, 26);
		contentPane.add(textFieldSupplier);
		
		JLabel lblThresholdOrder = new JLabel("Threshold Order");
		lblThresholdOrder.setBounds(541, 147, 117, 16);
		contentPane.add(lblThresholdOrder);
		
		textFieldThreshold = new JTextField();
		textFieldThreshold.setColumns(10);
		textFieldThreshold.setBounds(644, 142, 109, 26);
		contentPane.add(textFieldThreshold);
		
		JLabel lblExpirationDate = new JLabel("Expiration Date");
		lblExpirationDate.setBounds(273, 194, 97, 16);
		contentPane.add(lblExpirationDate);
		
		textFieldExpiration = new JTextField();
		textFieldExpiration.setColumns(10);
		textFieldExpiration.setBounds(382, 189, 130, 26);
		contentPane.add(textFieldExpiration);
		
		JLabel lblComment = new JLabel("Comment");
		lblComment.setBounds(12, 234, 68, 16);
		contentPane.add(lblComment);
		
		textFieldComment = new JTextField();
		textFieldComment.setColumns(10);
		textFieldComment.setBounds(76, 227, 211, 26);
		contentPane.add(textFieldComment);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
				if((String)comboBox.getSelectedItem()=="List Items")
				{
					ListItemOption();
					isAllTextFieldEditable(false);
				}else if((String)comboBox.getSelectedItem()=="Register Sale Today")
				{
					AllRegisterSaleToday();
					isAllTextFieldEditable(false);
				}else if((String)comboBox.getSelectedItem()=="Employee Sale Today")
				{
					EmployeeSaleToday();
					isAllTextFieldEditable(false);
				}else if((String)comboBox.getSelectedItem()=="Add/Remove Item")
				{
					isAllTextFieldEditable(true);
					EditItem();
				}
			}
		});
		btnGo.setBounds(253, 46, 47, 29);
		contentPane.add(btnGo);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setColumns(10);
		textFieldDescription.setBounds(626, 103, 130, 26);
		contentPane.add(textFieldDescription);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(541, 108, 79, 16);
		contentPane.add(lblDescription);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					if((String)comboBox.getSelectedItem()=="Add/Remove Item")
					{
						SaveItemListFile();
					}
				}catch(IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(419, 276, 117, 29);
		contentPane.add(btnNewButton);
	}
	
	private void resetModel()
	{
		modelItemList.setRowCount(0);
	}
	
	private void ListItemOption()
	{
		resetModel();
		scrollPane.setViewportView(table);
		modelItemList.setColumnIdentifiers(itemListcolumns);
		table.setModel(modelItemList);
		
		for(int i=0; i<item.getSize(); i++)
		{
			modelItemList.addRow(new Object[] {item.getId(i), item.getItemDescription(i), item.getLastOrderDate(i), item.getcurrentInStockQty(i)});
		}
	}
	
	private void AllRegisterSaleToday()
	{
		resetModel();
		scrollPane.setViewportView(table);
		modelItemList.setColumnIdentifiers(saleTodayColumn);
		table.setModel(modelItemList);
		
		for(int i=0; i<registerSaleToday.getSize(); i++)
		{
			modelItemList.addRow(new Object[] {registerSaleToday.getRegisterID(i), registerSaleToday.gettodaySaleDate(i), registerSaleToday.gettodayTotalSale(i)});
		}
	}
	
	private void EmployeeSaleToday()
	{
		resetModel();
		scrollPane.setViewportView(table);
		modelItemList.setColumnIdentifiers(employeeSaleColumn);
		table.setModel(modelItemList);
		
		for(int i=0; i<saleEmployee.getSize(); i++)
		{
			modelItemList.addRow(new Object[] {saleEmployee.getEmployeeID(i), saleEmployee.getdateSale(i), saleEmployee.gettimeLogin(i), saleEmployee.gettimeLogOut(i), saleEmployee.getsaleToday(i)});
		}
	}
	
	private void isAllTextFieldEditable(boolean write)
	{
		IDtextField.setEditable(write);
		textFieldPrice.setEditable(write);
		textFieldRCdate.setEditable(write);
		textFieldSupplier.setEditable(write);
		textFieldExpiration.setEditable(write);
		textFieldComment.setEditable(write);
		textFieldThreshold.setEditable(write);
		textFieldTotal.setEditable(write);
		textFieldDescription.setEditable(write);
	}
	
	private void EditItem()
	{
		ListItemOption();
	}
	
	private void SaveItemListFile() throws IOException
	{
		FileWriter writer = null;
		String DLIMETER_COMMA = ",";
		String DLIMETER_NEW_LINE = "\n";
		String FILE_HEADER = "Id, Description, Last Order, Current Qty";
		
		writer = new FileWriter("./data/itemList.csv");
		writer.append(FILE_HEADER.toString());
		writer.append(DLIMETER_NEW_LINE);
		for(int row=0; row<modelItemList.getRowCount(); row++)
		{
			for(int col=0; col<modelItemList.getColumnCount(); col++)
			{
				writer.append((modelItemList.getValueAt(row, col).toString()));
				writer.append(DLIMETER_COMMA);
			}
			writer.append(DLIMETER_NEW_LINE);
		}
		writer.close();
	}
}
