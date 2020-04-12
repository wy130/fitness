package cn.njxz.fitness.service;

import cn.njxz.fitness.model.Course;

import java.util.List;

public interface CourseService {
    /**
     * 查询所有课程
     * @return
     */
    public List<Course> findAllCourse();

    /**
     * 根据关键字模糊查询课程
     * @return
     */
    public List<Course> findCourseByKey();

    public Course findCourseById(int id);
    /**
     * 增加课程
     * @param course
     * @return
     */
    public boolean addCourse(Course course);

    /**
     * 删除课程
     * @return
     */
    public boolean deleteCourse(int cid);

    public boolean updateCourse(Course course);






 }
