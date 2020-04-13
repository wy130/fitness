package cn.njxz.fitness.service.impl;

import cn.njxz.fitness.mapper.AdminMapper;
import cn.njxz.fitness.model.Admin;
import cn.njxz.fitness.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public int delete(int id) {

        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Admin> findAll() {
        List<Admin> findAllList = adminMapper.selectAll();
        return findAllList;
    }

    @Override
    public Admin findById(int id) {

        Admin admin = adminMapper.selectByPrimaryKey(id);

        return admin;
    }

    @Override
    public void add(Admin admin) {

        adminMapper.insert(admin);
    }

    @Override
    public int update(Admin admin) {
        return adminMapper.updateByPrimaryKey(admin);
    }

    @Override
    public Admin findAdminByName(String aName) {
        return adminMapper.findAdminByName(aName);
    }


    @Override
    public List<Admin> selectByName(Map params) {
        return adminMapper.selectByName(params);
    }


    @Override
    public List<Admin> countselectByName(String username) {
        return adminMapper.countselectByName(username);
    }


    @Override
    public int countAdmin() {
        return adminMapper.countAdmin();
    }

}
