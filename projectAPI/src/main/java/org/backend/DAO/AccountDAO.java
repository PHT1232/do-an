package org.backend.DAO;

import org.backend.entity.Account;
import org.backend.entity.Teacher;

import java.util.List;

public interface AccountDAO {
    List<Account> getAll();
    boolean insert(Account account);
    boolean insertAuthorities(String username, String authorities);
    boolean update(String id, Account account);
    boolean delete(String id);
    List<Teacher> getById(String name);
    Account getByUserName(String userName);
    List<String> getUserRoles (String username);
}
