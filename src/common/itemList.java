package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class itemList 
{
	private int id;
	private String name;
	private Double price;
	private String LastOrder;
	private int qty;
	
	static DoublyLinkList<String> item = new DoublyLinkList<String>();
	static DoublyLinkList<Double> priceEach = new DoublyLinkList<Double>();
	static DoublyLinkList<String> lastOrder = new DoublyLinkList<String>();
	static DoublyLinkList<String> totalQty = new DoublyLinkList<String>();
	static DoublyLinkList<Integer> id_num = new DoublyLinkList<Integer>();
	
	public itemList() throws IOException
	{
		id = 0;
		name = null;
		price = 0.0;
		LastOrder = null;
		qty = 0;
		
		BufferedReader br = new BufferedReader(new FileReader("/Users/sinithleng/git/POS/data/itemList.csv"));
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
			totalQty.insertLast(cols[4]);
		}
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
	
	public int getQuantity(int ID)
	{
		return qty;
	}
}
