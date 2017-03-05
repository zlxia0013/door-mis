package com.jack.doormis.core.user.bo;


import com.jack.doormis.core.user.RoleEnum;
import com.jack.doormis.core.user.UserStateEnum;
import com.jack.doormis.core.user.dao.UserDao;
import com.jack.doormis.core.user.pojo.User;
import com.jack.doormis.util.StringUtil;
import com.jack.doormis.util.exception.DoorMisRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class UserBo {
    @Autowired
    private UserDao userDao;

    public User getById(Integer id) {
        return userDao.getById(id);
    }

    public User getByUserName(String userName) {
        return userDao.getByUserName(userName);
    }

    public List<User> search(User user) {
        return userDao.search(user);
    }

    public List<User> searchPaged(User user) {
        return userDao.searchPaged(user);
    }

    public Long searchCnt(User user) {
        return userDao.searchCnt(user);
    }

    public void add(User user) {
        validate(user, true);
        userDao.add(user);
    }

    public void update(User user) {
        validate(user, false);
        userDao.update(user);
    }

    private void validate(User user, boolean isAdd) {
        if (user == null) {
            throw new DoorMisRuntimeException("用户实体不能为空");
        }

        if (StringUtil.isEmpty(user.getUserName())) {
            throw new DoorMisRuntimeException("用户名不能为空");
        } else if (user.getUserName().length() > 20) {
            throw new DoorMisRuntimeException("用户名不能大于20位");
        }

        if (StringUtil.isEmpty(user.getRealName())) {
            throw new DoorMisRuntimeException("姓名不能为空");
        } else if (user.getRealName().length() > 15) {
            throw new DoorMisRuntimeException("姓名不能大于15位");
        }

        if (StringUtil.isEmpty(user.getPwd())) {
            throw new DoorMisRuntimeException("密码不能为空");
        } else if (user.getPwd().length() > 20) {
            throw new DoorMisRuntimeException("密码不能大于20位");
        }

        if (!RoleEnum.isValid(user.getRole())) {
            throw new DoorMisRuntimeException("角色无效");
        }

        if (!UserStateEnum.isValid(user.getStateId())) {
            throw new DoorMisRuntimeException("状态无效");
        }

        if (!StringUtil.isEmpty(user.getRemark()) && user.getRemark().length() > 100) {
            throw new DoorMisRuntimeException("备注不能大于100位");
        }

        //////////////////
        if (isAdd) {
            User user1 = getByUserName(user.getUserName());
            if (user1 != null) {
                throw new DoorMisRuntimeException("用户名已存在，请重新输入");
            }
        } else {
            if (user.getId() == null) {
                throw new DoorMisRuntimeException("用户id不能为空");
            }
        }
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public User login(String userName, String password) {
        User user = getByUserName(userName);

        if (user == null) {
            throw new DoorMisRuntimeException("用户名不存在");
        }

        if (!user.getPwd().equals(password)) {
            throw new DoorMisRuntimeException("密码错误");
        }

        if (!UserStateEnum.enabled(user.getStateId())) {
            throw new DoorMisRuntimeException("您的帐户已被禁用");
        }

        //update last login time
        user.setLastLoginTime(new Date());
        update(user);

        return user;
    }

    public List<String> searchAllRoles(){
        return userDao.searchAllRoles();
    }
}
