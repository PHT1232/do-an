package org.backend.inceptor;

import org.backend.models.AccountDTO;
import org.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class inceptor extends HandlerInterceptorAdapter {

    @Autowired
    AccountService accountService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null || password == null) {
            response.sendRedirect(  request.getContextPath() + "/stopAPI");
            return false;
        }
        if (username.equals("") || password.equals("")) {
            response.sendRedirect(request.getContextPath() +"/stopAPI");
            return false;
        }
        AccountDTO aDTO = accountService.getByUserName(username);
        if (aDTO == null) {
            response.sendRedirect( request.getContextPath() +"/stopAPI");
            return false;
        }
        boolean value = BCrypt.checkpw(password, aDTO.getPassword());
        if (!value) {
            response.sendRedirect( request.getContextPath() +"/stopAPI");
            return false;
        }
        List<String> ls = accountService.getUserRoles(username);
        for (String role : ls) {
            if (role.equals("ADMIN")) {
                return true;
            }
        }
        response.sendRedirect(request.getContextPath() + "/stopAPI");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
