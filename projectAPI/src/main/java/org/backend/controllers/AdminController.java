package org.backend.controllers;

import org.backend.models.StudentDTO;
import org.backend.models.TeacherDTO;
import org.backend.service.StudentService;
import org.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public String index(ModelMap model) {
        List<TeacherDTO> list = teacherService.getAll();
//        for (TeacherDTO teacherDTO : list) {
//			System.out.println(teacherDTO.getAge());
//			System.out.println(teacherDTO.getName());
//			System.out.println(teacherDTO.getAddress());
//			System.out.println(teacherDTO.getPicture());
//			System.out.println(teacherDTO.getSdt());
//		}
        model.addAttribute("listTeacher", list);
        return "backend";
    }
    // Teacher

    @RequestMapping(value = "/admin/teachers", method = RequestMethod.GET)
    public String teachers(@RequestParam(value = "message", required = false) String message, ModelMap model) {
        List<TeacherDTO> list = teacherService.getAll();
        model.addAttribute("listTeacher", list);
        model.addAttribute("message", message);
        return "table_teacher";
    }

    @RequestMapping(value = "/admin/teachers/add", method = RequestMethod.GET)
    public String add_teachers(@RequestParam(value = "id", required = false) String id,ModelMap model) {
        String error = "Something Wrong!";
        if (id == null) {
            error = "Where is my id ?";
            model.addAttribute("message", error);
            return "redirect:/admin/teachers";
        }
        else {
            TeacherDTO teacher = new TeacherDTO();
            teacher.setId(id);
            model.addAttribute("teacherDTO", teacher);

        }
        model.addAttribute("message", error);
        return "table_teacher_add";
    }
    @RequestMapping(value = "/admin/teachers/update", method = RequestMethod.GET)
    public String update_teachers(ModelMap model) {

        model.addAttribute("teacherDTO", new TeacherDTO());
        return "table_teacher_update";
    }
    @RequestMapping(value = "/admin/teachers/add_action", method = RequestMethod.POST)
    public String add_action_teachers(@ModelAttribute("addTeacher") TeacherDTO teacherDTO, ModelMap model) {
        String error = "Something Wrong!";
        try {
            teacherService.insert(teacherDTO);
            error = "Add Success";
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        model.addAttribute("message", error);
        return "redirect:/admin/teachers";
//		return "table_teacher_add";
    }
    @RequestMapping(value = "/admin/teachers/update_action", method = RequestMethod.POST)
    public String update_action_teachers(@ModelAttribute("addTeacher") TeacherDTO teacherDTO, ModelMap model) {
        String error = "Something Wrong!";
        try {
            teacherService.insert(teacherDTO);
            error = "Add Success";
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        model.addAttribute("message", error);
        return "redirect:/admin/teachers";
//		return "table_teacher_add";
    }
    @RequestMapping(value = "/admin/teachers/delete", method = RequestMethod.GET)
    public String delete_action_teachers(@RequestParam(value = "id", required = false) String id, ModelMap model) {
        String error = "Something Wrong!";
        if (id == null) {
            error = "Where is my id ?";
        } else {

            try {
//				System.out.println(teacherDTO.getId());
//				System.out.println(teacherDTO.getAge());
//				System.out.println(teacherDTO.getName());
//				System.out.println(teacherDTO.getAddress());
//				System.out.println(teacherDTO.getPicture());
//				System.out.println(teacherDTO.getSdt());;
                List<TeacherDTO> listTeachers = teacherService.getById(id);
                if (!listTeachers.isEmpty()) {
                    for (TeacherDTO teacherDTO : listTeachers) {
                        teacherService.delete(teacherDTO.getId());
                    }
                    error = "Delete Success";
                } else {
                    error = "Delete Error";
                }

            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e);
            }
        }

        model.addAttribute("message", error);
        return "redirect:/admin/teachers";
//		return "table_teacher_add";
    }

    // end teacher
    @RequestMapping(value = "/admin/students", method = RequestMethod.GET)
    public String students(ModelMap model) {
        List<StudentDTO> list = studentService.getAll();
        model.addAttribute("listStudents", list);
        return "table_student";
    }
}
