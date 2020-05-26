package cn.njxz.fitness.controller;

import cn.njxz.fitness.model.Course;
import cn.njxz.fitness.model.Employee;
import cn.njxz.fitness.service.CourseService;
import cn.njxz.fitness.service.IEmployeeService;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author yue.wu
 * @Description
 * @date 2020/5/23 4:25
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private CourseService courseService;
    @RequestMapping(value = "/doLogin")
    public String doLogin(@Param("eId") Integer eId, @Param("ePwd") String ePwd, HttpServletRequest request) {

        Employee employee = employeeService.findById(eId);
        if(employee != null && employee.getEPwd().equals(ePwd)){
            HttpSession session = request.getSession();
            session.setAttribute("employee", employee);
            List<Course> courseList = employeeService.findEmployeeByName(eId);
            request.setAttribute("courseList",courseList);
            return "templates/employee/job";
        } else {
            request.setAttribute("error", "用户名或密码错误");
            return "templates/error/error";
        }
    }
}
