import java.util.Scanner;
import java.util.ArrayList;

// Employee class 
class Employee{
        
       private static int employeePresent = 1;
       private int employeeNumber;
       private String name;

       // Constructor
       public Employee(String employeeName) {
         this.employeeNumber = employeePresent++;
         this.name = employeeName;
       }

      // Displaying employee details
       public int getEmployeeNumber() {
         return employeeNumber;
       }

       public String getName() {
           return name;
       }

       public void displayEmployee() {
          System.out.println("Employee Number: " + employeeNumber + ", Name: " + name);
       }
}

// Department class
class Department {
   
    // Constructor
    private String name;
    private ArrayList<Employee> employees;

    public Department(String name){
         this.name = name;
         this.employees = new ArrayList<>();
    }

    
    // Add an employee to the department
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Display the empoyees
    public void viewEmployee() {
         System.out.print("\nDeparment: " + name);

         if(employees.isEmpty()) {
            System.out.print("No employee found.");
         }
         else {
            for( Employee employee : employees) {
              employee.displayEmployee();
            }
        }
     }

     public String getName() {
         return name;
     }

     public ArrayList<Employee> getEmployees() {
         return employees;
     }
}


// Company Class (Owns multiple departments - composition)
 class Company {

   private String companyName;
   private ArrayList<Department> departments;

    // Constructor
    public Company(String companyName) {
      this.companyName = companyName;
      this.departments = new ArrayList<>();
    
   }


    // Add an employee to a specific department
    public void openDepartment(String departmentName, String employeeName) {
        Department department = findDepartment(departmentName);

        // Add a department to the company
        if(department == null) {
            department = new Department(departmentName);
            departments.add(department);
        }

        Employee newEmployee = new Employee(employeeName);
        department.addEmployee(newEmployee);
        System.out.print("New Employee with name " + employeeName + " in department " + departmentName);
   }

    // Find a department by name
    public Department findDepartment(String departmentName) {
            for( Department department : departments) {
                if(department.getName().equalsIgnoreCase(departmentName)) {
                    return department;
                }
            }

         return null;
    }


    // Display company details
    public void displayDepartments() {
        System.out.print("\nCompany: " + companyName);
         
         if(departments.isEmpty()) {
             System.out.print("No departments in this company.");
          }
          else{ 
            for( Department department : departments) {
               department.viewEmployee();
            }
         }
      }

     
     // Destructor 
     public void deleteCompany() {
         System.out.println("\nDeleting Company: " + companyName);
         departments.clear();  // Removes all deparments ( and their employees)
         System.out.print("All departments and employees deleted.");
     }
   }


// Main class
public class CompanySystem{
     public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       // Create company
       System.out.print("Enter Company Name: ");
       String companyName = scanner.nextLine();

       Company company = new Company(companyName);

       boolean continueBusiness = true;

       while (continueBusiness) {
           System.out.print("\nEnter Department Name: ");
           String departmentName = scanner.nextLine();

           System.out.print("Enter Customer Name: ");
           String customerName = scanner.nextLine();

           company.openDepartment(departmentName, customerName);

           System.out.print("\nDo you want to add more customers? (true/false): ");
           continueBusiness = scanner.nextLine().equalsIgnoreCase("true");

      }

    // Display the entire company structure
    company.displayDepartments();
       
      
      // Delete company
      System.out.print("\nDo you want to delete the company? (true/false): ");
      if (scanner.nextLine().equalsIgnoreCase("true")) {
           company.deleteCompany();
       }

     // close scanner
     scanner.close();
}
}


// Input:
// Enter Company Name: Google

// Enter Department Name: Tech
// Enter Customer Name: Aaryan
// New Employee with name Aaryan in department Tech
// Do you want to add more customers? (true/false): true

// Enter Department Name: Hitesh
// Enter Customer Name: Tech
// New Employee with name Tech in department Hitesh
// Do you want to add more customers? (true/false): false

// Output:
// Company: Google
// Deparment: TechEmployee Number: 1, Name: Aaryan

// Deparment: HiteshEmployee Number: 2, Name: Tech

// Do you want to delete the company? (true/false): true

// Deleting Company: Google
// All departments and employees deleted.









