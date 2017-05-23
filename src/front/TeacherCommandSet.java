package front;

import java.util.HashMap; 
//import cli.*;
import data.SISMain;

public class TeacherCommandSet extends CommandSet{
    
    //HashMap<String, Command> commands1;
    
    public TeacherCommandSet(){ 
        super(); //make the base CommandSet
        commands.put("createAssignment", new createAssignment());
    }
    
    
     
    class createAssignment implements Command{
        public void run(String[] params){
            //create User Object
            //then add to db.user_list
            try{
                
                SISMain.createAssignment(params[0], params[1], params[2]);
                //coursename, section#, assignmentname
            }catch(ArrayIndexOutOfBoundsException ex){
                System.out.println("Error");
            }
            
        }
        
        public String helpString(){
            return "Creates a teacher";
        }
    }   
    
    class MySections implements Command{
        public void run(String[] params){
            //create User Object
            //then add to db.user_list
            try{
                
                SISMain.MySections();
                //coursename, section#, assignmentname
            }catch(ArrayIndexOutOfBoundsException ex){
                System.out.println("Error");
            }
            
        }
        
        public String helpString(){
            return "ListsMySections";
        }
    }    

  }
  



