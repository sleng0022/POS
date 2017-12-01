 package frame;

public class Login {
 
    public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (username.equals("Aziz") && password.equals("123")) 
        	 return true;
        if(username.equals("m") && password.equals("123")){
            return true;
        }
        return false;
    }
}

