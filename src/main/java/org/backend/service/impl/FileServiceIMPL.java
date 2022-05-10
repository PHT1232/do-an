package org.backend.service.impl;

import org.backend.DAO.impl.FileIMPL;
import org.backend.entity.Files;
import org.backend.models.FilesDTO;
import org.backend.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceIMPL implements FileService {

    @Autowired
    FileIMPL fimpl;

    @Override
    public List<FilesDTO> getAll() {
        return null;
    }

    @Override
    public FilesDTO getById(int id) {
        return null;
    }

    @Override
    public List<FilesDTO> getListById(int id) {
        List<Files> filesList = fimpl.getListById(id);
        List<FilesDTO> filesDTOS = new ArrayList<>();
        for (Files files : filesList) {
            FilesDTO ftd = new FilesDTO();
            ftd.setId(files.getId());
            ftd.setFilename(files.getFilename());
            ftd.setBaiTapId(files.getBaiTapId());
            ftd.setNopBaiTapId(files.getNopBaiTapId());
            filesDTOS.add(ftd);
        }
        return filesDTOS;
    }

    @Override
    public boolean insert(FilesDTO fdt) {
        Files files = new Files();
        files.setFilename(fdt.getFilename());
        files.setNopBaiTapId(fdt.getNopBaiTapId());
        files.setBaiTapId(fdt.getBaiTapId());
        return fimpl.insert(files);
    }

    @Override
    public boolean update(FilesDTO fdt) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
