package org.backend.DAO;

import org.backend.entity.chamDiem;

import java.util.List;

public interface chamDiemDAO {
    List<chamDiem> getAll();

    chamDiem getById(int id);

    chamDiem getByBaiTapId(String baiTap);

    chamDiem getByStudentId(String studentId);

    int getLastId();

    List<chamDiem> getListById(String id, String baiTap);

    List<chamDiem> getListByBaiTapId(int baiTap);

    List<chamDiem> getListByStudentId(String studentId);

    boolean insert(chamDiem bt);

    boolean update(chamDiem bt);

    boolean delete(int id);
}
