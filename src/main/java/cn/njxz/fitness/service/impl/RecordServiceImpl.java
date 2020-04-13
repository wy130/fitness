package cn.njxz.fitness.service.impl;

import cn.njxz.fitness.service.IRecordService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author yue.wu
 * @Description
 * @date 2020/4/13 18:30
 */
@Service
@Transactional //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class RecordServiceImpl implements IRecordService {

}
