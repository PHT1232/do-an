package org.backend.controllers;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.backend.models.TeacherDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import org.apache.http.impl.client.HttpClients;

@Controller
@RequestMapping(value = "/Teacher")
public class TeacherController {

    HttpSession session;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap map, HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("UTF-8");
        session = request.getSession(false);
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
            session.setAttribute("id", obj.getString("id"));
        }
//        String email = jsonObject.getString("username");
//        map.addAttribute("indexUrl", "index");
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
        map.addAttribute("url", "Teacher");
        map.addAttribute("updateContext", requestContext + "/updateTeacherProfile");
        map.addAttribute("username", username);
        map.addAttribute("lsDTO", lsdto);
        return "user_profile";
    }

//    @RequestMapping(value = "/Update", method = RequestMethod.POST)
//    public String update(ModelMap map, HttpServletRequest request, @RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("phone") String phone, @RequestParam("address") String address) throws IOException{
//        String id = (String) session.getAttribute("id");
//        String requestContext = request.getContextPath();
//        String requestServerName = request.getServerName();
//        int requestServerPort = request.getServerPort();
//        String s = "http://" + requestServerName + ":" + requestServerPort + requestContext + "/update";
//        HttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(s);
//        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
//        params.add(new BasicNameValuePair("name", name));
//        params.add(new BasicNameValuePair("id", id));
//        params.add(new BasicNameValuePair("address", address));
//        params.add(new BasicNameValuePair("sdt", phone));
//        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//        try (CloseableHttpClient httpCl = HttpClients.createDefault();
//             CloseableHttpResponse response = httpCl.execute(httpPost)) {
//
//            System.out.println(EntityUtils.toString(response.getEntity()));
//        }
//        return "login";
//    }

    @RequestMapping(value = "/addBaiTap", method = RequestMethod.GET)
    public String baiTap(HttpServletRequest request, ModelMap map, @RequestParam(value = "className", required = false) String className, @RequestParam(value = "classID", required = false) String classID) throws IOException {
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
//        map.addAttribute("className", className);
//        map.addAttribute("class", classID);
        map.addAttribute("username", username);
        return "add-baiTap";
    }
}
