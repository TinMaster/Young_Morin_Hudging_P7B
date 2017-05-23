
package data;

import data.user.*;
import java.util.ArrayList;

public class Course {
    
    public String title;
    public int number; 
    public ArrayList<Section> section_list;
    public static int courseNumber = 1;
    
    //Honestly this may be redundant
    //Very redundant
    public Course(){
        this.title = "";
        this.number = courseNumber;
        this.section_list = new ArrayList<Section>();
        courseNumber++;
    }
    
    public Course(String x){
        this.title = x;
        this.number = courseNumber;
        this.section_list = new ArrayList<Section>();
        courseNumber++;
    }
    
    public void createSection(String name){
        Section a = new Section(this, name);
        this.section_list.add(a);
    }
    
    public void createSection(String name, User teacher){
        Section a = new Section(this, name, teacher);
        this.section_list.add(a);
    }
    
    public void createSection(User id){
        return;
    }
    
    public void deleteSection(Section x){
        if(this.section_list.remove(x) == true){ //returns false if its not there
            System.out.println("Section Deleted");
        }
        else{
            System.out.println("Not Found");
        }
    }
    
    
    public void getSection(Section section){
        System.out.println(section.title + ", " + section.number);
    }
    
    public void listSections(){
        for(int i=0; i<this.section_list.size(); i++){
            System.out.println(this.section_list.get(i).title);
        }
    }
    
    public Section obtainSection(String title){
        for(int i = 0; i< this.section_list.size(); i++){ 
            if(this.section_list.get(i).title == title){
                return this.section_list.get(i);
            }else{
                i++;
            }
        }
        return null;
    }
}
    
