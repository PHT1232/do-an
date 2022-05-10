package org.backend.service;

import org.backend.models.chamDiemDTO;

import java.util.List;

public interface chamDiemService {
    List<chamDiemDTO> getAll();

    chamDiemDTO getById(int id);

    chamDiemDTO getByBaiTapId(String baiTap);

    chamDiemDTO getByStudentId(String studentId);

    int getLastId();

    List<chamDiemDTO> getListById(String id, String monhoc);

    List<chamDiemDTO> getListByBaiTapId(int baiTap);

    List<chamDiemDTO> getListByStudentId(String studentId);

    boolean insert(chamDiemDTO bt);

    boolean update(chamDiemDTO bt);

    boolean delete(int id);
}
