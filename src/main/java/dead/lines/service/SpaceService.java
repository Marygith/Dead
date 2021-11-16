package dead.lines.service;

import dead.lines.entities.Space;

import java.util.List;

public interface SpaceService {

    List<Space> allSpaces();
    void add(Space Space);
    void delete(Space Space);
    void edit(Space Space);
    Space getById(int id);
}
