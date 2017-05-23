package front;

import java.util.HashMap; 
//import cli.*;
import data.SISMain;

public class AdminCommandSet extends CommandSet{
    
    //HashMap<String, Command> commands1;
    
    public AdminCommandSet(){ 
        super(); //make the base CommandSet
        commands.put("test", new testCmd());
        commands.put("create", new createCmd());
    }
    
    class testCmd implements Command{
        public void run(String[] params){
            System.out.println("x");
        }
        public String helpString(){
            return "test";
        }
    }
    
    class createCmd implements Command{
        public void run(String[] params){
            try{
                SISMain.createTeacher(params[0], params[1], params[2]);
            }catch(ArrayIndexOutOfBoundsException ex){ //catch all error if theres no input there
                System.out.println("Error");
            }
            
        }
        
        public String helpString(){
            return "Creates a teacher";
        }
    }
}
