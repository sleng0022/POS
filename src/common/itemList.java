package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class itemList 
{
	private int id;
	private String name;
	private Double price;
	private String LastOrder;
	private int oldQty;
	static DoublyLinkList<String> item = new DoublyLinkList<String>();
	static DoublyLinkList<Double> priceEach = new DoublyLinkList<Double>();
	static DoublyLinkList<String> lastOrder = new DoublyLinkList<String>();
	static DoublyLinkList<Integer> totalQty = new DoublyLinkList<Integer>();
	static DoublyLinkList<Integer> CurrentQty = new DoublyLinkList<Integer>();
	static DoublyLinkList<Integer> id_num = new DoublyLinkList<Integer>();
	static DoublyLinkList<String> supplier = new DoublyLinkList<String>();
	static DoublyLinkList<String> expiration = new DoublyLinkList<String>();
	static DoublyLinkList<Integer> threshold = new DoublyLinkList<Integer>();
	static DoublyLinkList<String> comment = new DoublyLinkList<String>();
	
	
	public itemList() throws IOException
	{
		id = 0;
		name = null;
		price = 0.0;
		LastOrder = null;
		
		BufferedReader br = new BufferedReader(new FileReader("./data/itemList.csv"));
		String line = null;
		int iteration = 0;
		
		
		
		while((line = br.readLine()) != null)
		{
			if(iteration == 0)
			{
				iteration ++;
				continue;
			}
			String cols[] = line.split(",");
			id_num.insertLast(Integer.parseInt(cols[0]));
			item.insertLast(cols[1]);
			priceEach.insertLast(Double.parseDouble(cols[2]));
			lastOrder.insertLast(cols[3]);
			totalQty.insertLast(Integer.parseInt(cols[4]));
			CurrentQty.insertLast(Integer.parseInt(cols[5]));
			supplier.insertLast(cols[6]);
			expiration.insertLast(cols[7]);
			threshold.insertLast(Integer.parseInt(cols[8]));
			comment.insertLast(cols[9]);
		}
		br.close();
	}
	
	
	
	public String getItemDescription(int ID)
	{
		String name = null;
		int position = 0;
		
		if(id_num.searItemForward(ID) == 1)
		{
			position = id_num.getItemPosition(ID);
			name = item.getItem(position);
			return name;
		}
		
		return name;
	}
	
	public int getItemID(String name)
	{
		int id = 0;
		int position = 0;
		if(item.searItemForward(name) == 1)
		{
			position = item.getItemPosition(name);
			id = id_num.getItem(position);
			return id;
		}
		
		return id;
	}
	
	public Double getPriceWithDescription(String name)
	{
		double price = 0.0;
		int position = 0;
		if(item.searItemForward(name) == 1)
		{
			position = item.getItemPosition(name);
			price = priceEach.getItem(position);
			return price;
		}
		return price;
	}
	
	public String getLastOrderDate(int ID)
	{
		return LastOrder;
	}
	
	public int getQuantity(String name)
	{
		int qty = 0;
		int position = 0;
		if(item.searItemForward(name) == 1)
		{
			position = item.getItemPosition(name);
			qty = CurrentQty.getItem(position);
			return qty;
		}
		return qty;
	}
	
	public int getTotalQty(String name)
	{
		int qty = 0;
		int position = 0;
		if(item.searItemForward(name) == 1)
		{
			position = item.getItemPosition(name);
			qty = totalQty.getItem(position);
			
			return qty;
		}
		return qty;
	}
	
	public void setUpdateNewQuantity(int newQty, String name)
	{
		int position = 0;
		int newVal = 0;
		if(item.searItemForward(name) == 1)
		{
			position = item.getItemPosition(name);
			oldQty = this.getQuantity(name);
			newVal = oldQty - newQty;
			
			if(newVal < threshold.getItem(position))
			{
				this.orderItem(name);
			}
			
			CurrentQty.setItem(position, newVal);
		}
	}
	
	public void updateItemListFile()
	{
		FileWriter writer = null;
		String FILE_HEADER = "Id, Item, Price,Last Order, Total Qty, Current Qty, Supplier, Expiration, Threshold, Comment";
		String DLIMETER_COMMA = ",";
		String DLIMETER_NEW_LINE = "\n";
		try 
		{
			writer = new FileWriter("./data/itemList.csv");
			writer.append(FILE_HEADER.toString());
			writer.append(DLIMETER_NEW_LINE);
			for(int i=0; i<item.size(); i++)
			{	
				writer.append(id_num.getItem(i).toString());
				writer.append(DLIMETER_COMMA);
				writer.append(item.getItem(i).toString());
				writer.append(DLIMETER_COMMA);
				writer.append(priceEach.getItem(i).toString());
				writer.append(DLIMETER_COMMA);
				writer.append(lastOrder.getItem(i).toString());
				writer.append(DLIMETER_COMMA);
				writer.append(totalQty.getItem(i).toString());
				writer.append(DLIMETER_COMMA);
				writer.append(CurrentQty.getItem(i).toString());
				writer.append(DLIMETER_COMMA);
				writer.append(supplier.getItem(i).toString());
				writer.append(DLIMETER_COMMA);
				writer.append(expiration.getItem(i).toString());
				writer.append(DLIMETER_COMMA);
				writer.append(threshold.getItem(i).toString());
				writer.append(DLIMETER_COMMA);
				writer.append(comment.getItem(i).toString());
				writer.append(DLIMETER_NEW_LINE);
			}

			writer.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public String getDate()
	{
		String date;
		Calendar now = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
		date = df.format(now.getTime());
		
		return date;
	}
	
	public void orderItem(String name)
	{
		FileWriter writer = null;
		String FILE_HEADER = "Date, Item, Qty";
		String DLIMETER_COMMA = ",";
		String DLIMETER_NEW_LINE = "\n";
		int id = getItemID(name);
		try 
		{
			writer = new FileWriter("./data/itemOrder.csv");
			writer.append(FILE_HEADER.toString());
			writer.append(DLIMETER_NEW_LINE);
			for(int i=0; i<item.size(); i++)
			{	
				writer.append(this.getDate());
				writer.append(DLIMETER_COMMA);
				writer.append(this.getItemDescription(id));
				writer.append(DLIMETER_COMMA);
				writer.append(Integer.toString(this.getTotalQty(name)));
				writer.append(DLIMETER_NEW_LINE);
			}

			writer.close();
		}catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
