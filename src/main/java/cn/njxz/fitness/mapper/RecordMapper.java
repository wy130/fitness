package cn.njxz.fitness.mapper;

import cn.njxz.fitness.model.Course;
import cn.njxz.fitness.model.Record;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RecordMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
    List<Record> findAllRecord();

    List<Record> findRecordByKey(String cName);

    List<Record> selectByName(Map params);

    List<Record> countselectByName(@Param("username") String username);
    int countRecord();
    List<Record> selectAll();

    Record findRecordByUidAndCid(@Param("uid")Integer uid,@Param("cid")Integer cid);

    List<Record> findRecordByUid(int uid);
}