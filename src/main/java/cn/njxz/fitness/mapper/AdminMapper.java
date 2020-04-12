package cn.njxz.fitness.mapper;

import cn.njxz.fitness.model.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    /**
     * 此方法根据用户名来查找用户
     * 查询对应用户的信息
     */
    Admin findAdminByName(String username);
    //主页的admin的查找
    List<Admin> selectByName(Map params);
    List<Admin> countselectByName(@Param("username") String username);
    int countAdmin();
    List<Admin> selectAll();
}