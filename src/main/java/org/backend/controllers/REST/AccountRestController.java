package org.backend.controllers.REST;

import com.google.gson.Gson;
import org.backend.models.AccountDTO;
import org.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/Account")
public class AccountRestController {
    @Autowired
    AccountService accountService;

    public String passwordEncoder(String password) {
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        return hash;
    }

    @RequestMapping(value = "/getAccount", method = RequestMethod.GET)
    public String getAccount() {
        List<AccountDTO> ls = accountService.getAll();
        Gson gson = new Gson();
        if (!String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).equals("[ROLE_ANONYMOUS]")) {
            if (!String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).equals("[ROLE_ADMIN]")) {
                return "you do not have the permission to access this page";
            }
        }
        return gson.toJson(ls);
    }

    @RequestMapping(value = "/getAccountByUsername", method = RequestMethod.GET)
    public String getAccountByUsername(@RequestParam(name = "username") String username) {
        AccountDTO ls = accountService.getByUserName(username);
        Gson gson = new Gson();
        if (!String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).equals("[ROLE_ANONYMOUS]")) {
            if (!String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).equals("[ROLE_ADMIN]")) {
                return "you do not have the permission to access this page";
            }
        }
        return gson.toJson(ls);
    }

//    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
//    public String signIn() {
//
//    }

    @RequestMapping(value = "/add-account", method = RequestMethod.POST)
    public String addAccount(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, @RequestParam(name = "teacherId", required = false) String teacherId, @RequestParam(name = "studentId", required = false) String studentId, @RequestParam(name = "authority") String authority) {
        AccountDTO aDTO = new AccountDTO();
        aDTO.setUserName(username);
        aDTO.setPassword(passwordEncoder(password));
        aDTO.setTeacherId(teacherId);
        aDTO.setStudentId(studentId);
        aDTO.setEnabled(true);
        try {
            accountService.insert(aDTO);
            accountService.insertAuthorities(username, authority);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping(value = "/delete-account", method = RequestMethod.POST)
    public String deleteAccount(@RequestParam(name = "id") String[] id) {
        try {
            for (String username : id) {
                accountService.delete(username);
            }
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping("/stopAPI")
    public String stopAPI() {
        String error = "You don't have permission on this site";
        return error;
    }


}
