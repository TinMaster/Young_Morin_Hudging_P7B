package front;

import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class CLI {
    
    BufferedReader reader;    
    HashMap<String, Command> commands;
    CommandSet cmdSet;

    /************CONSTRUCTOR**************/
    
    // initialize fields and add commands
    public CLI(){
        CommandSet base = new CommandSet(); //TODO if changed to adminCommandSet test works
        commands = base.commands;    
    }    
    
    /*********** ACCESSORS *********************/
    
    public String getCmdList(){        
        String clist = "[ ";
        
        for( String key : commands.keySet()){
            clist += key + ", ";
        }
        
        clist += " ]";
        return clist;
    }
    
    /************* MODIFIERS ************/
    
    public void setReader( BufferedReader in){
        reader=in;
    }    
    
    public void setCommandSet( CommandSet cs ){
        commands = cs.commands;
        
        /* TODO
        if(cs instanceof AdminCommandSet){
            System.out.println("woo");
        }
        
        for( String key: commands.keySet()){
            System.out.println(key);
        }
        */

    }
    
    /************ PRIVATE METHODS ******************/

    // get a command and call it's run method with params
    private void process(String cmd, String[] params){
        
        if(commands.containsKey(cmd))
            commands.get(cmd).run(params);
        else
            System.out.println("Command not recognized");
        
    }
    


    /************** PUBLIC METHODS ************************/

    // run the CLI loop
    public void start() throws IOException{ 
        
        String line, cmd;
        String[] params;
        
        // read until we run out of input
        while((line = reader.readLine()) != null){

            line = line.trim();

            // ignore whitespace lines and lines beginning with #
            if(line.equals("") || line.charAt(0)=='#')
                continue;
            
            // does this command have params?
            int i = line.indexOf(' ');
            if( i > -1){
                cmd = line.substring(0,i);
                params = line.substring(i+1).split(" ");  
            }
            else{
                cmd = line;
                params = new String[]{};  
            }

            // run the command
            
            /* TODO
            for( String key: commands.keySet()){
                System.out.println(key);
            }
            */
            process(cmd, params);            
        }
    }
    
    /************ UNIT TESTING ****************/

    public static void main(String[] args){
        
        // read from consoleIn
        BufferedReader consoleIn;    
        consoleIn = new BufferedReader(new InputStreamReader(System.in));

        /* OR READ FROM A FILE:
        // reading from a file
        BufferedReader fileIn;
        fileIn = new BufferedReader(new FileReader("testinput"));
        */

        CLI cli = new CLI();
        cli.setReader(consoleIn);
        
        try {
            cli.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    
    }
}
