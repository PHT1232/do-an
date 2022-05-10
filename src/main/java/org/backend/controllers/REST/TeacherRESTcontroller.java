package org.backend.controllers.REST;

import org.backend.models.*;
import org.backend.service.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
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

    @Autowired
    FileService fileService;

    @Autowired
    chamDiemService cds;

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
    public RedirectView uploadBaiTap(@RequestParam(value = "monhocID") String monhocID, @RequestParam(value = "classID", required = false) String classId, @RequestParam(value = "deadline") String deadline, @RequestParam("files") MultipartFile[] files, @RequestParam(value = "tenBaiTap") String tenBaiTap, @RequestParam(value = "noiDungBaiTap") String noiDungBaiTap) throws IOException {
        baiTapDTO btd = new baiTapDTO();
        FilesDTO filesDTO = new FilesDTO();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        btd.setUsername(username);
        btd.setDeadline(deadline);
        btd.setTenBaiTap(tenBaiTap);
        btd.setNoiDungBaiTap(noiDungBaiTap);
        btd.setClassID(classId);
        btd.setMonhocID(monhocID);
//        String uploadDir = "C:\\Users\\KT\\IdeaProjects\\demo\\ProjectMangXaHoiSpringMvc\\uploads\\" + classId + "\\" + "baiTap" + "\\";

        baitapservice.insert(btd);

        String uploadDir = "D:\\do an\\do-an\\projectAPI\\uploads\\LT1902E\\baiTap";

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
//        List<String> filename = new ArrayList<>();
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
            filesDTO.setBaiTapId(baitapservice.getLastId());
            filesDTO.setNopBaiTapId(0);
            fileService.insert(filesDTO);
        }
        return new RedirectView("Teacher/addBaiTap?success=true");
    }

    @RequestMapping(value = "chamDiem", method = RequestMethod.POST)
    public RedirectView chamDiem(@RequestParam("id") int id, @RequestParam("Diem") int diem, @RequestParam("masv") String[] masv) {
//        List<String> masvl = new ArrayList<>();
        for (String msv : masv) {
            chamDiemDTO cdt = new chamDiemDTO();
            cdt.setBaiTapId(id);
            cdt.setDiem(diem);
            cdt.setStudentId(msv);
            cds.insert(cdt);
        }
        return new RedirectView("Teacher/chamDiem?id="+id+"&success=true");
    }
}
