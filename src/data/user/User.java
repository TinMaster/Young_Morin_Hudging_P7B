package data.user;

import java.util.ArrayList;
import data.Section;

public class User {
     //public section_list; //classes the user can sign up for
    
    public int id;
    public String username;
    public String password;
    public ArrayList<Section> section_list;
    public static int UserId = 1;
    
    
    //----- - - ---- --  --  --- this makes the stuff --------------- ----- - - -
    public User(){
        this.id = UserId;
        this.username = "";
        this.password = "";
        UserId++;
    }

    public User(String u, String p){
        this.id = UserId;
        this.username = u;
        this.password = p;
        UserId++;
    }
    
   
    // ---- -- -- ------- THINGS IT CAN DO -- -- ------- - --- ---- - -- - --
    
    public void join(Section section){
        section.student_list.add(this);
    }
}

