import java.util.Scanner;
import java.util.ArrayList;

class Employee{
        
       private static int employeePresent = 1;
       private int employeeNumber;
       private String name;

       public Employee(String employeeName) {
         this.employeeNumber = employeePresent++;
         this.name = employeeName;
       }

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

class Department {
   
    private String name;
    private ArrayList<Employee> employees;

    public Department(String name){
         this.name = name;
         this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

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



 class Company {

   private String companyName;
   private ArrayList<Department> departments;

    public Company(String companyName) {
      this.companyName = companyName;
      this.departments = new ArrayList<>();
    
   }

    public void openDepartment(String departmentName, String employeeName) {
        Department department = findDepartment(departmentName);

        if(department == null) {
            department = new Department(departmentName);
            departments.add(department);
        }

        Employee newEmployee = new Employee(employeeName);
        department.addEmployee(newEmployee);
        System.out.print("New Employee with name " + employeeName + " in department " + departmentName);
   }

    public Department findDepartment(String departmentName) {
            for( Department department : departments) {
                if(department.getName().equalsIgnoreCase(departmentName)) {
                    return department;
                }
            }

         return null;
    }


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
   }


public class CompanySystem{
     public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

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


    company.displayDepartments();

     scanner.close();
}
}











