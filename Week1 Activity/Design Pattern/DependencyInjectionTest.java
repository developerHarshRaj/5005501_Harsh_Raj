import java.util.HashMap;
import java.util.Map;

interface CustomerRepository {
    Customer findCustomerById(String customerId);
}

class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> customerDatabase;

    public CustomerRepositoryImpl() {
        customerDatabase = new HashMap<>();
        // Adding some dummy data
        customerDatabase.put("1", new Customer("1", "Alice Johnson"));
        customerDatabase.put("2", new Customer("2", "Bob Smith"));
    }

    @Override
    public Customer findCustomerById(String customerId) {
        return customerDatabase.get(customerId);
    }
}

class CustomerService {
    private CustomerRepository customerRepository;

   
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(String customerId) {
        return customerRepository.findCustomerById(customerId);
    }
}

class Customer {
    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}


public class DependencyInjectionTest {
    public static void main(String[] args) {
        
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        
        CustomerService customerService = new CustomerService(customerRepository);

        
        String customerId = "1";
        Customer customer = customerService.getCustomerById(customerId);

        
        if (customer != null) {
            System.out.println("Customer Found:");
            System.out.println("ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
        } else {
            System.out.println("Customer with ID " + customerId + " not found.");
        }
    }
}

