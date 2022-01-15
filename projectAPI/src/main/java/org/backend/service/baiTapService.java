package org.backend.service;

import org.backend.models.baiTapDTO;

import java.util.List;

public interface baiTapService {
    List<baiTapDTO> getAll();

    baiTapDTO getById(int id);

    List<baiTapDTO> getListById(String id, String monhoc);

    int getLastId();

    boolean insert(baiTapDTO btd);

    boolean update(baiTapDTO btd);

    boolean delete(int id);
}
