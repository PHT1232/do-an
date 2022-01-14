package org.backend.controllers.REST;

import org.backend.models.AccountDTO;
import org.backend.models.TeacherDTO;
import org.backend.models.baiTapDTO;
import org.backend.service.AccountService;
import org.backend.service.TeacherService;
import com.google.gson.Gson;
import org.backend.service.baiTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
//@RequestMapping("/Teacher")
public class TeacherRESTcontroller {
    @Autowired
    TeacherService teacherService;

    @Autowired
    AccountService accountService;

    @Autowired
    baiTapService baitapservice;

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
    public RedirectView uploadBaiTap(@RequestParam(value = "classId", required = false) String classId, @RequestParam(value = "deadline") String deadline, @RequestParam("file") MultipartFile file, @RequestParam(value = "tenBaiTap") String tenBaiTap, @RequestParam(value = "noiDungBaiTap") String noiDungBaiTap) throws IOException {
        baiTapDTO btd = new baiTapDTO();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        btd.setUsername(username);
        btd.setDeadline(deadline);
        btd.setTenBaiTap(tenBaiTap);
        btd.setNoiDungBaiTap(noiDungBaiTap);
        btd.setFile(file.getOriginalFilename());
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        String uploadDir = "C:\\Users\\KT\\IdeaProjects\\demo\\ProjectMangXaHoiSpringMvc\\uploads\\" + classId + "\\" + "baiTap" + "\\";
        String uploadDir = "D:\\do an\\do-an\\projectAPI\\uploads\\LT1902E\\baiTap";

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            System.out.println(filePath.toFile().getAbsolutePath());
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        baitapservice.insert(btd);
        return new RedirectView("Teacher/addBaiTap");
    }
}
