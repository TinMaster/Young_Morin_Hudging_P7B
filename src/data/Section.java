
package data;

import java.util.ArrayList;
import data.user.*;

public class Section {

    public User teacher;
    public ArrayList<User> student_list;
    public int number = 0; //maybe static
    public Course parent;
    public static int sectionNumber = 1; //maybe static
    public String title;
    public ArrayList<String> assignment_list;

    public Section(Course parentx, String title){
        this.number = sectionNumber;
        this.teacher = null;
        this.parent = parentx;
        sectionNumber++;
        this.title = title;
        this.student_list = new ArrayList<User>();
        this.assignment_list = new ArrayList<String>();
    }

    // ?????
    public Section(Course parent, String title, User teach){
        this.number = sectionNumber;
        this.teacher = teach;
        this.parent = parent;
        sectionNumber++;
        this.title = title;
        this.student_list = new ArrayList<User>();
        this.assignment_list = new ArrayList<String>();
    }

    public void setTeacher(User teach){
       this.teacher = teach;
    }

    public void updateSection(String title){
       this.title = title;
    }

    public void addStudent(User stud){
        this.student_list.add(stud);
    }

    /** To String Method**/

    public String toString(){

        String s =  "Number: " + this.number + "\n" +
                    "Title: " + this.title + "\n" +
                    "Teacher: " +this.teacher + "\n"
                    "Student List: ";

        for(int i=0; i<this.student_list.size(); i++){
            s += "[ " + this.student_list.get(i).username + ", " + this.student_list.get(i).password + " ]";
        }

        s += "\n" + "Assignment List: ";

        for(String x : this.assignment_list){
            s += x + ","
        }

        return s;
    }

}
