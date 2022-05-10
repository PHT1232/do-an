package org.backend.DAO;

import org.backend.entity.baiTap;

import java.util.List;

public interface baiTapDAO {
    List<baiTap> getAll();

    baiTap getById(int id);

    int getLastId();

    List<baiTap> getListById(int id);

    boolean insert(baiTap bt);

    boolean update(baiTap bt);

    boolean delete(int id);
}
