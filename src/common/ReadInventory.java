package common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadInventory 
{
	static ArrayList<Integer> id_num = new ArrayList<Integer>();
	static ArrayList<String> item = new ArrayList<String>();
	static ArrayList<Double> priceEach = new ArrayList<Double>();
	static ArrayList<String> lastOrder = new ArrayList<String>();
	static ArrayList<Integer> totalQty = new ArrayList<Integer>();
	static ArrayList<Integer> CurrentQty = new ArrayList<Integer>();
	static ArrayList<String> SupplierName = new ArrayList<String>();
	static ArrayList<String> expiration = new ArrayList<String>();
	static ArrayList<Integer> threshold = new ArrayList<Integer>();
	static ArrayList<String> commentItem = new ArrayList<String>();
	
	private int id;
	private String itemDes;
	private Double price;
	private String lastorderDate;
	private int lastOrderQty;
	private int currentInStockQty;
	private String supplier;
	private String expirationDate;
	private int thresholdQty;
	private String comment;
	private int size ;
	
	public ReadInventory() throws NumberFormatException, IOException
	{
		size = 0;
		
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
			id_num.add(Integer.parseInt(cols[0]));
			item.add(cols[1]);
			priceEach.add(Double.parseDouble(cols[2]));
			lastOrder.add(cols[3]);
			totalQty.add(Integer.parseInt(cols[4]));
			CurrentQty.add(Integer.parseInt(cols[5]));
			SupplierName.add(cols[6]);
			expiration.add(cols[7]);
			threshold.add(Integer.parseInt(cols[8]));
			commentItem.add(cols[9]);
			
		}
		br.close();
	}
	
	public int getId(int index)
	{
		return this.id = id_num.get(index);
	}
	
	public String getItemDescription(int index)
	{
		return this.itemDes = item.get(index);
	}
	
	public Double getPrice(int index)
	{
		return this.price = priceEach.get(index);
	}
	
	public String getLastOrderDate(int index)
	{
		return this.lastorderDate = lastOrder.get(index);
	}
	
	public int getLastOrderQty(int index)
	{
		return this.lastOrderQty = totalQty.get(index);
	}
	
	public String getSupplier(int index)
	{
		return this.supplier = SupplierName.get(index);
	}
	
	public String getExpirationDate(int index)
	{
		return this.expirationDate = expiration.get(index);
	}
	
	public Integer getThreshold(int index)
	{
		return this.thresholdQty = threshold.get(index);
	}
	
	public String getComment(int index)
	{
		return this.comment = commentItem.get(index);
	}
	
	public int getcurrentInStockQty(int index)
	{
		return this.currentInStockQty = CurrentQty.get(index);
	}
	
	public int getSize()
	{
		return this.size = id_num.size();
	}
}
