package org.backend.controllers.REST;

import org.backend.models.AccountDTO;
import org.backend.models.TeacherDTO;
import org.backend.service.AccountService;
import org.backend.service.TeacherService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherRESTcontroller {
    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/get_info", method = RequestMethod.GET)
    public String getUserInfo() {
        String username = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());
        TeacherDTO ls = teacherService.getByUser(username);
        Gson gson = new Gson();
        System.out.println(gson.toJson(ls));
        if (!String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).equals("[ROLE_ANONYMOUS]")) {
            if (!String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).equals("[ROLE_TEACHER]")) {
                return "you do not have the permission to access this page";
            }
        }
        return gson.toJson(ls);
    }

}
