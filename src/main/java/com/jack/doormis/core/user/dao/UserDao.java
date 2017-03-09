package com.jack.doormis.core.user.dao;


import com.jack.doormis.core.user.dto.UserMainPageParams;
import com.jack.doormis.core.user.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User getById(@Param("id") int id);

    User getByUserName(String userName);

    List<User> search(User user);

    List<User> searchPaged(User user);

    Long searchCnt(User user);

    void add(User user);

    void update(User user);

    void delete(Integer userId);

    List<String> searchAllRoles();

    List<User> searchMainList(UserMainPageParams pageParams);

    Integer searchMainCount(UserMainPageParams pageParams);
}
