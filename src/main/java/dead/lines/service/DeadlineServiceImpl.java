package dead.lines.service;

import dead.lines.dao.DeadlineDao;
import dead.lines.entities.Deadline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class DeadlineServiceImpl implements DeadlineService{

    @Autowired
    private DeadlineDao DeadlineDao;

    @Override
    @Transactional
    public List<Deadline> allDeadlines() {
        return DeadlineDao.allDeadlines();
    }

    @Override
    @Transactional
    public void add(Deadline Deadline) {

        DeadlineDao.add(Deadline);
    }

    @Override
    @Transactional
    public void delete(Deadline Deadline) {
        DeadlineDao.delete(Deadline);

    }

    @Override
    @Transactional
    public void edit(Deadline Deadline) {
        DeadlineDao.edit(Deadline);

    }

    @Override
    @Transactional
    public Deadline getById(int id) {
        return DeadlineDao.getById(id);
    }
}
