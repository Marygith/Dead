package dead.lines.dao;

import dead.lines.entities.Deadline;

import java.util.List;




/*
public  interface DeadlineDao extends CrudRepository<Deadline,Long> {
}*/


public interface DeadlineDao {

    List<Deadline> allDeadlines();
    void add(Deadline Deadline);
    void delete(Deadline Deadline);
    void edit(Deadline Deadline);
    Deadline getById(int id);
    Deadline findByName(String name);

}
