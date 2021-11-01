package org.backend.controllers;

import org.backend.models.TeacherDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping(value = "/Teacher")
public class TeacherController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap map, HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String requestContext = request.getContextPath();
        String requestServerName = request.getServerName();
        int requestServerPort = request.getServerPort();
        String s = "http://" + requestServerName + ":" + requestServerPort + requestContext + "/getTeacherById?username=" + username;
        URL url;
        Scanner sc;
        String str;
        url = new URL(s);

        sc = new Scanner(url.openStream(), "UTF-8");
        str = new String();
        while (sc.hasNext()) {
            str += sc.nextLine();
        }
        sc.close();
        JSONArray jsonArray = new JSONArray(str);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            map.addAttribute("name", obj.getString("name"));
        }
//        String email = jsonObject.getString("username");
        map.addAttribute("username", username);
        return "index";
    }

    @RequestMapping(value = "/Profile", method = RequestMethod.GET)
    public String profile(ModelMap map, HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String requestContext = request.getContextPath();
        String requestServerName = request.getServerName();
        int requestServerPort = request.getServerPort();
        String s = "http://" + requestServerName + ":" + requestServerPort + requestContext + "/getTeacherById?username=" + username;
        URL url;
        Scanner sc;
        String str;
        url = new URL(s);

        sc = new Scanner(url.openStream(), "UTF-8");
        str = new String();
        while (sc.hasNext()) {
            str += sc.nextLine();
        }
        sc.close();
        List<TeacherDTO> lsdto = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(str);
        for (int i = 0; i < jsonArray.length(); i++) {
            TeacherDTO tc = new TeacherDTO();
            JSONObject obj = jsonArray.getJSONObject(i);
            tc.setId(obj.getString("id"));
            tc.setName(obj.getString("name"));
            map.addAttribute("name", obj.getString("name"));
            tc.setAge(obj.getInt("age"));
            tc.setAddress(obj.getString("address"));
            tc.setSdt(obj.getString("sdt"));
            lsdto.add(tc);
        }
//        String email = jsonObject.getString("username");
        map.addAttribute("username", username);
        map.addAttribute("lsDTO", lsdto);
        return "user_profile";
    }
}
