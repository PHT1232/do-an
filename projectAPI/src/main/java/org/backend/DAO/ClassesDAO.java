package org.backend.DAO;

import org.backend.entity.Classes;

import java.util.List;

public interface ClassesDAO {
    List<Classes> getAll();

    boolean insert(Classes teacher);

    boolean update(String id, Classes teacher);

    boolean delete(String id);

    List<Classes> getById(String id);

    Classes getBySingleId(String id);

    Classes getByUser(String id);
}
