 package frame;

import java.util.Arrays;
import java.util.HashMap;

public class Login {
 
	private String userName;
	private boolean isValidUser;
	HashMap<String, char[]> map;
	char[] pwd = {'1', '2', '3'};
	
	public Login()
	{
		map = new HashMap<>();
		isValidUser = false;
        
        map.put("Aziz", pwd);
        map.put("Sinith", pwd);
	}
	
    public boolean authenticate(String name, char[] pwd) 
    {
    		if(map.containsKey(name))
    		{
    			if(Arrays.equals(map.get(name), pwd))
    			{
    				isValidUser = true;
    				this.userName = name;
    			}
    		}
    		
    		return isValidUser;
    }
    
    public String getUserName()
    {
    		return this.userName;
    }
}
