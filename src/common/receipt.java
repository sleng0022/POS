package common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class receipt 
{
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
			qty.insertLast(Double.parseDouble(cols[0]));
			item.insertLast(cols[1]);
			price.insertLast(Double.parseDouble(cols[2]));
		}
	}
	
	public int size()
	{
		return item.size();
	}
	
	public Double getQtyItem(int pos)
	{
		return qty.getItem(pos);
	}
	
	public String getItemDescription(int pos)
	{
		return item.getItem(pos);
	}
	
	public Double getPriceItem(int pos)
	{
		return price.getItem(pos);
	}
}
