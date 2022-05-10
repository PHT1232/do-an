package org.backend.controllers.REST;

import org.backend.DAO.StudentBaiTapDAO;
import org.backend.models.FilesDTO;
import org.backend.models.StudentBaiTapDTO;
import org.backend.models.StudentDTO;
import org.backend.models.baiTapDTO;
import org.backend.service.AccountService;
import org.backend.service.FileService;
import org.backend.service.StudentService;
import com.google.gson.Gson;
import org.backend.service.baiTapService;
import org.backend.service.impl.StudentBaiTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/Api/Student")
public class StudentRESTcontroller {
    @Autowired
    StudentService studentService;

    @Autowired
    StudentBaiTapService studentBaiTapService;

    @Autowired
    AccountService accountService;

    @Autowired
    baiTapService baiTapService;

    @Autowired
    FileService fileService;

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

    @RequestMapping(value = "/findStudentByUsername", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String getStudentByUserName(@RequestParam(name = "username") String username) {
        List<StudentDTO> st = studentService.getByUsername(username);
        Gson gson = new Gson();
        return gson.toJson(st);
    }

    @RequestMapping(value = "/getBaiTap", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String getBaiTapStudent(@RequestParam(name = "id") int id) {
        baiTapDTO st = baiTapService.getById(id);
        List ls = new ArrayList();
        ls.add(st);
        for (FilesDTO fil : fileService.getListById(id)) {
            ls.add(fil);
        }
        Gson gson = new Gson();
        return gson.toJson(ls);
    }

    @RequestMapping(value = "/nopBaiTap", method = RequestMethod.POST)
    public RedirectView nopBaiTap(@RequestParam(name = "files", required = false) MultipartFile[] files, @RequestParam(name = "id") int id, @RequestParam(name = "link", required = false) String link) throws IOException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        System.out.println(files.length);
        StudentBaiTapDTO stbd = new StudentBaiTapDTO();
        FilesDTO filesDTO = new FilesDTO();
        stbd.setUsername(username);
        stbd.setLienKetName(link);
        stbd.setBaiTapId(id);
        studentBaiTapService.insertWithFile(stbd);
        String uploadDir = "D:\\do an\\do-an\\projectAPI\\uploads\\LT1902E\\baiTap\\hocsinh";

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        for (MultipartFile file : files) {
//            filename.add(file.getOriginalFilename());
            filesDTO.setFilename(file.getOriginalFilename());
            try (InputStream inputStream = file.getInputStream()) {
                Path filePath = uploadPath.resolve(file.getOriginalFilename());
                System.out.println(filePath.toFile().getAbsolutePath());
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
            filesDTO.setBaiTapId(0);
            filesDTO.setNopBaiTapId(studentBaiTapService.getLastId());
            fileService.insert(filesDTO);
        }

        return new RedirectView("Student/baiTap?id="+id);
    }

    @RequestMapping(value = "/getBaiTapNop")
    public String getBaiTapNop(@RequestParam("id") int id) {
        List<StudentBaiTapDTO> ls = studentBaiTapService.getByBaiTapId(id);
        Gson gson = new Gson();
        return gson.toJson(ls);
    }

    @RequestMapping(value = "/getFileNop")
    public String getFileNop(@RequestParam("id") int id) {
        Gson gson = new Gson();
        return gson.toJson(fileService.getListById(id));
    }


}
