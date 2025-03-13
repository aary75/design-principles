// Creating the BankAccouts class to display bank system
import java.util.ArrayList;
import java.util.Scanner;

// BankAccount class (Eacn customer can have multiple accounts)
class BankAccounts{
    private static int accountPresent = 0;
    private int accountNumber;
    private double balance;

    public BankAccounts(double initialDeposit){
       this.accountNumber = accountPresent++;
       this.balance = balance;
   }

  // Getters
   public int getAccountNumber() {
       return accountNumber;
   }

   public double getBalance() {
       return balance;
   }

   // Deposit money
   public void deposit(double amount) {
      balance += amount;
   }


   // Wihdraw money
   public boolean withdraw(double amount) {
       if(amount > balance) {
          System.out.println("Insufficient balance.");
          return false;
       }
       
        balance -= amount;
        return true;
   }

   // Display account details
   public void displayAccount() {
       System.out.println("Account Number: " + accountNumber + ", Balance: $" +balance);
     }
}


// Customer class ( A customer can have multiple accounts)
 class Customer {
  
     private String name;
     private ArrayList<BankAccounts> accounts;


     // Customer
     public Customer(String name) {
         this.name = name;
         this.accounts = new ArrayList<>();
     }

     // Open a new account
     public void addAccount(BankAccounts account) {
        accounts.add(account);
     }


     // view balances of all accounts
     public void viewBalance() {
         System.out.print("\nCustomer: " + name);
         if(accounts.isEmpty()) {
            System.out.print("No account found.");
         }
         else {
           for( BankAccounts account : accounts) {
               account.displayAccount();
           }
         }
     }


      // Get customer's name
     public String getName() {
        return name;
     }

     public ArrayList<BankAccounts> getAccounts() {
         return accounts;
     }
   }


// Bank class (Manages customers and accounts)
class Bank{
     private String bankName;
     private ArrayList<Customer> customers;

     public Bank(String bankName){
        this.bankName = bankName;
        this.customers = new ArrayList<>();
     }


     // Open a new account for a customer
     public void openAccount(String customerName, double initialDeposit){
          Customer customer = findCustomer(customerName);

          if(customer == null) {
              customer = new Customer(customerName);
              customers.add(customer);
          }

          BankAccounts newAccount = new BankAccounts(initialDeposit);
          customer.addAccount(newAccount);
          System.out.println("New account created for " + customerName + " with account number: " + newAccount.getAccountNumber());
     }


     // Find a customer by name
     public Customer findCustomer(String name) { 
           for(Customer customer : customers) {
              if(customer.getName().equalsIgnoreCase(name)) {
                 return customer;
              }
           }

       return null;
    }

      
    // Display all customers and their accounts
    public void displayCustomers() {
         System.out.print("\nBank: " + bankName);
         if(customers.isEmpty()) {
             System.out.println("No customers in the bank.");
         }
         else{
            for(Customer customer : customers) {
                 customer.viewBalance();
             }
         }
     }
 }
 

// Main class
 public class BankAccount {
       public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

           System.out.print("Enter Bank Name: ");
           String bankName = scanner.nextLine();
            
           
          // Bank Object
           Bank bank = new Bank(bankName);

           boolean continueBanking = true;

           while (continueBanking){
               System.out.print("\nEnter Customer Name: ");
               String customerName = scanner.nextLine();


               System.out.print("Enter Initial Deposit: ");
               double initialDeposit = scanner.nextDouble();
               scanner.nextLine(); // Consume newLine

              bank.openAccount(customerName, initialDeposit);

              System.out.print("Do you want to add more accounts? (true/false): ");
              continueBanking = scanner.nextLine().equalsIgnoreCase("true");
          }

         
         // Display all customers and their accounts
         bank.displayCustomers();
 

         // close scanner
         scanner.close();
   }
}



// Enter Bank Name: SBI

// Enter Customer Name: Aaryan
// Enter Initial Deposit: 20000
// New account created for Aaryan with account number: 0
// Do you want to add more accounts? (true/false): true

// Enter Customer Name: Hitesh
// Enter Initial Deposit: 25000
// New account created for Hitesh with account number: 1
// Do you want to add more accounts? (true/false): false

// Bank: SBI
// Customer: AaryanAccount Number: 0, Balance: $0.0

// Customer: HiteshAccount Number: 1, Balance: $0.0

































