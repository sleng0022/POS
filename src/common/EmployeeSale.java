package common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeSale 
{
	static ArrayList<Integer> EmployeeID = new ArrayList<Integer>();
	static ArrayList<String> date = new ArrayList<String>();
	static ArrayList<String> TimeLogIn = new ArrayList<String>();
	static ArrayList<String> TimeLogOut = new ArrayList<String>();
	static ArrayList<Double> TotalSale = new ArrayList<Double>();
	
	
	private int size;
	private int employeeID;
	private String dateSale;
	private String timeLogin;
	private String timeLogOut;
	private Double saleToday;
	
	public EmployeeSale() throws NumberFormatException, IOException
	{
		size = 0;
		
		BufferedReader br = new BufferedReader(new FileReader("./data/employee_sell_today.csv"));
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
			EmployeeID.add(Integer.parseInt(cols[0]));
			date.add(cols[1]);
			TimeLogIn.add(cols[2]);
			TimeLogOut.add(cols[3]);
			TotalSale.add(Double.parseDouble(cols[4]));
			size++;
		}
		br.close();
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public int getEmployeeID(int index)
	{
		return this.employeeID = EmployeeID.get(index);
	}
	
	public String getdateSale(int index)
	{
		return this.dateSale = date.get(index);
	}
	
	public String gettimeLogin(int index)
	{
		return this.timeLogin = TimeLogIn.get(index);
	}
	
	public String gettimeLogOut(int index)
	{
		return this.timeLogOut = TimeLogOut.get(index);
	}
	
	public double getsaleToday(int index)
	{
		return this.saleToday = TotalSale.get(index);
	}
}
