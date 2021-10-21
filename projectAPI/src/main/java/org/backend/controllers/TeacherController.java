package org.backend.controllers;

import org.backend.entity.Teacher;
import org.backend.models.TeacherDTO;
import org.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/Teacher/index", method = RequestMethod.GET)
    public String index(ModelMap map) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<TeacherDTO> ls =  accountService.getById(username);
        map.addAttribute("username", username);
        for (TeacherDTO tc : ls) {
            map.addAttribute("name", tc.getName());
        }
        return "teacher-index";
    }
}
