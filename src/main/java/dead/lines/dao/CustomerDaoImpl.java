package dead.lines.dao;

import dead.lines.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomerDaoImpl implements CustomerDao {


 /*   static {
        Customer customer = new Customer();
        customer.setId(AUTO_ID.getAndIncrement());
        customer.setName("Maria");
        customer.setMail("mail@yandex.ru");
        customers.put(customer.getId(), customer);
    }
*/
 private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> allCustomers() {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Customer").list();
        }
//        return new ArrayList<>(customers.values());


    @Override
    public void add(Customer Customer) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(Customer);
     /*   Customer.setId(AUTO_ID.getAndIncrement());
        customers.put(Customer.getId(), Customer);*/
    }

    @Override
    public void delete(Customer Customer) {
//        customers.remove(Customer.getId());
        Session session = sessionFactory.getCurrentSession();
        session.delete(Customer);
    }

    @Override
    public void edit(Customer Customer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(Customer);

//        customers.put(Customer.getId(), Customer);
    }
    @Override
    public Customer getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
//        return customers.get(id);
    }

    @Override
    public Customer findByUsername(String Username) {
        List<Customer> customers = allCustomers();
        for (Customer customer: customers) {
            if(customer.getUsername().equals(Username)) {return customer;}
        }
        return null;
    }


}
