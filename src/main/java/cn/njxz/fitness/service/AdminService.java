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

    /**
     * 根据aName 查询该管理员用户
     * @param aName
     * @return
     */
    Admin findAdminByName(String aName);

    /**
     * 分页查询管理员
     * @param params
     * @return
     */
    List<Admin> selectByName(Map params);


    List<Admin> countselectByName(String username);

    /**
     * 查询管理员的数量
     * @return
     */
    int countAdmin();

}
