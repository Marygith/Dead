package dead.lines.service;

import dead.lines.entities.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface CustomerService extends UserDetailsService {

    List<Customer> allCustomers();
    void add(Customer Customer);
    void delete(Customer Customer);
    void edit(Customer Customer);
    Customer getById(int id);
    Customer findByUsername(String Username);

}
