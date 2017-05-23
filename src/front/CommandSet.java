package front; 

import data.SISMain; 
import java.util.HashMap; 
//import data.SISMain; //odd
 
public class CommandSet { 
     
    HashMap<String, Command> commands; 
    
       /************* CONSTRUCTOR ****************/ 
     
    //Build the hashmap here 
    public CommandSet() { 
 
        commands=new HashMap<String, Command>(); 
 
        // add commands here     
        commands.put("echo", new echoCmd()); 
        commands.put("login", new loginCmd()); 
        commands.put("help", new helpCmd()); 
        commands.put("logout", new logoutCmd()); 
        commands.put("quit", new quitCmd()); 
         
    } 

    
       /************* COMMAND DEFINITIONS ****************/         
      //Its how we are gonna run the commands defined in SISMain 
     
    /** 
     * echo command - prints the parameters 
     */ 
    class echoCmd implements Command { 
        public void run(String[] params) { 
            for( int i=0; i<params.length; i++){ 
                System.out.print( params[i] + " " );
            }
            System.out.println(); 
            
        } 
        public String helpString(){ 
            return "prints input to the terminal"; 
             
        }
    } 
     
    /** 
     * login command - logs the user in  
     */ 
    class loginCmd implements Command{ 
        public void run(String[] params){ //run() from the command interface 
            try{ 
                if(params[0] != null && params[1] != null){ 
                      SISMain.login(params[0], params[1]); //call the login function from SISMain 
                } 
            //if the params array is empty   
            }catch(ArrayIndexOutOfBoundsException ex) { 
                System.out.println("Login Failed");
            }
        }     
     
 
        public String helpString(){ 
            return "login using your username and password"; 
        } 
    } 
     
    /** 
     * help command - prints avaible commands  
     */ 
     
    class helpCmd implements Command{ 
        public void run(String[] params){ 
            System.out.println("\n" + "List of Commands" + "\n" + "-------------------"); 
            for(String key: commands.keySet()){ 
                System.out.println(key + " - " + commands.get(key).helpString()); //get the value of the key in the command set and run its helpString function 
            } 
             
            System.out.println(""); 
        } 
        public String helpString(){ 
            return "prints available commands"; 
        } 
    } 
     
    /** 
     * logout command - logs the user out 
     */ 
    class logoutCmd implements Command{ 
        public void run(String[] params){ 
            if(params.length == 0){ 
                SISMain.logout(); 
            } 
            else { 
                System.out.println("Error"); 
            } 
            
        } 
        public String helpString(){ 
            return "used to log out"; 
        }
    }
     
    /** 
     * exit command - closes the application 
     */ 
     
    class quitCmd implements Command{ 
        public void run(String[] params){ 
            System.exit(0); 
        } 
        public String helpString(){ 
            return "exits the application"; 
        } 
    } 
 
} 
