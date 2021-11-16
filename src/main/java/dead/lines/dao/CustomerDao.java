package dead.lines.dao;

import dead.lines.entities.Customer;
//import org.springframework.data.repository.CrudRepository;

import java.util.List;




/*
public  interface CustomerDao extends CrudRepository<Customer,Long> {
}*/


public interface CustomerDao {

    List<Customer> allCustomers();
    void add(Customer Customer);
    void delete(Customer Customer);
    void edit(Customer Customer);
    Customer getById(int id);
    Customer findByUsername(String Username);

}
