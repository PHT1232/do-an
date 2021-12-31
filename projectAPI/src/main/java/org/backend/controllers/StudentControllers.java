package org.backend.controllers;

import org.backend.models.TeacherDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping("/Student")
public class StudentControllers {


//    @RequestMapping("/Profile")
//    public String profile(ModelMap map, HttpServletRequest request) throws IOException {
//        request.setCharacterEncoding("UTF-8");
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        map.addAttribute("username", username);
//        String s = "http://localhost:8080/projectAPI_war/getTeacher";
//        URL url = new URL(s);
//
//        Scanner sc = new Scanner(url.openStream(), "UTF-8");
//        String str = new String();
//        while (sc.hasNext()) {
//            str += sc.nextLine();
//        }
//        sc.close();
//        List<TeacherDTO> lsdto = new ArrayList<>();
//        JSONArray jsonArray = new JSONArray(str);
//        for (int i = 0; i < jsonArray.length(); i++) {
//            TeacherDTO tc = new TeacherDTO();
//            JSONObject obj = jsonArray.getJSONObject(i);
//            tc.setId(obj.getString("id"));
//            tc.setName(obj.getString("name"));
//            tc.setAge(obj.getInt("age"));
//            tc.setAddress(obj.getString("address"));
//            tc.setSdt(obj.getString("sdt"));
//            lsdto.add(tc);
//        }
//        for (TeacherDTO tc : ls) {
//            map.addAttribute("name", tc.getName());
//        }
//        map.addAttribute("lsDTO", lsdto);
//        return "teacher-index";
//    }

    @RequestMapping(value = "/baiTap", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String addBaiTap(ModelMap map, HttpServletRequest request) throws IOException, ParseException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = Integer.parseInt(request.getParameter("id"));
        String requestContext = request.getContextPath();
        String requestServerName = request.getServerName();
        int requestServerPort = request.getServerPort();
        String s = "http://" + requestServerName + ":" + requestServerPort + requestContext + "/getBaiTap?id=" + id;
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
        JSONObject obj = new JSONObject(str);
        final String new_format = "dd-MM-yyyy";
        final String old_format = "yyyy-MM-dd";
        String old_dateS = obj.getString("deadline");
        SimpleDateFormat sdf = new SimpleDateFormat(old_format);
        Date d = sdf.parse(old_dateS);
        sdf.applyPattern(new_format);
        String newStringDate = sdf.format(d);

        map.addAttribute("myFile", obj.getString("file"));
        map.addAttribute("tenBaiTap", obj.getString("tenBaiTap"));
        map.addAttribute("denHan", newStringDate);
        map.addAttribute("noiDungBaiTap", obj.getString("noiDungBaiTap"));
        map.addAttribute("id", id);
        map.addAttribute("username", username);
        return "BaiTapDisplay";
    }
}
