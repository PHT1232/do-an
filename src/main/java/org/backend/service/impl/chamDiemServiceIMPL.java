package org.backend.service.impl;

import org.backend.DAO.chamDiemDAO;
import org.backend.entity.chamDiem;
import org.backend.models.chamDiemDTO;
import org.backend.service.chamDiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class chamDiemServiceIMPL implements chamDiemService {

    @Autowired
    chamDiemDAO cdao;

    @Override
    public List<chamDiemDTO> getAll() {
        return null;
    }

    @Override
    public chamDiemDTO getById(int id) {
        return null;
    }

    @Override
    public chamDiemDTO getByBaiTapId(String baiTap) {
        return null;
    }

    @Override
    public chamDiemDTO getByStudentId(String studentId) {
        chamDiem cd = cdao.getByStudentId(studentId);
        chamDiemDTO cdt = new chamDiemDTO();
        cdt.setId(cd.getId());
        cdt.setDiem(cd.getDiem());
        cdt.setBaiTapId(cd.getBaiTapId());
        cdt.setStudentId(cd.getStudentId());
        return cdt;
    }

    @Override
    public int getLastId() {
        return 0;
    }

    @Override
    public List<chamDiemDTO> getListById(String id, String monhoc) {
        return null;
    }

    @Override
    public List<chamDiemDTO> getListByBaiTapId(int baiTap) {
        List<chamDiem> lsc = cdao.getListByBaiTapId(baiTap);
        List<chamDiemDTO> lscdto = new ArrayList<>();
        for (chamDiem cd : lsc) {
            chamDiemDTO cdt = new chamDiemDTO();
            cdt.setId(cd.getId());
            cdt.setDiem(cd.getDiem());
            cdt.setBaiTapId(cd.getBaiTapId());
            cdt.setStudentId(cd.getStudentId());
            lscdto.add(cdt);
        }
        return lscdto;
    }

    @Override
    public List<chamDiemDTO> getListByStudentId(String studentId) {
        List<chamDiem> lsc = cdao.getListByStudentId(studentId);
        List<chamDiemDTO> lscdto = new ArrayList<>();
        for (chamDiem cd : lsc) {
            chamDiemDTO cdt = new chamDiemDTO();
            cdt.setId(cd.getId());
            cdt.setDiem(cd.getDiem());
            cdt.setBaiTapId(cd.getBaiTapId());
            cdt.setStudentId(cd.getStudentId());
            lscdto.add(cdt);
        }
        return lscdto;
    }

    @Override
    public boolean insert(chamDiemDTO bt) {
        chamDiem cd = new chamDiem();
        cd.setDiem(bt.getDiem());
        cd.setBaiTapId(bt.getBaiTapId());
        cd.setStudentId(bt.getStudentId());
        return cdao.insert(cd);
    }

    @Override
    public boolean update(chamDiemDTO bt) {
        chamDiem cd = new chamDiem();
        cd.setDiem(bt.getDiem());
        cd.setBaiTapId(bt.getBaiTapId());
        cd.setStudentId(bt.getStudentId());
        return cdao.update(cd);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
