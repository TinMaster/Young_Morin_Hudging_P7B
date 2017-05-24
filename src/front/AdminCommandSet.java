package front;

import java.util.HashMap;
//import cli.*;
import data.SISMain;

public class AdminCommandSet extends CommandSet{

    //HashMap<String, Command> commands1;

    public AdminCommandSet(){
        super(); //make the base CommandSet
        commands.put("create", new createCmd());
        commands.put("createCourse", new createCourseCmd());
        commands.put("createSection", new createSectionCmd());
    }

    class createCmd implements Command{
        public void run(String[] params){
            try{
                SISMain.create(params[0], params[1], params[2]);
            }catch(ArrayIndexOutOfBoundsException ex){ //catch all error if theres no input there
                System.out.println("Error");
            }

        }

        public String helpString(){
            return "Creates a user of the type given";
        }
    }

    class createCourseCmd implements Command{
        public void run(String[] params){
            try{
                SISMain.createCourse(params[0]);
            }catch(ArrayIndexOutOfBoundsException ex){
                System.out.println("Error");
            }

        }

        public String helpString(){
            return "Creates a course";
        }
    }
    
    class createSectionCmd implements Command{
        public void run(String[] params){
            try{
                SISMain.createSection(params[0], params[1], params[2]);
            }catch(ArrayIndexOutOfBoundsException ex){
                System.out.println("Error");
            }
        }

        public String helpString(){
            return "Creates a class";
        }
    }

    class
}
