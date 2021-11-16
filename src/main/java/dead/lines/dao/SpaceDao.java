package dead.lines.dao;

import dead.lines.entities.Space;

import java.util.List;

public interface SpaceDao {


    List<Space> allSpaces();
    void add(Space space);
    void delete(Space space);
    void edit(Space space);
    Space getById(int id);
}
