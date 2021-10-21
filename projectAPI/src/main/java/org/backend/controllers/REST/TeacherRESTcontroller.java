package org.backend.controllers.REST;

import org.backend.models.TeacherDTO;
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
//@RequestMapping("/Teacher")
public class TeacherRESTcontroller {
    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/getTeacher", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String getTeacher() {
        List<TeacherDTO> list = teacherService.getAll();
        Gson gson = new Gson();
        if (!String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).equals("[ROLE_ANONYMOUS]")) {
            if (!String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).equals("[ROLE_ADMIN]")) {
                return "you do not have the permission to access this page";
            }
        }
        return gson.toJson(list);
    }

    @RequestMapping(value = "/add-teacher", method = RequestMethod.POST)
    public String addTeacher(@RequestParam(name = "id") String id, @RequestParam(name = "name") String name, @RequestParam(name = "age") int age, @RequestParam(name = "address") String address, @RequestParam(name = "sdt") String sdt) {
        TeacherDTO tdt = new TeacherDTO();
        tdt.setName(name);
        tdt.setId(id);
        tdt.setAddress(address);
        tdt.setAge(age);
        tdt.setSdt(sdt);
        try {
            teacherService.insert(tdt);
            return "success";
        } catch (Exception e) {

        }
        return "error";
    }

    @RequestMapping(value = "/update-teacher", method = RequestMethod.POST)
    public String updateTeacher(@RequestParam(name = "id") String id, @RequestParam(name = "name") String name, @RequestParam(name = "age") int age, @RequestParam(name = "address") String address, @RequestParam(name = "sdt") String sdt) {
        TeacherDTO tdt = new TeacherDTO();
        tdt.setName(name);
        tdt.setAddress(address);
        tdt.setAge(age);
        tdt.setSdt(sdt);
        try {
            teacherService.update(id, tdt);
            return "success";
        } catch (Exception e) {

        }
        return "error";
    }
}
