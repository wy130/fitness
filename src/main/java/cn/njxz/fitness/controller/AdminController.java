package cn.njxz.fitness.controller;

import cn.njxz.fitness.model.Admin;
import cn.njxz.fitness.service.AdminService;

import io.lettuce.core.dynamic.annotation.Param;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 前往管理员登录页面
     * @param request
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request) {

        return "templates/admin/login";
    }

    /**
     * 验证后台用户是否存在。若成功登录则显示后台主页  admin/index.html。若失败，则访问error.html
     * @param aName
     * @param aPwd
     * @param request
     * @return
     */
    @RequestMapping(value = "/doLogin")
    public String doLogin(@Param("aName") String aName, @Param("aPwd") String aPwd, HttpServletRequest request) {

        Admin admin = adminService.findAdminByName(aName);
        if(admin != null && admin.getAPwd().equals(aPwd)){
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            session.setAttribute("username", aName);
            return "templates/admin/index";  /*后台主页展示*/
        } else {
            request.setAttribute("error", "用户名或密码错误");
            return "templates/error/error";
        }
    }

    //后台主页的home页
    @RequestMapping("/home")
    public String home() {
        return "templates/admin/home";
    }

    ///主页portal
    @RequestMapping("/page_portal_gonggao")
    public String page_portal_gonggao() {
        return "templates/portal/gonggao";
    }

    @RequestMapping("/page_portal_daiban")
    public String page_portal_daiban() {
        return "templates/portal/daiban";
    }

    @RequestMapping("/page_portal_yujing")
    public String page_portal_yujing() {
        return "templates/portal/yujing";
    }

    @RequestMapping("/page_portal_bug")
    public String page_portal_bug() {
        return "templates/portal/bug";
    }

    //后台管理员列表
    @RequestMapping("/toadminIndex")
    public String toAdminIndex() {
        return "templates/admin/adminindex";
    }

    @RequestMapping("/toalist")
    public String touserlist() {  //touserlist------------------------
        return "templates/admin/adminlist";
    }

    //根据用户名查找admin
    @RequestMapping("/selectAdmin")
    public void selectAdmin(@RequestParam(required = false, defaultValue = "") String username, HttpServletRequest request,
                            HttpServletResponse response, @RequestParam(required = false, defaultValue = "1") Integer page, //第几页
                            @RequestParam(required = false, defaultValue = "10") Integer rows) throws IOException {
        username = URLDecoder.decode(username, "utf-8");
        System.out.println("未格式化的" + username);
        request.setCharacterEncoding("utf-8");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pageSize", rows);
        params.put("pageNum", (page - 1) * rows);
        // if(username.substring(1,username.length()-1).length()==0||username.substring(1,username.length()-1).equals("")){
        params.put("username", null);
        // }else{
        params.put("username", username);
        // }
        List<Admin> alist = adminService.selectByName(params);
        int total = adminService.countselectByName(username).size();
        System.out.println("一共有多少数据" + total);
        JSONObject result = new JSONObject();
        String clist = JSONArray.fromObject(alist).toString();
        result.put("rows", clist);
        result.put("total", total);
        System.out.println(clist);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
    }

    /**
     * 获取所有管理员列表
     *
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/getAllAdmin")
    public void getAllUser(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(required = false, defaultValue = "1") Integer page, //第几页
                           @RequestParam(required = false, defaultValue = "10") Integer rows //页数大小
    ) throws IOException {
        System.out.println("进入查询");
        request.setCharacterEncoding("utf-8");
        Map<String, Object> params = new HashMap<String, Object>(3);
        params.put("pageSize", rows);
        params.put("pageNum", (page - 1) * rows);
        params.put("username", "");
        List<Admin> findAll = adminService.selectByName(params);
        int total = adminService.countAdmin();
        System.out.println("一共有多少数据" + total);
        JSONObject result = new JSONObject();
        String clist = JSONArray.fromObject(findAll).toString();
        result.put("rows", clist);
        result.put("total", total);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
    }

    /*后台管理员列表增加*/
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "templates/admin/admininfo";
    }

    /**
     * 添加管理员
     *
     * @param
     * @param request
     * @return
     */
    @RequestMapping("/addAdmin")
    public String addAdmin(Admin admin, HttpServletRequest request) {
        if (admin != null) {
            adminService.add(admin);
            return "templates/admin/adminlist"; //添加成功后转到admin列表
        } else {
            System.out.println("添加失败");
            return null;
        }
    }

    /**
     * 根据id查询编辑用户
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/toEditAdmin")
    public String getAdmin(String id, Model model, HttpServletRequest request) {
        int index = Integer.valueOf(id);
        System.out.println("进入编辑" + index);
        Admin ad = adminService.findById(index);
        System.out.println(ad.getAId() + ad.getAName());
        model.addAttribute("admin", ad);
        return "templates/admin/editAdmin";
    }

    /**
     * 更新用户
     */
    @RequestMapping("/updateAdmin")
    public String updateAdmin(Admin admin, HttpServletRequest request) {
        System.out.println("进入更新。。。。。");
        if (adminService.update(admin) > 0) {
            return "templates/admin/adminlist";
        } else {
            return null;
        }
    }

    /**
     * 删除用户
     *
     * @param ids
     * @param request
     * @param response
     */
    @RequestMapping("/delAdmin")
    public String delAdmin(String ids, HttpServletRequest request,
                           HttpServletResponse response) {
        /**/
        System.out.println("进入删除");
        if (ids.length() == 1) {
            System.out.println("-------" + ids);
            if (adminService.delete(Integer.parseInt(ids)) > 0) {
                return "templates/admin/adminlist";
            } else {
                System.out.println("删除失败");
                return null;
            }
        } else {
            System.out.println(ids.toString());
            String[] num = ids.split(",");
            for (int i = 0; i < num.length; i++) {
                adminService.delete(Integer.parseInt(num[i]));
            }
            return "templates/admin/adminlist";
        }
    }
}
