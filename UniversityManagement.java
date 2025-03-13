// Creatio of university management class to show the university system i
import java.util.ArrayList;
import java.util.List;

// Faculty class
class Faculty {
    private String nameFaculty;

    public Faculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public String getName() {
        return nameFaculty;
    }
}

// Department class
class Department {
    private String nameDepartment;

    public Department(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public String getName() {
        return nameDepartment;
    }
}


// University class
class University {
    private String nameUniversity;
    private List<Department> departments;
    private List<Faculty> facultyMembers; 

    public University(String nameUniveristy) {
        this.nameUniversity = nameUniversity;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public void displayDepartments() {
        System.out.println("Departments at " + nameUniversity + ":");
        for (Department department : departments) {
            System.out.println("- " + department.getName());
        }
    }

    public void displayFacultyMembers() {
        System.out.println("Faculty members at " + nameUniversity + ":");
        for (Faculty faculty : facultyMembers) {
            System.out.println("- " + faculty.getName());
        }
    }

    //  deletion of University
    public void deleteUniversity() {
        System.out.println(nameUniversity + " is being deleted. All departments will be removed.");
        departments.clear();
    }
}

// Main class
public class UniversityManagement {
    public static void main(String[] args) {
        University university = new University("Chitkara University");

        // Adding departments
        university.addDepartment("Github");
        university.addDepartment("Web Development");

        // Creating faculty members
        Faculty umair = new Faculty("Umair Ali");
        Faculty shalie = new Faculty("Shalie Sharma");

        // Adding faculty members
        university.addFaculty(umair);
        university.addFaculty(shalie);

        // Displaying information
        university.displayDepartments();
        university.displayFacultyMembers();

        // Deleting university and its departments
        university.deleteUniversity();
        university.displayDepartments(); // Should show nothing
    }
}

// Output:
// Departments at null:
// - Github
// - Web Development
// Faculty members at null:
// - Umair Ali
// - Shalie Sharma
// null is being deleted. All departments will be removed.
// Departments at null:
