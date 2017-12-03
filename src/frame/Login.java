 package frame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
 
    public static boolean authenticate(String username, String password) throws IOException {
    	System.out.println(System.getProperty("user.dir"));
    	
    	 BufferedReader br = new BufferedReader(new FileReader("data/Login2.csv"));
    	 
    	
    	 
		    String line =  null;
		    HashMap<String,String> map = new HashMap<String, String>();

		    while((line=br.readLine())  !=null){	
		    	String str[] = line.split(",");
	            map.put(str[0], str[1]);
	        }
		
		    for (Map.Entry<String, String> entry : map.entrySet())
		    {		     		        
		        if (entry.getKey().equals(username) && entry.getValue().equals(password)){
		        	return true;
		        }
		    
		    }
        
        return false;
    	
        // hardcoded username and password
   //     if (username.equals("Aziz") && password.equals("123")) 
    //    	 return true;
    //    if(username.equals("m") && password.equals("123")){
     //       return true;
      //  }
     
    }
}

