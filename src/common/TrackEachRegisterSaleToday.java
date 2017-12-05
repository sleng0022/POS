package common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TrackEachRegisterSaleToday 
{
	static ArrayList<Integer> register = new ArrayList<Integer>();
	static ArrayList<String> date = new ArrayList<String>();
	static ArrayList<Double> totalSale = new ArrayList<Double>();
	
	private int registerID;
	private int size;
	private String todaySaleDate;
	private Double todayTotalSale;

	
	public TrackEachRegisterSaleToday() throws NumberFormatException, IOException
	{
		size = 0;
		
		BufferedReader br = new BufferedReader(new FileReader("./data/registerSale.csv"));
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
			register.add(Integer.parseInt(cols[0]));
			date.add(cols[1]);
			totalSale.add(Double.parseDouble(cols[2]));
			size++;
		}
		br.close();
	}
	
	public int getRegisterID(int index)
	{
		return this.registerID = register.get(index);
	}
	
	public String gettodaySaleDate(int index)
	{
		return this.todaySaleDate = date.get(index);
	}
	
	public Double gettodayTotalSale(int index)
	{
		return this.todayTotalSale = totalSale.get(index);
	}
	
	public int getSize()
	{
		return this.size;
	}

}
