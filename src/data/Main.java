
package data;

import data.user.*;
public class Main {
    public static void main(String[] args){
        //Initialize Database
        Database db = new Database(); //new stuff
        
        //Make Course
        Course course1 = new Course("English"); //variable name so you can access course through get course
        db.course_list.add(course1);
        
        Course course2 = new Course("Math");
        db.course_list.add(course2);
        
        Course course3 = new Course("Glaciology");
        db.course_list.add(course3);
        
        Course course4 = new Course("Social Studies");
        db.course_list.add(course4);
        
        Course course5 = new Course("Science");
        db.course_list.add(course5);
        
        //Make Users
        User mildred = new User("mildredmogo", "pass");
        db.user_list.add(mildred);
        User ryan = new User("user2", "pass2");
        db.user_list.add(ryan);
        User ramses = new User("user3", "pass3");
        db.user_list.add(ramses);
        
        
        //Testing Database Functions
        System.out.println("DATABASE COURSE FUNCTIONS TEST");
        
        db.listCourses();
        System.out.println("-------------------");
        db.deleteCourse(course4); 
        db.listCourses();
        System.out.println("-------------------");
        System.out.println(db.getCourse(course3));
        System.out.println("-------------------");
        db.updateCourse(course5, "Floral Management"); //OCEANOGRAPHY MASTER RACE
        
        System.out.println();
        System.out.println("DATABASE USER FUNCTIONS TEST");
        
        //Testing User Functions
        db.updateUser(ryan, "gerald", "linguini"); //Cant touch id's
        db.updateUser(ramses, "zeus", "spaghetti"); //Cant touch id's
        db.listUsers();
        System.out.println("-------------------");
        System.out.println(db.getUser(mildred));
        System.out.println("-------------------");
        db.deleteUser(ryan);
        db.listUsers();
        System.out.println("-------------------");
        db.listUsers();
         
        //Testing Section Functions
        System.out.println();
        System.out.println("SECTION TESTS");
        System.out.println("-------------------");
        
        //Make sections (Create classes for user to join)
        course1.createSection("class1"); //create section without teacher
        course1.obtainSection("class1").setTeacher(ramses);
        System.out.println(course1.obtainSection("class1").teacher.username);//gordan == ramses
        System.out.println("-------------------");        
        
        //User functions
        mildred.join(course1.obtainSection("class1"));        
        course1.obtainSection("class1").listStudents();
        System.out.println("-------------------");
        
        //Test section delete and update functions
        Section section1 = course1.obtainSection("class1");
        course1.obtainSection("class1").updateSection("classcoolio");
        System.out.println("asdf");
        System.out.println("-------------------");
        
        //Section funcitons
        course1.listSections(); //now you see me
        course1.getSection(section1);
        section1.updateSection("yay"); //cant change id's cuz theyre generated overwriting = bad
        course1.getSection(section1);
        course1.deleteSection(section1);
        course1.listSections(); //now you don't
        
        
        //User Hierachy tests
        
        //
    } 
}