package cn.njxz.fitness.mapper;

import cn.njxz.fitness.model.Admin;
import cn.njxz.fitness.model.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> findAllCourse();

    List<Course> findCourseByKey(String cName);

    List<Course> findCourseByTrainFilter(@Param("cClId") Integer cClId, @Param("cCoId") Integer cCoId, @Param("cCtId") Integer cCtId);

    List<Course> selectByName(Map params);

    List<Course> countselectByName(@Param("username") String username);

    int countCourse();

    List<Course> selectAll();

    List<Course> selectCourseByEmployee(@Param("eId") Integer eId);
}
