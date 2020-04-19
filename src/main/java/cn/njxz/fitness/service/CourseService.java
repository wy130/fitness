package cn.njxz.fitness.service;

import cn.njxz.fitness.model.Admin;
import cn.njxz.fitness.model.Course;

import java.util.List;
import java.util.Map;

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
    public List<Course> findCourseByKey(String cName);

    public Course findCourseById(int id);
    /**
     * 增加课程
     * @param course
     * @return
     */
    public int addCourse(Course course);

    /**
     * 删除课程
     * @return
     */
    public int deleteCourse(int cid);

    public int updateCourse(Course course);

    List<Course> findCourseByTrainFilter(Integer cClId,Integer cCoId,Integer cCtId);

    List<Course> findAll();


    /**
     * 分页查询课程
     * @param params
     * @return
     */
    List<Course> selectByName(Map params);


    List<Course> countselectByName(String username);

    /**
     * 查询管理员的数量
     * @return
     */
    int countCourse();




 }
