package common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
			date.add(cols[0]);
			register.add(Integer.parseInt(cols[1]));
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
	
	public void getRegisterSaleToday(String date, String draw, String qtySale)
	{
		FileWriter writer = null;
		String FILE_HEADER = "Date, Draw, TotalSale";
		String DLIMETER_COMMA = ",";
		String DLIMETER_NEW_LINE = "\n";
		try 
		{
			writer = new FileWriter("./data/registerSale.csv");
			writer.append(FILE_HEADER.toString());
			writer.append(DLIMETER_NEW_LINE);
			writer.append(date);
			writer.append(DLIMETER_COMMA);
			writer.append(draw);
			writer.append(DLIMETER_COMMA);
			writer.append(qtySale);
			writer.append(DLIMETER_NEW_LINE);
			writer.close();
			
		}catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
