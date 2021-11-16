package dead.lines.service;

import dead.lines.dao.CustomerDao;
import dead.lines.entities.Customer;
import dead.lines.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
/*

@Service
@Transactional
public class CustomerServiceImpl {
    @Autowired
    CustomerDao repo;

    public void save(Customer customer) {
        repo.save(customer);
    }

    public List<Customer> listAll() {
        return (List<Customer>) repo.findAll();
    }

    public Customer get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
*/


@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private CustomerDao customerDao;

    @Override
    @Transactional
    public List<Customer> allCustomers() {
        return customerDao.allCustomers();
    }

    @Override
    @Transactional
    public void add(Customer customer) {
//        customer.setName("Name");
        customer.setRoles(Collections.singleton(Role.USER));
        customerDao.add(customer);
    }

    @Override
    @Transactional
    public void delete(Customer Customer) {
        customerDao.delete(Customer);
    }

    @Override
    @Transactional
    public void edit(Customer Customer) {
        customerDao.edit(Customer);
    }

    @Override
    @Transactional
    public Customer getById(int id) {
        return customerDao.getById(id);
    }

    @Override
    @Transactional
    public Customer findByUsername(String Username) {
        return customerDao.findByUsername(Username);
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       Customer customer = customerDao.findByUsername(s);

        if (customer == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return customer;
    }


/*    @Transactional
    public List<String> allLogins() {
        List<String> logins = new ArrayList<>();
        for (Customer customer:
            customerDao.allCustomers() ) {
            logins.add(customer.getLogin());
        }
        return logins;
    }
    */
//    public boolean customerExistence()
}
