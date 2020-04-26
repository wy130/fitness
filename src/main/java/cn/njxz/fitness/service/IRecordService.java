package cn.njxz.fitness.service;

import cn.njxz.fitness.model.Course;
import cn.njxz.fitness.model.Record;

import java.util.List;
import java.util.Map;

/**
 * @author yue.wu
 * @Description
 * @date 2020/4/13 18:29
 */
public interface IRecordService {
    /**
     * 查询所有课程
     * @return
     */
    List<Record> findAllRecord();

    /**
     * 根据关键字模糊查询课程
     * @return
     */
     List<Record> findRecordByKey(String cName);

    Record findRecordById(int id);
    /**
     * 增加课程
     * @param record
     * @return
     */
     int addRecord(Record record);

    /**
     * 删除课程
     * @return
     */
     int deleteRecord(int rid);

     int updateRecord(Record record);


    List<Record> findAll();


    /**
     * 分页查询课程
     * @param params
     * @return
     */
    List<Record> selectByName(Map params);


    List<Record> countselectByName(String username);

    /**
     * 查询管理员的数量
     * @return
     */
    int countRecord();

    Record  findRecordByUidAndCid(Integer uid,Integer cid);

    List<Record> findRecordByUid(int uid);
}
