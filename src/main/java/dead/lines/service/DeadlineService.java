package dead.lines.service;

import dead.lines.entities.Deadline;

import java.util.List;

public interface DeadlineService {

    List<Deadline> allDeadlines();
    void add(Deadline Deadline);
    void delete(Deadline Deadline);
    void edit(Deadline Deadline);
    Deadline getById(int id);
}
