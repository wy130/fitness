package cn.njxz.fitness.controller;

import cn.njxz.fitness.model.Course;
import cn.njxz.fitness.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findAllCourseByPage")
    public String findAllCourse(Model model) {
        List<Course> courseList = courseService.findAllCourse();
        if (courseList.isEmpty()) {
            return "templates/index";
        } else {

            model.addAttribute("courses", courseList);
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


}
