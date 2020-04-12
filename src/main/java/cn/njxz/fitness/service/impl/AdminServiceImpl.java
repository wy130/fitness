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

    public int delete(int id) {

        return adminMapper.deleteByPrimaryKey(id);
    }

    public List<Admin> findAll() {
        List<Admin> findAllList = adminMapper.selectAll();
        return findAllList;
    }

    public Admin findById(int id) {

        Admin admin = adminMapper.selectByPrimaryKey(id);

        return admin;
    }

    public void add(Admin admin) {

        adminMapper.insert(admin);
    }

    public int update(Admin admin) {

        return adminMapper.updateByPrimaryKey(admin);
    }

    /* 登陆验证 */
    public Admin login(String username, String password) {
        //根据用户名查找用户是否存在
        Admin admin = adminMapper.findAdminByName(username);
        if(admin != null && admin.getAPwd().equals(password)){
            System.out.println("用户存在");
            System.out.println(admin.getAName());
            return admin;
        }
        System.out.println(username);
        return null;
    }
    /*通过用户名查找用户*/
    @Override
    public List<Admin> selectByName(Map params) {
        return adminMapper.selectByName(params);
    }
    /*通过用户名查找admin的个数*/
    @Override
    public List<Admin> countselectByName(String username) {
        return adminMapper.countselectByName(username);
    }
    /*获得管理员的总个数*/
    @Override
    public int countAdmin() {
        return adminMapper.countAdmin();
    }

}
