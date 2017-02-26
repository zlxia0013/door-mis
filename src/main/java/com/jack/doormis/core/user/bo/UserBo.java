package com.jack.doormis.core.user.bo;


import com.jack.doormis.core.user.dao.UserDao;
import com.jack.doormis.core.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserBo   {
	@Autowired
	private UserDao userDao;

	public User getById(Integer id){
		return userDao.getById(id);
	}

	public User getByLoginName(String loginName){
		return userDao.getByLoginName(loginName);
	}

	public List<User> search(User user){
		return userDao.search(user);
	}

	public List<User> searchPaged(User user){
		return userDao.searchPaged(user);
	}

	public Long searchCnt(User user){
		return userDao.searchCnt(user);
	}

	public void add(User user){
		userDao.add(user);
	}

	public void update(User user){
		userDao.update(user);
	}

	public void delete(User user){
		userDao.delete(user);
	}
}
