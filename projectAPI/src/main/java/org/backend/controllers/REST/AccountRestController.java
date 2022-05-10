package org.backend.controllers.REST;

import com.google.gson.Gson;
import org.backend.models.AccountDTO;
import org.backend.models.StudentDTO;
import org.backend.models.TeacherDTO;
import org.backend.service.AccountService;
import org.backend.service.StudentService;
import org.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
//@RequestMapping("/admin")
public class AccountRestController {
    @Autowired
    AccountService accountService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;


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

    @RequestMapping(value = "getStudent", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String getStudent(HttpServletRequest request) {
        String role = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        if (role.equals("[ROLE_ANONYMOUS]")) {
            if (!role.equals("[ROLE_ADMIN]")) {
                return "you do not have the permission to access this page";
            }
        }
        List<StudentDTO> list = studentService.getAll();
        Gson gson = new Gson();
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

    @RequestMapping(value = "/getTeacher", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String getTeacher() {
        String role = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        System.out.println(role);
        if (role.equals("[ROLE_ANONYMOUS]")) {
            if (!role.equals("[ROLE_ADMIN]")) {
                return "you do not have the permission to access this page";
            }
        }
        List<TeacherDTO> list = teacherService.getAll();
        Gson gson = new Gson();
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

    @RequestMapping(value = "/update-teacher", method = RequestMethod.POST)
    public String updateTeacher(@RequestParam(value = "username") String username, @RequestParam(name = "name") String name, @RequestParam(name = "age") int age, @RequestParam(name = "address") String address, @RequestParam(name = "sdt") String sdt) {
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
            return "success";
        } catch (Exception e) {

        }
        return "error";
    }

}
