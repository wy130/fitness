package cn.njxz.fitness.service;

import cn.njxz.fitness.model.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {
    void add(Admin admin);
    int update(Admin admin);
    int delete(int id);
    Admin findById(int id);
    List<Admin> findAll();
    // 通过用户名及密码核查用户登录
    public Admin login(String username,String password);
    //通过用户名查找用户
    List<Admin>  selectByName(Map params);
    //通过用户名查找admin的个数
    List<Admin> countselectByName(String username);
    /*获得管理员的总个数*/
    int countAdmin();

}
