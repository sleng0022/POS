package common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class receipt 
{
	static DoublyLinkList<Integer> id = new DoublyLinkList<Integer>();
	static DoublyLinkList<Double> qty = new DoublyLinkList<Double>();
	static DoublyLinkList<String> item = new DoublyLinkList<String>();
	static DoublyLinkList<Double> price = new DoublyLinkList<Double>();
	private int size;
	public receipt() throws IOException
	{
		size = 0;
		
		BufferedReader br = new BufferedReader(new FileReader("./data/receipt.csv"));
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
			id.insertLast(Integer.parseInt(cols[0]));
			qty.insertLast(Double.parseDouble(cols[1]));
			item.insertLast(cols[2]);
			price.insertLast(Double.parseDouble(cols[3]));
		}
		br.close();
	}
	
	public int size()
	{
		return item.size();
	}
	
	public Double getQtyItem(int pos, int receiptID)
	{
		if(id.getItem(pos).equals(receiptID))
		{
			return qty.getItem(pos);
		}
		return 0.0;
	}
	
	public String getItemDescription(int pos, int receiptID)
	{
		if(id.getItem(pos).equals(receiptID))
		{
			return item.getItem(pos);
		}
		return "INVALID";
	}
	
	public Double getPriceItem(int pos, int receiptID)
	{
		if(id.getItem(pos).equals(receiptID))
		{
			return price.getItem(pos);
		}
		return 0.0;
	}
}
