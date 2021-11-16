package dead.lines.service;

import dead.lines.dao.PermissionDao;
import dead.lines.entities.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionDao PermissionDao;

    @Override
    @Transactional
    public List<Permission> allPermissions() {
        return PermissionDao.allPermissions();
    }

    @Override
    @Transactional
    public void add(Permission Permission) {

        PermissionDao.add(Permission);
    }

    @Override
    @Transactional
    public void delete(Permission Permission) {
        PermissionDao.delete(Permission);

    }

    @Override
    @Transactional
    public void edit(Permission Permission) {
        PermissionDao.edit(Permission);

    }

    @Override
    @Transactional
    public Permission getById(int id) {
        return PermissionDao.getById(id);
    }
}
