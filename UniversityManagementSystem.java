import java.util.ArrayList;
import java.util.List;

// Course class
class Course {
    private String name;
    private Professor professor;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.enrollCourse(this);
        }
    }

    public void showCourseDetails() {
        System.out.println("Course: " + name);
        if (professor != null) {
            System.out.println("Professor: " + professor.getName());
        } else {
            System.out.println("Professor: Not assigned");
        }
        System.out.println("Enrolled students:");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }
}

// Student class
class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudent(this);
        }
    }

    public void showCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println("- " + course.getName());
        }
    }
}

// Professor class
class Professor {
    private String name;
    private List<Course> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.assignProfessor(this);
        }
    }

    public void showCourses() {
        System.out.println("Professor " + name + " teaches:");
        for (Course course : courses) {
            System.out.println("- " + course.getName());
        }
    }
}

// University class
class University {
    private String name;
    private List<Student> students;
    private List<Professor> professors;
    private List<Course> courses;

    public University(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void showUniversityDetails() {
        System.out.println("University: " + name);
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
        System.out.println("Professors:");
        for (Professor professor : professors) {
            System.out.println("- " + professor.getName());
        }
        System.out.println("Courses:");
        for (Course course : courses) {
            System.out.println("- " + course.getName());
        }
    }
}

// Demonstration class
public class UniversityManagementSystem {
    public static void main(String[] args) {
        University university = new University("Tech University");

        // Creating students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Creating professors
        Professor drSmith = new Professor("Dr. Smith");
        Professor drJones = new Professor("Dr. Jones");

        // Creating courses
        Course cs101 = new Course("Computer Science 101");
        Course math101 = new Course("Mathematics 101");

        // Assigning professors
        drSmith.assignCourse(cs101);
        drJones.assignCourse(math101);

        // Enrolling students
        alice.enrollCourse(cs101);
        bob.enrollCourse(math101);
        alice.enrollCourse(math101);

        // Adding entities to the university
        university.addStudent(alice);
        university.addStudent(bob);
        university.addProfessor(drSmith);
        university.addProfessor(drJones);
        university.addCourse(cs101);
        university.addCourse(math101);

        // Displaying information
        university.showUniversityDetails();
        cs101.showCourseDetails();
        math101.showCourseDetails();
        alice.showCourses();
        bob.showCourses();
        drSmith.showCourses();
        drJones.showCourses();
    }
}


// Output:
// University: Tech University
// Students:
// - Alice
// - Bob
// Professors:
// - Dr. Smith
// - Dr. Jones
// Courses:
// - Computer Science 101
// - Mathematics 101
// Course: Computer Science 101
// Professor: Dr. Smith
// Enrolled students:
// - Alice
// Course: Mathematics 101
// Professor: Dr. Jones
// Enrolled students:
// - Bob
// - Alice
// Alice is enrolled in:
// - Computer Science 101
// - Mathematics 101
// Bob is enrolled in:
// - Mathematics 101
// Professor Dr. Smith teaches:
// - Computer Science 101
// Professor Dr. Jones teaches:
// - Mathematics 101


