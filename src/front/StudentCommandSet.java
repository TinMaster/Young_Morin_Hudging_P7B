package front;

import java.util.HashMap; 

public class StudentCommandSet extends CommandSet {
    
    HashMap<String, Command> commands;
    
    public StudentCommandSet(){
        super();
        //commands.put("viewsection", new viewsection());
    }
    
    class helpCmd implements Command{ 
        public void run(String[] params){ 
            System.out.println("\n" + "List of Commands" + "\n" + "-------------------"); 
            for(String key: commands.keySet()){ 
                System.out.println(key + " - " + commands.get(key).helpString()); //get the value of the key in the command set and run its helpString function 
            } 
             
            System.out.println(""); 
        } 
        
  /*      
        class viewsection implements Command{
            public void run(String[] params){
                System.out.println("Section: ");
            }

        }
        */
        
        public String helpString(){ 
            return "prints available commands"; 
        } 
    } 
}
