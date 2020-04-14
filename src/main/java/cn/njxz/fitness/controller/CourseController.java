package cn.njxz.fitness.controller;

import cn.njxz.fitness.model.Course;
import cn.njxz.fitness.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
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
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findAllCourse")
    public String findAllCourse(Model model,@RequestParam(defaultValue="1")Integer pageNum) {
        PageHelper.startPage(pageNum, 1);

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

}
