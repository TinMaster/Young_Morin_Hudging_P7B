package data.user;

import java.util.ArrayList;

public class User_Student extends User{
    public int yog;
    
    public ArrayList<User> esection_list;
    
    public User_Student(String u, String p, int x){
        super(u,p);
        this.yog = x;
        this.esection_list = new ArrayList();
    }

    public int getYOG(){
        return this.yog;
    }
}
