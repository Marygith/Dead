package dead.lines.dao;

import dead.lines.entities.Deadline;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DeadlineDaoImpl implements DeadlineDao {


 /*   static {
        Deadline Deadline = new Deadline();
        Deadline.setId(AUTO_ID.getAndIncrement());
        Deadline.setName("Maria");
        Deadline.setMail("mail@yandex.ru");
        Deadlines.put(Deadline.getId(), Deadline);
    }
*/
 private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Deadline> allDeadlines() {

        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Deadline").list();
        }
//        return new ArrayList<>(Deadlines.values());


    @Override
    public void add(Deadline Deadline) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(Deadline);
     /*   Deadline.setId(AUTO_ID.getAndIncrement());
        Deadlines.put(Deadline.getId(), Deadline);*/
    }

    @Override
    public void delete(Deadline Deadline) {
//        Deadlines.remove(Deadline.getId());
        Session session = sessionFactory.getCurrentSession();
        session.delete(Deadline);
    }

    @Override
    public void edit(Deadline Deadline) {
        Session session = sessionFactory.getCurrentSession();
        session.update(Deadline);

//        Deadlines.put(Deadline.getId(), Deadline);
    }
    @Override
    public Deadline getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Deadline.class, id);
//        return Deadlines.get(id);
    }

    @Override
    public Deadline findByName(String name) {
        List<Deadline> Deadlines = allDeadlines();
        for (Deadline Deadline: Deadlines) {
            if(Deadline.getName().equals(name)) {return Deadline;}
        }
        return null;
    }


}
