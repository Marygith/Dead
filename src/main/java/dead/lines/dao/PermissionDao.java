package dead.lines.dao;

import dead.lines.entities.Permission;

import java.util.List;

public interface PermissionDao {


    List<Permission> allPermissions();
    void add(Permission Permission);
    void delete(Permission Permission);
    void edit(Permission Permission);
    Permission getById(int id);
}
