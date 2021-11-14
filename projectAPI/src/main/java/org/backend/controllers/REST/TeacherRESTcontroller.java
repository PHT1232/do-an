package org.backend.controllers.REST;

import org.backend.models.AccountDTO;
import org.backend.models.TeacherDTO;
import org.backend.models.baiTapDTO;
import org.backend.service.AccountService;
import org.backend.service.TeacherService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
//@RequestMapping("/Teacher")
public class TeacherRESTcontroller {
    @Autowired
    TeacherService teacherService;

    @Autowired
    AccountService accountService;

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

    @RequestMapping(value = "/getTeacherById", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String getTeacher(@RequestParam(name = "username") String username) {
        AccountDTO accountDTO = accountService.getByUserName(username);
        List<TeacherDTO> list = teacherService.getById(accountDTO.getTeacherId());
        Gson gson = new Gson();
//        if (!String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).equals("[ROLE_ANONYMOUS]")) {
//            if (!String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).equals("[ROLE_ADMIN]")) {
//                return "you do not have the permission to access this page";
//            }
//        }
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

    @RequestMapping(value = "/updateTeacherProfile", method = RequestMethod.POST)
    public RedirectView updateTeacher(@RequestParam(value = "username") String username, @RequestParam(name = "name") String name, @RequestParam(name = "age") int age, @RequestParam(name = "address") String address, @RequestParam(name = "phone") String sdt) {
        TeacherDTO tdt = new TeacherDTO();
        String id;
        AccountDTO accountDTO = accountService.getByUserName(username);
        id = accountDTO.getTeacherId();
        tdt.setName(name);
        tdt.setAddress(address);
        tdt.setAge(age);
        tdt.setSdt(sdt);
        try {
            teacherService.update(id, tdt);
            return new RedirectView("Teacher/Profile");
        } catch (Exception e) {

        }
        return new RedirectView("Teacher/Profile");
    }

    @RequestMapping(value = "/uploadBaiTap", method = RequestMethod.POST)
    public RedirectView uploadBaiTap(@RequestParam(value = "username") String username, @RequestParam(value = "classId", required = false) String classId, @RequestParam(value = "deadline") String deadline, @RequestParam("file") MultipartFile file, @RequestParam(value = "tenBaiTap") String tenBaiTap, @RequestParam(value = "noiDungBaiTap") String noiDungBaiTap) {
        baiTapDTO btd = new baiTapDTO();
        btd.setUsername(username);
        btd.setDeadline(deadline);
        btd.setTenBaiTap(tenBaiTap);
        btd.setNoiDungBaiTap(noiDungBaiTap);
        btd.setFile(file.getOriginalFilename());
        
        return new RedirectView("Teacher/addBaiTap");
    }
}
