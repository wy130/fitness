package cn.njxz.fitness.controller;

import cn.njxz.fitness.model.Course;
import cn.njxz.fitness.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findAllCourse")
    public String findAllCourse(Model model,@RequestParam(defaultValue="1")Integer pageNum) {
        PageHelper.startPage(pageNum, 2);

        List<Course> courseList = courseService.findAllCourse();
        if (courseList.isEmpty()) {
            return "templates/index";
        } else {
            PageInfo<Course> pageInfo = new PageInfo<>(courseList);
            model.addAttribute("pageInfo", pageInfo);
            return "templates/course";
        }
    }

    @RequestMapping("/findCourseById")
    public String findCourseById(Model model, int cid) {
        Course course = courseService.findCourseById(cid);
        if (course != null) {
            model.addAttribute("course", course);
            return "templates/courseshow";
        } else {
            return "templates/index";
        }
    }
   @RequestMapping("/findCourseByName")
   public String findCourseByName(Model model, HttpServletRequest request, @RequestParam(defaultValue="1")Integer pageNum){
       PageHelper.startPage(pageNum, 1);
       String cName = request.getParameter("cName");
       List<Course> courseList = courseService.findCourseByKey(cName);
       if (courseList.isEmpty()) {
           return "templates/index";
       } else {
           PageInfo<Course> pageInfo = new PageInfo<>(courseList);
           model.addAttribute("cName", cName);
           model.addAttribute("pageInfo", pageInfo);
           return "templates/querycourse";
       }
   }

    @GetMapping("/findCourseByTrainFilter")
    @ResponseBody
    public List<Course> findCourseByTrainFilter( Integer partvalue,
                                                Integer difficultyvalue,
                                                          Integer timevalue) {
        List<Course> courseList = courseService.findCourseByTrainFilter(difficultyvalue,partvalue,timevalue);

        if (courseList.isEmpty()) {
            return null;
        } else {
            return courseList;
        }
    }

    /**
     * 获取所有课程
     *
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/getAllCourse")
    public void getAllUser(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(required = false, defaultValue = "1") Integer page, //第几页
                           @RequestParam(required = false, defaultValue = "10") Integer rows //页数大小
    ) throws IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, Object> params = new HashMap<String, Object>(3);
        params.put("pageSize", rows);
        params.put("pageNum", (page - 1) * rows);
        params.put("username", "");
        List<Course> findAll = courseService.selectByName(params);
        int total = courseService.countCourse();
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
    //根据用户名查找课程
    @RequestMapping("/selectCourse")
    public void selectCourse(@RequestParam(required = false, defaultValue = "") String username, HttpServletRequest request,
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
        List<Course> alist = courseService.selectByName(params);
        int total = courseService.countselectByName(username).size();
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
    /*后台管理员列表增加*/
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "templates/course/courseinfo";
    }

    /**
     * 添加管理员
     *
     * @param
     * @param request
     * @return
     */
    @RequestMapping("/addCourse")
    public String addCourse(Course course, HttpServletRequest request) {
        if (course != null) {
            courseService.addCourse(course);
            return "templates/course/courselist"; //添加成功后转到course列表
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
    @RequestMapping("/toEditCourse")
    public String getCourse(String id, Model model, HttpServletRequest request) {
        int index = Integer.valueOf(id);
        System.out.println("进入编辑" + index);
        Course course = courseService.findCourseById(index);
        model.addAttribute("course", course);
        return "templates/course/editCourse";
    }

    /**
     * 更新用户
     */
    @RequestMapping("/updateCourse")
    public String updateCourse(Course course, HttpServletRequest request) {
        System.out.println("进入更新。。。。。");
        if (courseService.updateCourse(course) > 0) {
            return "templates/course/courselist";
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
    @RequestMapping("/delCourse")
    public String delCourse(String ids, HttpServletRequest request,
                           HttpServletResponse response) {
        if (ids.length() == 1) {
            System.out.println("-------" + ids);
            if (courseService.deleteCourse(Integer.parseInt(ids)) > 0) {
                return "templates/course/courselist";
            } else {
                System.out.println("删除失败");
                return null;
            }
        } else {
            System.out.println(ids.toString());
            String[] num = ids.split(",");
            for (int i = 0; i < num.length; i++) {
                courseService.deleteCourse(Integer.parseInt(num[i]));
            }
            return "templates/course/courselist";
        }
    }
}
