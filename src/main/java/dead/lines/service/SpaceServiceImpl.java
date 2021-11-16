package dead.lines.service;

import dead.lines.dao.SpaceDao;
import dead.lines.entities.Space;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class SpaceServiceImpl implements SpaceService{

    @Autowired
    private SpaceDao spaceDao;

    @Override
    @Transactional
    public List<Space> allSpaces() {
        return spaceDao.allSpaces();
    }

    @Override
    @Transactional
    public void add(Space Space) {

        spaceDao.add(Space);
    }

    @Override
    @Transactional
    public void delete(Space Space) {
        spaceDao.delete(Space);

    }

    @Override
    @Transactional
    public void edit(Space Space) {
        spaceDao.edit(Space);

    }

    @Override
    @Transactional
    public Space getById(int id) {
        return spaceDao.getById(id);
    }
}
