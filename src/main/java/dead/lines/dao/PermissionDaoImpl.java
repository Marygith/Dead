package dead.lines.dao;

import dead.lines.entities.Permission;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PermissionDaoImpl implements PermissionDao{


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Permission> allPermissions() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Permission").list();
    }

    @Override
    public void add(Permission Permission) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(Permission);

    }

    @Override
    public void delete(Permission Permission) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(Permission);

    }

    @Override
    public void edit(Permission Permission) {
        Session session = sessionFactory.getCurrentSession();
        session.update(Permission);

    }

    @Override
    public Permission getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Permission.class, id);
    }
}
