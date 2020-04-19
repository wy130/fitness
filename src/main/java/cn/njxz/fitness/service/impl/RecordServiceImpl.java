package cn.njxz.fitness.service.impl;

import cn.njxz.fitness.mapper.RecordMapper;
import cn.njxz.fitness.model.Record;
import cn.njxz.fitness.service.IRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @author yue.wu
 * @Description
 * @date 2020/4/13 18:30
 */
@Service
@Transactional //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class RecordServiceImpl implements IRecordService {

    @Resource
    private RecordMapper recordMapper;
    @Override
    public List<Record> findAllRecord() {
        return recordMapper.findAllRecord();
    }

    @Override
    public List<Record> findRecordByKey(String cName) {
        return recordMapper.findRecordByKey(cName);
    }

    @Override
    public Record findRecordById(int id) {
        return recordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addRecord(Record record) {
        return recordMapper.insertSelective(record);
    }

    @Override
    public int deleteRecord(int rid) {
        return recordMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int updateRecord(Record record) {
        return recordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Record> findAll() {
        return recordMapper.selectAll();
    }

    @Override
    public List<Record> selectByName(Map params) {
        return recordMapper.selectByName(params);
    }

    @Override
    public List<Record> countselectByName(String username) {
        return recordMapper.countselectByName(username);
    }

    @Override
    public int countRecord() {
        return recordMapper.countRecord();
    }
}
