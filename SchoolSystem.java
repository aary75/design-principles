import java.util.Scanner;
import java.util.ArrayList;

// Student class 
class Student{
        
       private String name;
       private ArrayList<Course> courses;

       // Constructor
       public Student(String studentName) {
         this.courses = new ArrayList<>();
         this.name = studentName;
       }

       public String getName() {
           return name;
       }

       public void enrollInCourse(Course course) {
           if(!courses.contains(course)) {
               courses.add(course);
               course.enrollStudent(this);
           }
      }

       public void showCourses() {
           System.out.println("Courses " + name + " is enrolled in:");
           for(Course course : courses) {
              System.out.println("-" + course.getName());
           }
      }
}

// Course class
class Course {
   
    // Constructor
    private String name;
    private ArrayList<Student> students;

    public Course(String name){
         this.name = name;
         this.students = new ArrayList<>();
    }

    
    // Add an student to the course
    public void enrollStudent(Student student) {
        if(students.contains(student)){
            students.add(student);
            student.enrollInCourse(this);
        }
    }

    // Display the students
    public void showStudents() {
         System.out.print("\nCourse: " + name);

     
            for( Student student : students) {
              student.getName();
            }
        }
     

     public String getName() {
         return name;
     }

   
}


// School Class (Owns multiple school - composition)
 class School {

   private String schoolName;
   private ArrayList<Student> students;

    // Constructor
    public School(String schoolName) {
      this.schoolName = schoolName;
      this.students = new ArrayList<>();
    
   }

    public void addStudent(Student student) {
         if(!students.contains(student)) {
            students.add(student);
         }
    }

    public void showStudents() {
         System.out.println("Students at " + schoolName + ":");
 
         for(Student student : students) {
             System.out.println("-" + student.getName());
         }
  
      }

   }


// Main class
public class SchoolSystem{
     public static void main(String[] args) {
       School school = new School("MDN Public School");

        //Creating the students
        Student aaryan = new Student("Aaryan");
        Student hitesh = new Student("Hitesh");

        // Adding students to the shcool
        school.addStudent(aaryan);
        school.addStudent(hitesh);

        // Creating courses
        Course webDevelopment = new Course("Web Development");
        Course git = new Course("Git");

       // Enrolling studetns in courses
       aaryan.enrollInCourse(webDevelopment);
       aaryan.enrollInCourse(git);
       hitesh.enrollInCourse(webDevelopment);

       // Displaying information
       school.showStudents();
       aaryan.showCourses();
       hitesh.showCourses();
       webDevelopment.showStudents();
       git.showStudents();
}
}

// Output:
// Students at MDN Public School:
// -Aaryan
// -Hitesh
// Courses Aaryan is enrolled in:
// -Web Development
// -Git
// Courses Hitesh is enrolled in:
// -Web Development

// Course: Web Development
// Course: Git
