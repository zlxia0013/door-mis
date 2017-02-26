package com.jack.doormis.core.user.dao;


import com.jack.doormis.core.user.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao  {
	public User getById(@Param("id") int id);

	public User getByLoginName(@Param("userName") String userName);

	public List<User> search(User user);

	public List<User> searchPaged(User user);

	public Long searchCnt(User user);

	public void add(User user);

	public void update(User user);

	public void delete(User user);
}
