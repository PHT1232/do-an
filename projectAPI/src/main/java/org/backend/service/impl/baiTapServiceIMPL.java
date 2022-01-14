package org.backend.service.impl;

import org.backend.DAO.impl.baiTapIMPL;
import org.backend.entity.baiTap;
import org.backend.models.baiTapDTO;
import org.backend.service.baiTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class baiTapServiceIMPL implements baiTapService {

    @Autowired
    baiTapIMPL bti;

    @Override
    public List<baiTapDTO> getAll() {
        return null;
    }

    @Override
    public baiTapDTO getById(int id) {
        baiTap bt = bti.getById(id);
        baiTapDTO btd = new baiTapDTO();
        btd.setId(bt.getId());
        btd.setName(bt.getName());
        btd.setUsername(bt.getUsername());
        btd.setDeadline(bt.getDeadline());
        btd.setTenBaiTap(bt.getTenBaiTap());
        btd.setNoiDungBaiTap(bt.getNoiDungBaiTap());
        btd.setClassID(bt.getClassID());
        btd.setMonhocID(bt.getMonhocID());
        return btd;
    }

    @Override
    public List<baiTapDTO> getListById(int id) {
        List<baiTapDTO> ls = new ArrayList<>();
        for (baiTap bt : bti.getListById(id)) {
            baiTapDTO btd = new baiTapDTO();
            btd.setId(bt.getId());
            btd.setName(bt.getName());
            btd.setUsername(bt.getUsername());
            btd.setDeadline(bt.getDeadline());
            btd.setTenBaiTap(bt.getTenBaiTap());
            btd.setNoiDungBaiTap(bt.getNoiDungBaiTap());
            btd.setClassID(bt.getClassID());
            btd.setMonhocID(bt.getMonhocID());
            ls.add(btd);
        }
        return ls;
    }

    @Override
    public int getLastId() {
        return bti.getLastId();
    }

    @Override
    public boolean insert(baiTapDTO btd) {
        baiTap bt = new baiTap();
        bt.setId(btd.getId());
        bt.setName(btd.getName());
        bt.setUsername(btd.getUsername());
        bt.setDeadline(btd.getDeadline());
        bt.setTenBaiTap(btd.getTenBaiTap());
        bt.setNoiDungBaiTap(btd.getNoiDungBaiTap());
        bt.setClassID(btd.getClassID());
        bt.setMonhocID(btd.getMonhocID());
        return bti.insert(bt);
    }

    @Override
    public boolean update(baiTapDTO btd) {
        baiTap bt = new baiTap();
        bt.setId(btd.getId());
        bt.setName(btd.getName());
        bt.setUsername(btd.getUsername());
        bt.setDeadline(btd.getDeadline());
        bt.setTenBaiTap(btd.getTenBaiTap());
        bt.setNoiDungBaiTap(btd.getNoiDungBaiTap());
        return bti.update(bt);
    }

    @Override
    public boolean delete(int id) {
        return bti.delete(id);
    }
}
