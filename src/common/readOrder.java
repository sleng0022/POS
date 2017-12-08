package common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readOrder 
{
	static ArrayList<String> date = new ArrayList<String>();
	static ArrayList<String> item = new ArrayList<String>();
	static ArrayList<Integer> qty = new ArrayList<Integer>();
	
	private String dateOrder;
	private String itemOrder;
	private int qtyOrder;
	private int size;

	
	public readOrder() throws NumberFormatException, IOException
	{
		size = 0;
		
		BufferedReader br = new BufferedReader(new FileReader("./data/itemOrder.csv"));
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
			date.add(cols[0]);
			item.add(cols[1]);
			qty.add(Integer.parseInt(cols[2]));
			size++;
		}
		br.close();
	}
	
	public String getDate(int index)
	{
		return this.dateOrder = date.get(index);
	}
	
	public String getItemOrder(int index)
	{
		return this.itemOrder = item.get(index);
	}
	
	public int getQtyOrder(int index)
	{
		return this.qtyOrder = qty.get(index);
	}
	
	public int getSize()
	{
		return this.size;
	}

}
