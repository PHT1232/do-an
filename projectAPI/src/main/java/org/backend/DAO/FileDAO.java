package org.backend.DAO;

import org.backend.entity.Files;

import java.util.List;

public interface FileDAO {
    List<Files> getAll();

    Files getById(int id);

    List<Files> getListById(int id);

    boolean insert(Files f);

    boolean update(Files f);

    boolean delete(int id);
}
