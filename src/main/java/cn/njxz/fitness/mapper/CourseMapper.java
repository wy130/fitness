package cn.njxz.fitness.mapper;

import cn.njxz.fitness.model.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
}