package cn.njxz.fitness.service.impl;

import cn.njxz.fitness.mapper.CourseMapper;
import cn.njxz.fitness.model.Course;
import cn.njxz.fitness.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
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
    public boolean addCourse(Course course) {
        return false;
    }

    @Override
    public boolean deleteCourse(int cid) {
        return false;
    }

    @Override
    public boolean updateCourse(Course course) {
        return false;
    }

    @Override
    public List<Course> findCourseByTrainFilter(Integer cClId, Integer cCoId, Integer cCtId) {
        return courseMapper.findCourseByTrainFilter(cClId,cCoId,cCtId);
    }
}
