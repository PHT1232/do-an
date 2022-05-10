package org.backend.service;

import org.backend.models.FilesDTO;

import java.util.List;

public interface FileService {
    List<FilesDTO> getAll();

    FilesDTO getById(int id);

    List<FilesDTO> getListById(int id);

    boolean insert(FilesDTO fdt);

    boolean update(FilesDTO fdt);

    boolean delete(int id);
}
