package org.backend.DAO;

import org.backend.entity.Subjects;

import java.util.List;

public interface SubjectsDAO {
    List<Subjects> getAll();

    boolean insert(Subjects subjects);

    boolean delete(String id);

    boolean update(String id, Subjects subjects);

    List<Subjects> getById(String id);
}
