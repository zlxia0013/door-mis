package com.jack.doormis.core.authority.bo;

import com.jack.doormis.core.authority.dao.AuthorityDao;
import com.jack.doormis.core.authority.pojo.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorityBo {
    @Autowired
    private AuthorityDao authorityDao;

    public Authority getById(Integer id) {
        return authorityDao.getById(id);
    }


    public List<Authority> search(Authority authority) {
        return authorityDao.search(authority);
    }

    public List<Authority> searchPaged(Authority authority) {
        return authorityDao.searchPaged(authority);
    }

    public Long searchCnt(Authority authority) {
        return authorityDao.searchCnt(authority);
    }

    public void add(Authority authority) {
        authorityDao.add(authority);
    }

    public void update(Authority authority) {
        authorityDao.update(authority);
    }

    public void delete(Authority authority) {
        authorityDao.delete(authority);
    }
}
