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

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentRESTcontroller {
    @Autowired
    StudentService studentService;

    @Autowired
    AccountService accountService;


}
