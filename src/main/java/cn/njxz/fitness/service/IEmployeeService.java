package cn.njxz.fitness.service;

import cn.njxz.fitness.model.Course;
import cn.njxz.fitness.model.Employee;

import java.util.List;
import java.util.Map;

/**
 * @author yue.wu
 * @Description
 * @date 2020/5/22 11:39
 */
public interface IEmployeeService {
    void add(Employee employee);

    int update(Employee employee);

    int delete(int id);

    Employee findById(int id);

    List<Employee> findAll();


    List<Course> findEmployeeByName(Integer eId);

    /**
     * 分页查询工作人员
     * @param params
     * @return
     */
    List<Employee> selectByName(Map params);


    List<Employee> countselectByName(String username);

    /**
     * 查询工作人员的数量
     * @return
     */
    int countEmployee();

}
