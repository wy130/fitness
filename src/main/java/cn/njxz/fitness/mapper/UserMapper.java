package cn.njxz.fitness.mapper;

import cn.njxz.fitness.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper  {
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uId);

    List<User> selectAll();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findUserByName(User record);
    User findUserByPhone(User record);
    User findUserByEmail(User record);

    int userCount();

    //主页的user的查找
    List<User>  selectByName(Map params);
    List<User> countselectByName(@Param("username") String username);

}