import java.util.ArrayList;
import java.util.List;

// Order class 
class Order {
    private int orderId;
    private List<Product> products;

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products in order:");
        for (Product product : products) {
            System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
        }
    }
}


// Product class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Customer class
class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void showOrders() {
        System.out.println(name + "'s Orders:");
        for (Order order : orders) {
            order.showOrderDetails();
        }
    }
}

// E-commerce platform class
class ECommercePlatform {
    private String name;
    private List<Customer> customers;

    public ECommercePlatform(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void showCustomers() {
        System.out.println("Customers on " + name + " platform:");
        for (Customer customer : customers) {
            System.out.println("- " + customer.getName());
        }
    }
}

// Demonstration class
public class ECommerceManagement {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform("ShopEase");

        // Creating customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        // Adding customers to platform
        platform.addCustomer(alice);
        platform.addCustomer(bob);

        // Creating products
        Product laptop = new Product("Laptop", 1200.00);
        Product phone = new Product("Smartphone", 800.00);
        Product headphones = new Product("Headphones", 150.00);

        // Creating and placing orders
        Order order1 = new Order(1);
        order1.addProduct(laptop);
        order1.addProduct(headphones);
        alice.placeOrder(order1);

        Order order2 = new Order(2);
        order2.addProduct(phone);
        bob.placeOrder(order2);

        // Displaying information
        platform.showCustomers();
        alice.showOrders();
        bob.showOrders();
    }
}


// Output:
// Customers on ShopEase platform:
// - Alice
// - Bob
// Alice's Orders:
// Order ID: 1
// Products in order:
// - Laptop ($1200.0)
// - Headphones ($150.0)
// Bob's Orders:
// Order ID: 2
// Products in order:
// - Smartphone ($800.0)
