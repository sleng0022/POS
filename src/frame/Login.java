 package frame;

import java.util.HashMap;

public class Login {
 
	private String userName;
	private boolean isValidUser;
	HashMap<String, Integer> map;
	
	public Login()
	{
		map = new HashMap<>();
		isValidUser = false;
        
        map.put("Aziz", 123);
        map.put("Sinith", 123);
	}
	
    public boolean authenticate(String name, int pwd) 
    {
    		if(map.containsKey(name))
    		{
    			if(map.get(name) == pwd)
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
