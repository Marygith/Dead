package dead.lines.dao;

import dead.lines.entities.Space;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SpaceDaoImpl implements SpaceDao{


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Space> allSpaces() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Space").list();
    }

    @Override
    public void add(Space space) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(space);

    }

    @Override
    public void delete(Space space) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(space);

    }

    @Override
    public void edit(Space space) {
        Session session = sessionFactory.getCurrentSession();
        session.update(space);

    }

    @Override
    public Space getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Space.class, id);
    }
}
