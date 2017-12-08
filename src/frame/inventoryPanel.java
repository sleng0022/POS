package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import common.EmployeeSale;
import common.ReadInventory;
import common.TrackEachRegisterSaleToday;
import common.readOrder;

public class inventoryPanel extends JPanel
{
	private JTextField IDtextField;
	private JTextField textFieldRCdate;
	private JTextField textFieldPrice;
	private JTextField textFieldTotal;
	private JScrollPane scrollPane;
	private JTable table;
	private ReadInventory item;
	private TrackEachRegisterSaleToday registerSaleToday;
	private EmployeeSale saleEmployee;
	private readOrder orderItem;
	
	/* Items List */
	Object[] itemListcolumns  = {"Id", "Description", "Last Order", "Current Qty"};
	Object[] itemListColumnAdd = {"Id", "Item", "Price", "Last Order", "Total Qty", "Current Qty", "Supplier", "Expiration", "Threshold", "Comment"};
	Object[] saleTodayColumn = {"RegisterID", "Date", "TotalSale"};
	Object[] orderItemColumn = {"Date", "Item", "Qty"};
	Object[] employeeSaleColumn = {"Employee ID", "Drawer", "Date", "Time Log In", "Time Log Out", "Sale"};
	DefaultTableModel modelItemList = new DefaultTableModel ();
	private JTextField textFieldSupplier;
	private JTextField textFieldThreshold;
	private JTextField textFieldExpiration;
	private JTextField textFieldComment;
	private JTextField textFieldDescription;

	/**
	 * Create the panel.
	 */
	public inventoryPanel() throws IOException
	{
		
		item = new ReadInventory();
		registerSaleToday = new TrackEachRegisterSaleToday();
		saleEmployee = new EmployeeSale();
		orderItem = new readOrder();
		setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"List Items", "Employee Sale Today", "Register Sale Today", "Outstanding Order", "Add/Remove Item"}));
		comboBox.setBounds(91, 39, 187, 27);
		this.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Option");
		lblNewLabel.setBounds(27, 43, 43, 16);
		this.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(56, 82, 14, 16);
		this.add(lblId);
		
		IDtextField = new JTextField();
		IDtextField.setColumns(10);
		IDtextField.setBounds(92, 78, 130, 26);
		this.add(IDtextField);
		
		JLabel lblReceiveOrderDate = new JLabel("Receive Order Date");
		lblReceiveOrderDate.setBounds(267, 82, 119, 16);
		this.add(lblReceiveOrderDate);
		
		textFieldRCdate = new JTextField();
		textFieldRCdate.setColumns(10);
		textFieldRCdate.setBounds(391, 77, 130, 26);
		this.add(textFieldRCdate);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(40, 121, 30, 16);
		this.add(lblPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(92, 116, 130, 26);
		this.add(textFieldPrice);
		
		JLabel lblTotalQuantity = new JLabel("Total Quantity");
		lblTotalQuantity.setBounds(290, 121, 90, 16);
		this.add(lblTotalQuantity);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setColumns(10);
		textFieldTotal.setBounds(391, 116, 130, 26);
		this.add(textFieldTotal);
		
		table = new JTable();
		
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
		btnRemove.setBounds(742, 228, 93, 29);
		this.add(btnRemove);
		
		JLabel lblSupplier = new JLabel("Supplier");
		lblSupplier.setBounds(586, 121, 51, 16);
		this.add(lblSupplier);
		
		textFieldSupplier = new JTextField();
		textFieldSupplier.setColumns(10);
		textFieldSupplier.setBounds(665, 116, 130, 26);
		this.add(textFieldSupplier);
		
		JLabel lblThresholdOrder = new JLabel("Threshold Order");
		lblThresholdOrder.setBounds(284, 157, 102, 16);
		this.add(lblThresholdOrder);
		
		textFieldThreshold = new JTextField();
		textFieldThreshold.setColumns(10);
		textFieldThreshold.setBounds(391, 154, 130, 26);
		this.add(textFieldThreshold);
		
		JLabel lblExpirationDate = new JLabel("Expiration Date");
		lblExpirationDate.setBounds(560, 157, 97, 16);
		this.add(lblExpirationDate);
		
		textFieldExpiration = new JTextField();
		textFieldExpiration.setColumns(10);
		textFieldExpiration.setBounds(665, 154, 130, 26);
		this.add(textFieldExpiration);
		
		JLabel lblComment = new JLabel("Comment");
		lblComment.setBounds(21, 157, 61, 16);
		this.add(lblComment);
		
		textFieldComment = new JTextField();
		textFieldComment.setColumns(10);
		textFieldComment.setBounds(92, 157, 130, 26);
		this.add(textFieldComment);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				modelItemList.addRow(new Object[] {IDtextField.getText(), textFieldDescription.getText(), textFieldPrice.getText(), textFieldRCdate.getText(), textFieldTotal.getText(), textFieldTotal.getText(),
						textFieldSupplier.getText(), textFieldExpiration.getText(), textFieldThreshold.getText(), textFieldComment.getText()});
			}
		});
		btnAdd.setBounds(655, 228, 75, 29);
		this.add(btnAdd);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
				try
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
						item = new ReadInventory();
						EditItem();
						isAllTextFieldEditable(true);
					}else if((String)comboBox.getSelectedItem()=="Outstanding Order")
					{
						isAllTextFieldEditable(false);
						OustandingOrderItem();
					}
				}catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnGo.setBounds(290, 38, 75, 29);
		this.add(btnGo);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setColumns(10);
		textFieldDescription.setBounds(665, 77, 130, 26);
		this.add(textFieldDescription);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(554, 82, 73, 16);
		this.add(lblDescription);
		
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
		btnNewButton.setBounds(572, 228, 75, 29);
		this.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 290, 814, 314);
		add(scrollPane);
		
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
			modelItemList.addRow(new Object[] {saleEmployee.getEmployeeID(i), saleEmployee.getDrawer(i), saleEmployee.getdateSale(i), saleEmployee.gettimeLogin(i), 
					saleEmployee.gettimeLogOut(i), saleEmployee.getsaleToday(i)});
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
		resetModel();
		scrollPane.setViewportView(table);
		modelItemList.setColumnIdentifiers(itemListColumnAdd);
		table.setModel(modelItemList);
		
		for(int i=0; i<item.getSize(); i++)
		{
			modelItemList.addRow(new Object[] {item.getId(i), item.getItemDescription(i), item.getPrice(i), item.getLastOrderDate(i), item.getLastOrderQty(i), 
					item.getcurrentInStockQty(i), item.getSupplier(i), item.getExpirationDate(i), item.getThreshold(i), item.getComment(i)});
		}
	}
	
	private void SaveItemListFile() throws IOException
	{
		FileWriter writer = null;
		String DLIMETER_COMMA = ",";
		String DLIMETER_NEW_LINE = "\n";
		String FILE_HEADER = "Id, Item, Price,Last Order, Total Qty, Current Qty, Supplier, Expiration, Threshold, Comment";
		
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
	
	private void OustandingOrderItem()
	{
		resetModel();
		scrollPane.setViewportView(table);
		modelItemList.setColumnIdentifiers(orderItemColumn);
		table.setModel(modelItemList);
		
		for(int i=0; i<orderItem.getSize(); i++)
		{
			modelItemList.addRow(new Object[] {orderItem.getDate(i), orderItem.getItemOrder(i), orderItem.getQtyOrder(i)});
		}
	}
}
