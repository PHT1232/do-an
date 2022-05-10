package org.backend.DAO;

import org.backend.entity.Learning;

import java.util.List;

public interface LearningDAO {
    List<Learning> getAll();

    boolean insert(Learning learning);

    boolean delete(String id);

    boolean update(String id, Learning learning);

    List<Learning> getById(String id);
}
