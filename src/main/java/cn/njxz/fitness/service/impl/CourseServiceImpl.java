package cn.njxz.fitness.service.impl;

import cn.njxz.fitness.mapper.CourseMapper;
import cn.njxz.fitness.model.Admin;
import cn.njxz.fitness.model.Course;
import cn.njxz.fitness.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;
    @Override
    public List<Course> findAllCourse() {
        List<Course> courseList=courseMapper.findAllCourse();
        return  courseList;
    }

    @Override
    public List<Course> findCourseByKey(String cName) {
        return courseMapper.findCourseByKey(cName);
    }

    @Override
    public Course findCourseById(int id) {
        Course course=courseMapper.selectByPrimaryKey(id);
            return course;
    }

    @Override
    public int addCourse(Course course) {
        return courseMapper.insertSelective(course);
    }

    @Override
    public int deleteCourse(int cid) {
        return courseMapper.deleteByPrimaryKey(cid);
    }

    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public List<Course> findCourseByTrainFilter(Integer cClId, Integer cCoId, Integer cCtId) {
        return courseMapper.findCourseByTrainFilter(cClId,cCoId,cCtId);
    }
    @Override
    public List<Course> selectByName(Map params) {
        return courseMapper.selectByName(params);
    }

    @Override
    public List<Course> countselectByName(String username) {
        return courseMapper.countselectByName(username);
    }


    @Override
    public int countCourse() {
        return courseMapper.countCourse();
    }
    @Override
    public List<Course> findAll() {
        List<Course> findAllList = courseMapper.selectAll();
        return findAllList;
    }
}
