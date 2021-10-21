package org.backend.service.impl;

import org.backend.DAO.AccountDAO;
import org.backend.entity.Account;
import org.backend.entity.Teacher;
import org.backend.models.AccountDTO;
import org.backend.models.TeacherDTO;
import org.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceIMPL implements AccountService {

    @Autowired
    AccountDAO accountDAO;

    @Override
    public List<AccountDTO> getAll() {
        List<AccountDTO> lsDTO = new ArrayList<>();
        List<Account> ls = accountDAO.getAll();
        for (Account ac : ls) {
            AccountDTO acDT = new AccountDTO();
            acDT.setId(ac.getId());
            acDT.setUserName(ac.getUserName());
            acDT.setPassword(ac.getPassword());
            acDT.setTeacherId(ac.getTeacherId());
            acDT.setStudentId(ac.getStudentId());
            acDT.setAuthority(ac.getAuthority());
            acDT.setEnabled(ac.isEnabled());
            lsDTO.add(acDT);
        }
        return lsDTO;
    }

    @Override
    public boolean insert(AccountDTO account) {
        Account ac = new Account();
        ac.setUserName(account.getUserName());
        ac.setPassword(account.getPassword());
        ac.setStudentId(account.getStudentId());
        ac.setTeacherId(account.getTeacherId());
        ac.setAuthority(account.getAuthority());
        ac.setEnabled(account.isEnabled());
        return accountDAO.insert(ac);
    }

    @Override
    public boolean insertAuthorities(String username, String authorities) {
        return accountDAO.insertAuthorities(username, authorities);
    }

    @Override
    public boolean update(String id, AccountDTO account) {
        Account ac = new Account();
        ac.setUserName(account.getUserName());
        ac.setPassword(account.getPassword());
        ac.setStudentId(account.getStudentId());
        ac.setTeacherId(account.getTeacherId());
        ac.setAuthority(account.getAuthority());
        return accountDAO.update(id, ac);
    }

    @Override
    public boolean delete(String id) {
        return accountDAO.delete(id);
    }

    @Override
    public List<TeacherDTO> getById(String id) {
        List<TeacherDTO> lsDTO = new ArrayList<>();
        List<Teacher> ls = accountDAO.getById(id);
        for (Teacher teacher : ls) {
            TeacherDTO teacherDTO = new TeacherDTO();
            teacherDTO.setId(teacher.getId());
            teacherDTO.setName(teacher.getName());
            teacherDTO.setAge(teacher.getAge());
            teacherDTO.setAddress(teacher.getAddress());
            teacherDTO.setPicture(teacher.getPicture());
            teacherDTO.setSdt(teacher.getSdt());
            lsDTO.add(teacherDTO);
        }
        return lsDTO;
    }

    @Override
    public AccountDTO getByUserName(String userName) {
        Account ac = accountDAO.getByUserName(userName);
        AccountDTO adto = new AccountDTO();
        adto.setUserName(ac.getUserName());
        adto.setPassword(ac.getPassword());
        adto.setStudentId(ac.getStudentId());
        adto.setTeacherId(ac.getTeacherId());
        return adto;
    }

    @Override
    public List<String> getUserRoles(String username) {
        return accountDAO.getUserRoles(username);
    }
}
