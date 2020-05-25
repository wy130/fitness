package cn.njxz.fitness.mapper;

import cn.njxz.fitness.model.Admin;
import cn.njxz.fitness.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    Employee findEmployeeByName(String username);

    List<Employee> selectByName(Map params);

    List<Employee> countselectByName(@Param("username") String username);

    int countEmployee();

    List<Employee> selectAll();


}