package org.backend.controllers;

import org.backend.models.*;
import org.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.RequestPath;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;
    @Autowired
    ClassesService classesService;
    @Autowired
    SubjectsService subjectsService;
    @Autowired
    LearningService learningService;

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public String index(ModelMap model) {
        List<TeacherDTO> list = teacherService.getAll();
        List<StudentDTO> listStudent = studentService.getAll();

//        for (TeacherDTO teacherDTO : list) {
//			System.out.println(teacherDTO.getAge());
//			System.out.println(teacherDTO.getName());
//			System.out.println(teacherDTO.getAddress());
//			System.out.println(teacherDTO.getPicture());
//			System.out.println(teacherDTO.getSdt());
//		}
        model.addAttribute("listTeacher", list);
        model.addAttribute("listStudents", listStudent);
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
    public String add_teachers(ModelMap model) {

        model.addAttribute("teacherDTO", new TeacherDTO());
        return "table_teacher_add";
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
    @RequestMapping(value = "/admin/teachers/update", method = RequestMethod.GET)
    public String update_teachers(@ModelAttribute("addTeacher") TeacherDTO teacherDTO,
                                  @RequestParam(value = "id", required = false) String id,ModelMap model) {
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
        return "table_teacher_update";
    }
    @RequestMapping(value = "/admin/teachers/update_action/{id}", method = RequestMethod.POST)
    public String update_action_teachers(@PathVariable("id") String id,TeacherDTO teacherDTO, ModelMap model) {
        String error = "Something Wrong!";
        try {
            teacherService.update(id,teacherDTO);
            error = "Update Success";
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        model.addAttribute("message", error);
        return "redirect:/admin/teachers";
//		return "table_teacher_update";
    }
    @RequestMapping(value = "/admin/teachers/delete", method = RequestMethod.GET)
    public String delete_action_teachers(@RequestParam(value = "id", required = false) String id, ModelMap model) {
        String error = "Something Wrong!";
        if (id == null) {
            error = "Where is my id ?";
        } else {

            try {
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

    //student
    @RequestMapping(value = "/admin/students", method = RequestMethod.GET)
    public String students(@RequestParam(value = "message", required = false) String message, ModelMap model) {
        List<StudentDTO> list = studentService.getAll();
        model.addAttribute("message", message);
        model.addAttribute("listStudents", list);
        return "table_student";
    }
    @RequestMapping(value = "/admin/students/add", method = RequestMethod.GET)
    public String add_students(ModelMap model) {
        List<ClassesDTO> list = classesService.getAll();
        model.addAttribute("listClasses", list);
        model.addAttribute("studentDTO", new StudentDTO());
        return "students/add_student";
    }
    @RequestMapping(value = "/admin/students/add_action", method = RequestMethod.POST)
    public String add_action_students(@ModelAttribute("studentDTO") StudentDTO studentDTO, ModelMap model) {
        String error = "Something Wrong!";
        try {

            System.out.println(studentDTO.toString());
            studentService.insert(studentDTO);
            error = "Add Success";
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        model.addAttribute("message", error);
        return "redirect:/admin/students";
    }
    @RequestMapping(value = "/admin/students/update/{id}", method = RequestMethod.GET)
    public String update_students(
            @PathVariable("id") String id,ModelMap model) {
        List<ClassesDTO> list = classesService.getAll();

        String error = "Something Wrong!";
        if (id == null) {
            error = "Where is my id ?";
            model.addAttribute("message", error);
            return "redirect:/admin/students";
        }
        else {
            model.addAttribute("idStudent", id);
            model.addAttribute("updateStudents",new StudentDTO());
            model.addAttribute("listClasses", list);
        }
        model.addAttribute("message", error);
        return "students/update";
    }
    @RequestMapping(value = "/admin/students/update_action/{id}", method = RequestMethod.POST)
    public String update_action_students(@PathVariable("id") String id,
                                         @ModelAttribute("updateStudents") StudentDTO studentDTO,
                                         ModelMap model) {
        String error = "Something Wrong!";
        try {
            studentService.update(id,studentDTO);
            error = "Update Success";
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        model.addAttribute("message", error);
        return "redirect:/admin/students";
//		return "table_teacher_update";
    }
    @RequestMapping(value = "/admin/students/delete/{id}", method = RequestMethod.GET)
    public String delete_action_students(@PathVariable("id") String id, ModelMap model) {
        String error = "Something Wrong!";
        if (id == null) {
            error = "Where is my id ?";
        } else {

            try {
                studentService.delete(id);
                error = "Delete Success";
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e);
                error = "Delete Error. Check your data and do that again";
            }
        }
        model.addAttribute("message", error);
        return "redirect:/admin/students";
    }
    //end student

    //classes
    @RequestMapping(value = "/admin/classes", method = RequestMethod.GET)
    public String classes(@RequestParam(value = "message", required = false) String message, ModelMap model) {
        List<ClassesDTO> list = classesService.getAll();
        model.addAttribute("message", message);
        model.addAttribute("listClasses", list);
        return "classes/index";
    }
    @RequestMapping(value = "/admin/classes/add", method = RequestMethod.GET)
    public String add_classes(ModelMap model) {

        model.addAttribute("classesDTO", new TeacherDTO());
        return "classes/add";
    }
    @RequestMapping(value = "/admin/classes/add_action", method = RequestMethod.POST)
    public String add_action_classes(@ModelAttribute("addClasses") ClassesDTO classesDTO , ModelMap model) {
        String error = "Something Wrong!";
        try {
            classesService.insert(classesDTO);
            error = "Add Success";
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        model.addAttribute("message", error);
        return "redirect:/admin/classes";
//		return "table_teacher_add";
    }
    //end classes

    //subjects
    @RequestMapping(value = "/admin/subjects", method = RequestMethod.GET)
    public String subjects(@RequestParam(value = "message", required = false) String message, ModelMap model) {
        List<SubjectsDTO> list = subjectsService.getAll();
        model.addAttribute("message", message);
        model.addAttribute("listSubjects", list);
        return "subjects/index";
    }
    @RequestMapping(value = "/admin/subjects/add", method = RequestMethod.GET)
    public String add_subjects(ModelMap model) {
        List<ClassesDTO> list = classesService.getAll();
        model.addAttribute("listClasses", list);
        model.addAttribute("subjects", new SubjectsDTO());
        return "subjects/add";
    }
    @RequestMapping(value = "/admin/subjects/add_action", method = RequestMethod.POST)
    public String add_action_subjects(@ModelAttribute ("subjects")SubjectsDTO subjectsDTO, ModelMap model) {
        String error = "Something Wrong!";
        try {

//			System.out.println(subjectsDTO.getId());
//			System.out.println(subjectsDTO.getClassId());
            subjectsService.insert(subjectsDTO);
            error = "Add Success";
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        model.addAttribute("message", error);
        return "redirect:/admin/subjects";
//		return "table_teacher_add";
    }
    //end subjects

    //learning
    @RequestMapping(value = "/admin/learning", method = RequestMethod.GET)
    public String learning(@RequestParam(value = "message", required = false) String message, ModelMap model) {
        try {
            List<LearningDTO> list = learningService.getAll();
            model.addAttribute("message", message);
            model.addAttribute("listLearning", list);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

        return "learning/index";
    }
    @RequestMapping(value = "/admin/learning/add", method = RequestMethod.GET)
    public String add_learning(ModelMap model) {
        List<ClassesDTO> list = classesService.getAll();

        List<TeacherDTO> listTeacher = teacherService.getAll();
        List<SubjectsDTO> listSubjects = subjectsService.getAll();
        model.addAttribute("listClasses", list);
        model.addAttribute("listSubject", listSubjects);
        model.addAttribute("listTeacher", listTeacher);

        model.addAttribute("learning", new LearningDTO());
        return "learning/add";
    }
    @RequestMapping(value = "/admin/learning/add_action", method = RequestMethod.POST)
    public String add_action_learning(@ModelAttribute ("learning")LearningDTO learningDTO, ModelMap model) {
        String error = "Something Wrong!";
        try {
//				System.out.println(learningDTO.getId());
//				System.out.println(learningDTO.getClassId());
            learningService.insert(learningDTO);
            error = "Add Success";
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        model.addAttribute("message", error);
        return "redirect:/admin/learning";
//			return "table_teacher_add";
    }
    //end learning

    //user
    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String user(@RequestParam(value = "message", required = false) String message, ModelMap model) {
        try {
            List<AccountDTO> listUser = accountService.getAll();
            model.addAttribute("message", message);
            model.addAttribute("listUser", listUser);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

        return "user/index";
    }
    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String add_user(ModelMap model) {
        List<StudentDTO> listStudentDTO = studentService.getAll();
        List<TeacherDTO> listTeacher = teacherService.getAll();
        List<AccountDTO> listUser = accountService.getAll();
        List<String> listRoles = new ArrayList<>();
        listRoles.add("ADMIN");
        listRoles.add("TEACHER");
        listRoles.add("STUDENT");
        model.addAttribute("listUser", listUser);
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("listTeacher", listTeacher);
        model.addAttribute("listStudent", listStudentDTO);
        model.addAttribute("userDTO", new AccountDTO());
        return "user/add";
    }
    public String passwordEncoder(String password) {
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        return hash;
    }
    @RequestMapping(value = "/admin/users/add_action", method = RequestMethod.POST)
    public String add_action_user(@ModelAttribute ("userDTO")AccountDTO accountDTO, ModelMap model) {
        String error = "Something Wrong!";
        try {
//				System.out.println(learningDTO.getId());
//				System.out.println(learningDTO.getClassId());
            if (accountDTO.getTeacherId()== "") {
                accountDTO.setTeacherId(null);
            }
            if (accountDTO.getStudentId()== "") {
                accountDTO.setStudentId(null);
            }
            accountDTO.setPassword(passwordEncoder(accountDTO.getPassword()));
            accountService.insert(accountDTO);
            accountService.insertAuthorities(accountDTO.getUserName(),accountDTO.getAuthority());
            error = "Add Success";
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        model.addAttribute("message", error);
        return "redirect:/admin/users";
//			return "table_teacher_add";
    }
    //end user
}
