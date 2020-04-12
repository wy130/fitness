package cn.njxz.fitness.mapper;

import cn.njxz.fitness.model.Course;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> findAllCourse();
}