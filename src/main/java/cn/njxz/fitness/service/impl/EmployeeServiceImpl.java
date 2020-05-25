package cn.njxz.fitness.service.impl;

import cn.njxz.fitness.mapper.CourseMapper;
import cn.njxz.fitness.mapper.EmployeeMapper;
import cn.njxz.fitness.model.Course;
import cn.njxz.fitness.model.Employee;
import cn.njxz.fitness.service.IEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @author yue.wu
 * @Description
 * @date 2020/5/22 11:41
 */
@Service
@Transactional 
public class EmployeeServiceImpl implements IEmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    private CourseMapper courseMapper;

    @Override
    public int delete(int id) {

        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> findAllList = employeeMapper.selectAll();
        return findAllList;
    }

    @Override
    public Employee findById(int id) {

        Employee Employee = employeeMapper.selectByPrimaryKey(id);

        return Employee;
    }

    @Override
    public void add(Employee Employee) {

        employeeMapper.insert(Employee);
    }

    @Override
    public int update(Employee Employee) {
        return employeeMapper.updateByPrimaryKey(Employee);
    }

    @Override
    public List<Course> findEmployeeByName(Integer eId) {
        return courseMapper.selectCourseByEmployee(eId);
    }


    @Override
    public List<Employee> selectByName(Map params) {
        return employeeMapper.selectByName(params);
    }


    @Override
    public List<Employee> countselectByName(String username) {
        return employeeMapper.countselectByName(username);
    }


    @Override
    public int countEmployee() {
        return employeeMapper.countEmployee();
    }
}
