package cn.njxz.fitness.mapper;

import cn.njxz.fitness.model.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer uiUId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer uiUId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}