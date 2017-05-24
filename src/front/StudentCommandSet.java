package front;

import java.util.HashMap; 

import data.SISMain;

public class StudentCommandSet extends CommandSet {
    
    HashMap<String, Command> commands;
    
    public StudentCommandSet(){
        super();
        commands.put("viewsection", new viewSection());
    }
    
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

    

    class viewSection implements Command{
        public void run(String[] params){
            try{
                
                //SISMain.ListMySections();
            }catch(ArrayIndexOutOfBoundsException ex){
                System.out.println("Error");
            }
        }
            public String helpString(){
                return "Lists sections the student is in";
            }

        }
        
        
        
    }
    
    