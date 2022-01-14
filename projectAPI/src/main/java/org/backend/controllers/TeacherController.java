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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Controller
@RequestMapping(value = "/Teacher")
public class TeacherController {

    HttpSession session;

    public class baiTapNop {
        int id;
        String masv;
        String username;
        String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMasv() {
            return masv;
        }

        public void setMasv(String masv) {
            this.masv = masv;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class fileNop {
        int id;
        String username;
        String[] fileName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String[] getFileName() {
            return fileName;
        }

        public void setFileName(String[] fileName) {
            this.fileName = fileName;
        }
    }

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

    @RequestMapping(value = "/chamDiem")
    public String chamDiem(ModelMap map, HttpServletRequest request, @RequestParam(value = "id", required = false) int id) throws IOException {
        String requestContext = request.getContextPath();
        String requestServerName = request.getServerName();
        int requestServerPort = request.getServerPort();
        String s = "http://" + requestServerName + ":" + requestServerPort + requestContext + "/getBaiTapNop?id=" + id;
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
        List<String> username = new ArrayList<>();
        int[] idarr = new int[jsonArray.length()];
        List<fileNop> fileNops = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            fileNop fn = new fileNop();
            username.add(obj.getString("username"));
            idarr[i] = obj.getInt("id");
            fn.username = obj.getString("username");
            fn.id = obj.getInt("id");
            fileNops.add(fn);
        }
        for (int i = 0; i < idarr.length; i++) {
            String s1 = "http://" + requestServerName + ":" + requestServerPort + requestContext + "/getFileNop?id=" + idarr[i];
            url = new URL(s1);

            sc = new Scanner(url.openStream(), "UTF-8");
            str = new String();
            while (sc.hasNext()) {
                str += sc.nextLine();
            }
            sc.close();
            JSONArray jsonArray2 = new JSONArray(str);
            ListIterator<fileNop> lsi = fileNops.listIterator();
//            List<fileNop> list = new ArrayList<>();
            fileNop fnn = new fileNop();
            for (int i1 = 0; i1 < jsonArray2.length(); i1++) {
                JSONObject obj = jsonArray2.getJSONObject(i1);
//                System.out.println(jsonArray2.length());
//                while (lsi.hasNext()) {
                    fileNop fn = lsi.next();
                    System.out.println(fn.id);
                    System.out.println("hello");
                    if (fn.id == obj.getInt("nopBaiTapId")) {
                        fnn.fileName = new String[jsonArray2.length()];
                        fnn.id = fn.id;
//                        System.out.println(fnn.id);
                        fnn.username = fn.username;
                        fnn.fileName[i1] = obj.getString("filename");
//                        System.out.println(fnn.fileName[i1]);
                    }
//                }
            }
            lsi.set(fnn);
        }
        List<baiTapNop> btnl = new ArrayList<>();
        for (int i = 0; i < username.size(); i++) {
            String s2 = "http://" + requestServerName + ":" + requestServerPort + requestContext + "/findStudentByUsername?username=" + username.get(i);
            url = new URL(s2);

            sc = new Scanner(url.openStream(), "UTF-8");
            str = new String();
            while (sc.hasNext()) {
                str += sc.nextLine();
            }
            sc.close();
            JSONArray jsonArray1 = new JSONArray(str);
            for (int i1 = 0; i1 < jsonArray1.length(); i1++) {
                JSONObject obj = jsonArray1.getJSONObject(i);
                baiTapNop btn = new baiTapNop();
                btn.masv = obj.getString("id");
                btn.name = obj.getString("name");
                btn.username = username.get(i);
                btnl.add(btn);
            }
        }
//        for (int i = 0; i < 4; i++) {
//            System.out.println(fileNops.get(0).fileName[1]);
//            System.out.println(fileNops.get(0).fileName[0]);
//            System.out.println(fileNops.get(0).username);
//            System.out.println(btnl.get(0).name);
//            System.out.println(btnl.get(0).masv);
//        }
        map.addAttribute("filenop", fileNops);
        map.addAttribute("baitapnop", btnl);
        return "chamDiem";
    }
}
