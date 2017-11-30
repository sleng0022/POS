package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import common.DoublyLinkList;
import common.EmptyExceptions;
import common.itemList;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.datatransfer.StringSelection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class sellFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private boolean isEnterButtonPress;
	private double numberAfterEnter;
	private double enteringValue;
	private boolean isPaymentButtonPress;
	private boolean isQuantityButtonPress;
	private double totalPrice;
	private double change;
	
	Object[] columns  = {"Qty", "Description", "Price"};
	DefaultTableModel model = new DefaultTableModel ();
	DoublyLinkList<String> amount = new DoublyLinkList<String>(); 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			
			public void run() {
				try 
				{
					sellFrame frame = new sellFrame();
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
	public sellFrame() throws IOException {
		
		itemList item = new itemList();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 765);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTotal = new JLabel("0.00");
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTotal.setBounds(625, 469, 84, 36);
		contentPane.add(lblTotal);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(345, 48, 412, 375);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 412, 375);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
		JLabel lblNewLabel = new JLabel("Total: $");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setBounds(552, 473, 71, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblChange = new JLabel("0.00");
		lblChange.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblChange.setBounds(625, 544, 84, 36);
		contentPane.add(lblChange);
		
		JLabel lblNewLabel_1 = new JLabel("Tax: $");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(563, 435, 60, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cash: $");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(552, 516, 71, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Change: $");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(528, 549, 85, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblcashAmount = new JLabel("");
		lblcashAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblcashAmount.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblcashAmount.setBounds(625, 508, 84, 36);
		contentPane.add(lblcashAmount);
		
		JLabel lblNewLabel_4 = new JLabel(" Employee ID:");
		lblNewLabel_4.setBounds(6, 6, 98, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblDraw = new JLabel("Draw#");
		lblDraw.setBounds(284, 6, 48, 16);
		contentPane.add(lblDraw);
		
		JLabel Date = new JLabel("Date:");
		Date.setBounds(538, 6, 42, 16);
		contentPane.add(Date);
		
		
		String timeStamp = new SimpleDateFormat("E, MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()); 
		JLabel lblDate = new JLabel(timeStamp);
		lblDate.setBounds(572, 6, 185, 16);
		contentPane.add(lblDate);
		
		JLabel lblDrawNum = new JLabel("");
		lblDrawNum.setBounds(344, 6, 84, 16);
		contentPane.add(lblDrawNum);
		
		JLabel lblEmployeeID = new JLabel("");
		lblEmployeeID.setBounds(95, 6, 124, 16);
		contentPane.add(lblEmployeeID);
		
		JButton btnBananaButton = new JButton("Banana");
		btnBananaButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("banana"));
				model.addRow(new Object[] {enteringValue,"banana"+"@"+item.getPriceWithDescription("banana"), enteringValue*item.getPriceWithDescription("banana")});
				lblTotal.setText(Double.toString(totalPrice));
			}
		});
		btnBananaButton.setBounds(6, 53, 98, 38);
		contentPane.add(btnBananaButton);
		
		JButton btnMengo = new JButton("Mengo");
		btnMengo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("mengo"));
				model.addRow(new Object[] {enteringValue,"Mengo"+"@"+item.getPriceWithDescription("mengo"), enteringValue*item.getPriceWithDescription("mengo")});
				lblTotal.setText(Double.toString(totalPrice));
			}
		});
		btnMengo.setBounds(6, 96, 98, 38);
		contentPane.add(btnMengo);
		
		JButton btnApple = new JButton("Apple");
		btnApple.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("apple"));
				model.addRow(new Object[] {enteringValue,"Apple"+"@"+item.getPriceWithDescription("apple"), enteringValue*item.getPriceWithDescription("apple")});
				lblTotal.setText(Double.toString(totalPrice));
			}
		});
		btnApple.setBounds(6, 139, 98, 38);
		contentPane.add(btnApple);
		
		JButton buttonBlueBerry = new JButton("Blue Berry");
		buttonBlueBerry.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("blue berry"));
				model.addRow(new Object[] {enteringValue,"Blue Berry"+"@"+item.getPriceWithDescription("blue berry"), enteringValue*item.getPriceWithDescription("blue berry")});
				lblTotal.setText(Double.toString(totalPrice));
			}
		});
		buttonBlueBerry.setBounds(116, 53, 98, 38);
		contentPane.add(buttonBlueBerry);
		
		JButton btnOrange = new JButton("Orange");
		btnOrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("orange"));
				model.addRow(new Object[] {enteringValue,"orange"+"@"+item.getPriceWithDescription("orange"), enteringValue*item.getPriceWithDescription("orange")});
				lblTotal.setText(Double.toString(totalPrice));
			}
		});
		btnOrange.setBounds(116, 96, 98, 38);
		contentPane.add(btnOrange);
		
		JButton btnPineapple = new JButton("Pineapple");
		btnPineapple.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("pineapple"));
				model.addRow(new Object[] {enteringValue,"Pineapple"+"@"+item.getPriceWithDescription("pineapple"), enteringValue*item.getPriceWithDescription("pineapple")});
				lblTotal.setText(Double.toString(totalPrice));
			}
		});
		btnPineapple.setBounds(116, 139, 98, 38);
		contentPane.add(btnPineapple);
		
		JButton btnStrawberry = new JButton("Strawberry");
		btnStrawberry.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("strawberry"));
				model.addRow(new Object[] {enteringValue,"Strawberry"+"@"+item.getPriceWithDescription("strawberry"), enteringValue*item.getPriceWithDescription("strawberry")});
				lblTotal.setText(Double.toString(totalPrice));
			}
		});
		btnStrawberry.setBounds(226, 139, 98, 38);
		contentPane.add(btnStrawberry);
		
		JButton btnDurian = new JButton("Durian");
		btnDurian.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("durian"));
				model.addRow(new Object[] {enteringValue,"Durian"+"@"+item.getPriceWithDescription("durian"), enteringValue*item.getPriceWithDescription("durian")});
				lblTotal.setText(Double.toString(totalPrice));
			}
		});
		btnDurian.setBounds(226, 96, 98, 38);
		contentPane.add(btnDurian);
		
		JButton btnAvocado = new JButton("Avocado");
		btnAvocado.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				totalPrice += enteringValue*(item.getPriceWithDescription("avocado"));
				model.addRow(new Object[] {enteringValue,"Avocado"+"@"+item.getPriceWithDescription("avocado"), enteringValue*item.getPriceWithDescription("avocado")});
				lblTotal.setText(Double.toString(totalPrice));
			}
		});
		btnAvocado.setBounds(226, 53, 98, 38);
		contentPane.add(btnAvocado);
		
		JButton btnPayment = new JButton("Payment");
		isPaymentButtonPress = false;
		btnPayment.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				isPaymentButtonPress = true;
				lblcashAmount.setText("");
			}
		});
		btnPayment.setBounds(264, 566, 117, 113);
		contentPane.add(btnPayment);
		
		JButton btnVoid = new JButton("Void");
		btnVoid.setBounds(135, 566, 117, 113);
		contentPane.add(btnVoid);
		
		JButton btnQty = new JButton("QTY");
		btnQty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				isQuantityButtonPress = true;
			}
		});
		btnQty.setBounds(6, 566, 117, 113);
		contentPane.add(btnQty);
		
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
		btn7num.setBounds(6, 213, 105, 66);
		contentPane.add(btn7num);
		
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
		btn8num.setBounds(116, 213, 105, 66);
		contentPane.add(btn8num);
		
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
		btn9num.setBounds(226, 213, 105, 66);
		contentPane.add(btn9num);
		
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
		btn4num.setBounds(6, 278, 105, 66);
		contentPane.add(btn4num);
		
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
		btn5num.setBounds(116, 278, 105, 66);
		contentPane.add(btn5num);
		
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
		btn6num.setBounds(226, 278, 105, 66);
		contentPane.add(btn6num);
		
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
		btn1num.setBounds(6, 344, 105, 66);
		contentPane.add(btn1num);
		
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
		btn2num.setBounds(116, 344, 105, 66);
		contentPane.add(btn2num);
		
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
		btn3num.setBounds(226, 344, 105, 66);
		contentPane.add(btn3num);
		
		JButton btnUp = new JButton("");
		btnUp.setIcon(new ImageIcon("/Users/sinithleng/git/POS/image/arrowsUp.png"));
		btnUp.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnUp.setBounds(6, 415, 105, 66);
		contentPane.add(btnUp);
		
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
		btn0num.setBounds(116, 415, 105, 66);
		contentPane.add(btn0num);
		
		JButton btnDown = new JButton("");
		btnDown.setIcon(new ImageIcon("/Users/sinithleng/git/POS/image/arrowsDown.png"));
		btnDown.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnDown.setBounds(6, 488, 105, 66);
		contentPane.add(btnDown);
		
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
		btnDot.setBounds(226, 415, 105, 66);
		contentPane.add(btnDot);
		
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
						amount.removeAllFirst();
						lblChange.setText(Double.toString(change));
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
		btnEnter.setBounds(135, 490, 189, 75);
		contentPane.add(btnEnter);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogOut.setBackground(new Color(255, 0, 0));
		btnLogOut.setBounds(690, 673, 84, 44);
		contentPane.add(btnLogOut);
		
		
		
		JLabel lblTax = new JLabel("0.00");
		lblTax.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTax.setBounds(625, 429, 84, 36);
		contentPane.add(lblTax);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBackground(Color.WHITE);
		btnMenu.setBounds(603, 673, 84, 44);
		contentPane.add(btnMenu);
		
		JButton btnPrintRecipet = new JButton("Print Receipt");
		btnPrintRecipet.setBounds(6, 691, 365, 43);
		contentPane.add(btnPrintRecipet);
		
		
		
		
	}
}
