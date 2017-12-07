package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import common.DoublyLinkList;
import common.EmptyExceptions;
import common.itemList;
import common.receipt;

public class sellItemPanel extends JPanel
{
//	private JPanel contentPane;
	private JTable table;
	private boolean isEnterButtonPress;
	private double numberAfterEnter;
	private double enteringValue;
	private boolean isPaymentButtonPress;
	private boolean isReturnButtonPress;
	private boolean isQuantityButtonPress;
	private double totalPrice;
	private double cashierTotalSale;
	private double newPrice;
	private double change;
	private JLabel lblEmployeeID;
	private JLabel lblDrawNum;
	
	private String logOut;
	
	Object[] columns  = {"Qty", "Description", "Price"};
	DefaultTableModel model = new DefaultTableModel ();
	DoublyLinkList<String> amount = new DoublyLinkList<String>(); 
	static JFrame sellframe;

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public sellItemPanel() throws IOException 
	{	
		itemList item = new itemList();
		
		NumberFormat numFormat = new DecimalFormat("#0.00");
		setLayout(null);

//		setBounds(100, 100, 794, 765);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(null);
		
		JLabel lblTotal = new JLabel("0.00");
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTotal.setBounds(625, 477, 98, 33);
		this.add(lblTotal);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(352, 40, 430, 375);
		this.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
		JLabel lblNewLabel = new JLabel("Total: $");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setBounds(540, 484, 62, 21);
		this.add(lblNewLabel);
		
		JLabel lblChange = new JLabel("0.00");
		lblChange.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblChange.setBounds(629, 551, 94, 52);
		this.add(lblChange);
		
		JLabel lblNewLabel_2 = new JLabel("Cash: $");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(540, 517, 84, 33);
		this.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Change: $");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(518, 558, 84, 41);
		this.add(lblNewLabel_3);
		
		JLabel lblcashAmount = new JLabel("");
		lblcashAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblcashAmount.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblcashAmount.setBounds(625, 529, 115, 33);
		this.add(lblcashAmount);
		
		JLabel lblNewLabel_4 = new JLabel(" Employee ID:");
		lblNewLabel_4.setBounds(17, 11, 86, 16);
		this.add(lblNewLabel_4);
		
		JLabel lblDraw = new JLabel("Draw#");
		lblDraw.setBounds(342, 11, 40, 16);
		this.add(lblDraw);
		
		JLabel Date = new JLabel("Date:");
		Date.setBounds(568, 11, 33, 16);
		this.add(Date);
		
		JLabel lblDate = new JLabel();
		lblDate.setBounds(606, 11, 157, 16);
		this.add(lblDate);
		Timer simpleTimer = new Timer(500, new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Calendar now = Calendar.getInstance();
				lblDate.setText(DateFormat.getDateTimeInstance().format(now.getTime()));
		     }
		}
		);
		simpleTimer.setRepeats(true);
		simpleTimer.setCoalesce(true);
		simpleTimer.start();
		
		JLabel lblDrawNum = new JLabel("");
		lblDrawNum.setBounds(394, 11, 40, 16);
		this.add(lblDrawNum);
		
		lblEmployeeID = new JLabel("");
		lblEmployeeID.setBounds(115, 11, 84, 16);
		this.add(lblEmployeeID);
		
		JButton btnBananaButton = new JButton("Banana");
		btnBananaButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("banana"));
				model.addRow(new Object[] {enteringValue,"banana"+"@"+item.getPriceWithDescription("banana"), enteringValue*item.getPriceWithDescription("banana")});
				lblTotal.setText(numFormat.format(totalPrice));
				item.setUpdateNewQuantity((int)enteringValue, "banana");
			}
		});
		btnBananaButton.setBounds(15, 76, 88, 29);
		this.add(btnBananaButton);
		
		JButton btnMengo = new JButton("Mengo");
		btnMengo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("mengo"));
				model.addRow(new Object[] {enteringValue,"Mengo"+"@"+item.getPriceWithDescription("mengo"), enteringValue*item.getPriceWithDescription("mengo")});
				lblTotal.setText(numFormat.format(totalPrice));
				item.setUpdateNewQuantity((int)enteringValue, "mengo");
			}
		});
		btnMengo.setBounds(113, 76, 86, 29);
		this.add(btnMengo);
		
		JButton btnApple = new JButton("Apple");
		btnApple.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("apple"));
				model.addRow(new Object[] {enteringValue,"Apple"+"@"+item.getPriceWithDescription("apple"), numFormat.format(enteringValue*item.getPriceWithDescription("apple"))});
				lblTotal.setText(numFormat.format((totalPrice)));
				item.setUpdateNewQuantity((int)enteringValue, "apple");
			}
		});
		btnApple.setBounds(204, 76, 80, 29);
		this.add(btnApple);
		
		JButton buttonBlueBerry = new JButton("Blue Berry");
		buttonBlueBerry.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("blue berry"));
				model.addRow(new Object[] {enteringValue,"Blue Berry"+"@"+item.getPriceWithDescription("blue berry"), numFormat.format(enteringValue*item.getPriceWithDescription("blue berry"))});
				lblTotal.setText(numFormat.format(totalPrice));
				item.setUpdateNewQuantity((int)enteringValue, "blue berry");
			}
		});
		buttonBlueBerry.setBounds(17, 117, 86, 29);
		this.add(buttonBlueBerry);
		
		JButton btnOrange = new JButton("Orange");
		btnOrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("orange"));
				model.addRow(new Object[] {enteringValue,"orange"+"@"+item.getPriceWithDescription("orange"), numFormat.format(enteringValue*item.getPriceWithDescription("orange"))});
				lblTotal.setText(numFormat.format(totalPrice));
				item.setUpdateNewQuantity((int)enteringValue, "orange");
			}
		});
		btnOrange.setBounds(115, 117, 89, 29);
		this.add(btnOrange);
		
		JButton btnPineapple = new JButton("Pineapple");
		btnPineapple.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("pineapple"));
				model.addRow(new Object[] {enteringValue,"Pineapple"+"@"+item.getPriceWithDescription("pineapple"), numFormat.format(enteringValue*item.getPriceWithDescription("pineapple"))});
				lblTotal.setText(numFormat.format(totalPrice));
				item.setUpdateNewQuantity((int)enteringValue, "pineapple");
			}
		});
		btnPineapple.setBounds(17, 158, 84, 29);
		this.add(btnPineapple);
		
		JButton btnStrawberry = new JButton("Strawberry");
		btnStrawberry.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("strawberry"));
				model.addRow(new Object[] {enteringValue,"Strawberry"+"@"+item.getPriceWithDescription("strawberry"), numFormat.format(enteringValue*item.getPriceWithDescription("strawberry"))});
				lblTotal.setText(numFormat.format(totalPrice));
				item.setUpdateNewQuantity((int)enteringValue, "strawberry");
			}
		});
		btnStrawberry.setBounds(113, 158, 91, 29);
		this.add(btnStrawberry);
		
		JButton btnDurian = new JButton("Durian");
		btnDurian.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("durian"));
				model.addRow(new Object[] {enteringValue,"Durian"+"@"+item.getPriceWithDescription("durian"), numFormat.format(enteringValue*item.getPriceWithDescription("durian"))});
				lblTotal.setText(numFormat.format(totalPrice));
				item.setUpdateNewQuantity((int)enteringValue, "durian");
			}
		});
		btnDurian.setBounds(204, 117, 86, 29);
		this.add(btnDurian);
		
		JButton btnAvocado = new JButton("Avocado");
		btnAvocado.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("avocado"));
				model.addRow(new Object[] {enteringValue,"Avocado"+"@"+item.getPriceWithDescription("avocado"), numFormat.format(enteringValue*item.getPriceWithDescription("avocado"))});
				lblTotal.setText(numFormat.format(totalPrice));
				item.setUpdateNewQuantity((int)enteringValue, "avocado");
			}
		});
		btnAvocado.setBounds(207, 158, 98, 29);
		this.add(btnAvocado);
		
		JButton btnPayment = new JButton("Payment");
		isPaymentButtonPress = false;
		btnPayment.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				isPaymentButtonPress = true;
				lblcashAmount.setText("");
				if(isReturnButtonPress)
				{
					Double change;
					change = totalPrice - newPrice;
					lblChange.setText(numFormat.format(change));
				}
			}
		});
		btnPayment.setBounds(196, 494, 160, 91);
		this.add(btnPayment);
		
		JButton btnVoidAll = new JButton("Void All");
		btnVoidAll.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if(model.getRowCount() > 0)
				{
					for(int i =model.getRowCount()-1; i>-1; i--)
					{
						model.removeRow(i);
					}
				}
				lblTotal.setText(numFormat.format(0.00));
			}
		});
		btnVoidAll.setBounds(17, 494, 169, 43);
		this.add(btnVoidAll);
		
		JButton btnQty = new JButton("QTY");
		btnQty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				isQuantityButtonPress = true;
			}
		});
		btnQty.setBounds(125, 419, 75, 62);
		this.add(btnQty);
		
		JButton btn7num = new JButton("7");
		btn7num.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				amount.insertLast("7");
				if(isPaymentButtonPress)
				{
					String enteringNum = lblcashAmount.getText() + btn7num.getText();
					lblcashAmount.setText(enteringNum);
				}
			}
		});
		btn7num.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btn7num.setBounds(17, 330, 86, 33);
		this.add(btn7num);
		
		JButton btn8num = new JButton("8");
		btn8num.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				amount.insertLast("8");
				if(isPaymentButtonPress)
				{
					String enteringNum = lblcashAmount.getText() + btn8num.getText();
					lblcashAmount.setText(enteringNum);
				}
			}
		});
		btn8num.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btn8num.setBounds(115, 330, 75, 33);
		this.add(btn8num);
		
		JButton btn9num = new JButton("9");
		btn9num.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				amount.insertLast("9");
				if(isPaymentButtonPress)
				{
					String enteringNum = lblcashAmount.getText() + btn9num.getText();
					lblcashAmount.setText(enteringNum);
				}
			}
		});
		btn9num.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btn9num.setBounds(209, 330, 75, 33);
		this.add(btn9num);
		
		JButton btn4num = new JButton("4");
		btn4num.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				amount.insertLast("4");
				if(isPaymentButtonPress)
				{
					String enteringNum = lblcashAmount.getText() + btn4num.getText();
					lblcashAmount.setText(enteringNum);
				}
			}
		});
		btn4num.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btn4num.setBounds(19, 285, 84, 33);
		this.add(btn4num);
		
		JButton btn5num = new JButton("5");
		btn5num.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				amount.insertLast("5");
				if(isPaymentButtonPress)
				{
					String enteringNum = lblcashAmount.getText() + btn5num.getText();
					lblcashAmount.setText(enteringNum);
				}else if(isQuantityButtonPress)
				{
							
				}
			}
		});
		btn5num.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btn5num.setBounds(115, 285, 75, 33);
		this.add(btn5num);
		
		JButton btn6num = new JButton("6");
		btn6num.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				amount.insertLast("6");
				if(isPaymentButtonPress)
				{
					String enteringNum = lblcashAmount.getText() + btn6num.getText();
					lblcashAmount.setText(enteringNum);
				}
			}
		});
		btn6num.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btn6num.setBounds(209, 285, 75, 33);
		this.add(btn6num);
		
		JButton btn1num = new JButton("1");
		btn1num.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				amount.insertLast("1");
				if(isPaymentButtonPress)
				{
					String enteringNum = lblcashAmount.getText() + btn1num.getText();
					lblcashAmount.setText(enteringNum);
				}
			}
		});
		btn1num.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btn1num.setBounds(17, 240, 86, 33);
		this.add(btn1num);
		
		JButton btn2num = new JButton("2");
		btn2num.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				amount.insertLast("2");
				if(isPaymentButtonPress)
				{
					String enteringNum = lblcashAmount.getText() + btn2num.getText();
					lblcashAmount.setText(enteringNum);
				}
			}
		});
		btn2num.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btn2num.setBounds(115, 240, 75, 33);
		this.add(btn2num);
		
		JButton btn3num = new JButton("3");
		btn3num.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				amount.insertLast("3");
				if(isPaymentButtonPress)
				{
					String enteringNum = lblcashAmount.getText() + btn3num.getText();
					lblcashAmount.setText(enteringNum);
				}
			}
		});
		btn3num.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btn3num.setBounds(204, 240, 75, 33);
		this.add(btn3num);
		
		JButton btn0num = new JButton("0");
		btn0num.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				amount.insertLast("0");
				if(isPaymentButtonPress)
				{
					String enteringNum = lblcashAmount.getText() + btn0num.getText();
					lblcashAmount.setText(enteringNum);
				}
			}
		});
		btn0num.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btn0num.setBounds(115, 375, 75, 33);
		this.add(btn0num);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				amount.insertLast(".");
				if(isPaymentButtonPress)
				{
					String enteringNum = lblcashAmount.getText() + btnDot.getText();
					lblcashAmount.setText(enteringNum);
				}
			}
		});
		btnDot.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnDot.setBounds(204, 375, 75, 33);
		this.add(btnDot);
		
		JButton btnEnter = new JButton("Enter");
		isEnterButtonPress = false;
		numberAfterEnter = 0.0;
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					isEnterButtonPress = true;
					numberAfterEnter = Double.parseDouble((amount.PrintiteratorForward()));
					if(isPaymentButtonPress)
					{
						isPaymentButtonPress = false;
						change = Double.parseDouble(lblcashAmount.getText()) - totalPrice;
						lblChange.setText(numFormat.format(change));
						amount.removeAllFirst();
					}else if(isQuantityButtonPress)
					{
						enteringValue = numberAfterEnter;
						amount.removeAllFirst();
					}
				}catch (EmptyExceptions error)
				{
					
				}
			}
		});
		btnEnter.setBounds(208, 414, 76, 67);
		this.add(btnEnter);
		
		JButton btnPrintRecipet = new JButton("Print Receipt");
		btnPrintRecipet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				FileWriter writer = null;
				String DLIMETER_COMMA = ",";
				String DLIMETER_NEW_LINE = "\n";
				String FILE_HEADER = "Reciept ID,Qty, Description, Price";
				Random rand = new Random();
				try
				{
					int randomNum = rand.nextInt(1000);
					
					writer = new FileWriter("./data/receipt.csv");
					writer.append(FILE_HEADER.toString());
					writer.append(DLIMETER_NEW_LINE);
					for(int row=0; row<model.getRowCount(); row++)
					{
						writer.append(Integer.toString(randomNum));
						writer.append(DLIMETER_COMMA);
						for(int col=0; col<model.getColumnCount(); col++)
						{
							writer.append((model.getValueAt(row, col).toString()));
							writer.append(DLIMETER_COMMA);
						}
						writer.append(DLIMETER_NEW_LINE);
					}
					writer.close();
					
					lblTotal.setText("0.00");
					lblcashAmount.setText("0.00");
					lblChange.setText("0.00");
					cashierTotalSale += totalPrice;
					totalPrice = 0;
					
					item.updateItemListFile();
					
					if(model.getRowCount() > 0)
					{
						for(int i =model.getRowCount()-1; i>-1; i--)
						{
							model.removeRow(i);
						}
					}
					writer.close();
					
				}catch(Exception e)
				{
					System.err.format("Cannot print.", e.getMessage());
				}
			}
		});
		btnPrintRecipet.setBounds(17, 620, 324, 84);
		this.add(btnPrintRecipet);
		
		JButton btnVoid = new JButton("Void");
		btnVoid.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int[] row = table.getSelectedRows();
				for(int i=0;i<row.length;i++)
				{
					totalPrice -= Double.parseDouble((model.getValueAt(row[i]-i, 2).toString()));
				     model.removeRow(row[i]-i);
				}
	
				lblTotal.setText(numFormat.format(totalPrice));
	
			}
		});
		btnVoid.setBounds(17, 543, 169, 42);
		this.add(btnVoid);
		
		JButton btnReturn = new JButton("Return Item");
		btnReturn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					isReturnButtonPress = true;
					receipt rec = new receipt();
					String recieptNumber = (String)JOptionPane.showInputDialog(sellframe, "Receipt#:","Returning Items", JOptionPane.PLAIN_MESSAGE,null,null,"####");
					int rec_id = Integer.parseInt(recieptNumber);
					
					for(int i = 0; i<rec.size(); i++)
					{
						model.addRow(new Object[] {rec.getQtyItem(i,rec_id),rec.getItemDescription(i,rec_id), rec.getPriceItem(i,rec_id)});
						totalPrice += rec.getPriceItem(i, rec_id);
						lblTotal.setText(numFormat.format(totalPrice));
					}
					newPrice = totalPrice;
				}catch(IOException e1)
				{
					// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnReturn.setBounds(17, 377, 97, 84);
			this.add(btnReturn);
		
		}
	
	public void setEmployeeID(String name)
	{
		lblEmployeeID.setText(name);
	}
	
	public void setDrawer(String num)
	{
		lblDrawNum.setText(num);
	}
	
	public void setLogOut()
	{
		Calendar now = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy.MM.dd, HH:mm");
		logOut = df.format(now.getTime());
	}
	
	public String getLogOut()
	{
		return logOut;
	}

}
