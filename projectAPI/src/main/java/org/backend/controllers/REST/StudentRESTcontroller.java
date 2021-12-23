package org.backend.controllers.REST;

import org.backend.models.AccountDTO;
import org.backend.models.StudentDTO;
import org.backend.service.AccountService;
import org.backend.service.StudentService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
//@RequestMapping("/Api/Student")
public class StudentRESTcontroller {
    @Autowired
    StudentService studentService;

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/admin/getStudent", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String getStudent(HttpServletRequest request) {
        List<StudentDTO> list = studentService.getAll();
        Gson gson = new Gson();
        if (!String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).equals("[ROLE_ANONYMOUS]")) {
            if (!String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).equals("[ROLE_ADMIN]")) {
                return "you do not have the permission to access this page";
            }
        }
        return gson.toJson(list);
    }

    @RequestMapping(value = "/add-student", method = RequestMethod.POST)
    public String addStudent(@RequestParam(name = "id") String id, @RequestParam(name = "name") String name, @RequestParam(name = "age") int age, @RequestParam(name = "address") String address, @RequestParam(name = "sdt") String sdt) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(name);
        studentDTO.setId(id);
        studentDTO.setAddress(address);
        studentDTO.setAge(age);
        studentDTO.setSdt(sdt);
        try {
            studentService.insert(studentDTO);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping(value = "/update-student", method = RequestMethod.POST)
    public String updateStudent(@RequestParam(name = "id") String id, @RequestParam(name = "name") String name, @RequestParam(name = "age") int age, @RequestParam(name = "address") String address, @RequestParam(name = "sdt") String sdt) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(name);
        studentDTO.setAddress(address);
        studentDTO.setSdt(sdt);
        studentDTO.setAge(age);
        try {
            studentService.update(id, studentDTO);
            return "success";
        } catch (Exception e) {

        }
        return "error";
    }

    @RequestMapping(value = "/delete-student", method = RequestMethod.POST)
    public String deleteStudent(@RequestParam(name = "id") String id) {
        try {
            studentService.delete(id);
            return "success";
        } catch (Exception e) {

        }
        return "error";
    }

    @RequestMapping(value = "/findStudent", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String getStudentByID(@RequestParam(name = "id") String id) {
        List<StudentDTO> st = studentService.getById(id);
        Gson gson = new Gson();
        return gson.toJson(st);
    }



    @RequestMapping(value = "/nopBaiTap", method = RequestMethod.POST)
    public RedirectView nopBaiTap() {

        return new RedirectView("Student/baiTap");
    }
}
