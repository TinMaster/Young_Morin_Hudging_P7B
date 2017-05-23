package front;

public interface Command {
    void run(String[] params);
    String helpString(); //to add defs to each command 
}
