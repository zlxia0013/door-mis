package com.jack.doormis.core.user.bo;


import com.jack.doormis.core.user.dao.UserDao;
import com.jack.doormis.core.user.pojo.User;
import com.jack.doormis.util.exception.DoorMisRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;


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

	public void login(String userName, String password) {
		User user = getByLoginName(userName);

		if (user == null){
			throw new DoorMisRuntimeException("用户名不存在");
		}

		if (!user.getPwd().equals(password)) {
			throw new DoorMisRuntimeException("密码错误");
		}
	}
}
