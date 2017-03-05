package com.jack.doormis.core.authority.bo;

import com.jack.doormis.core.authority.CheckAuthorityResultEnum;
import com.jack.doormis.core.authority.dao.AuthorityDao;
import com.jack.doormis.core.authority.pojo.Authority;
import com.jack.doormis.core.user.RoleEnum;
import com.jack.doormis.core.user.bo.UserBo;
import com.jack.doormis.core.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;


@Service
public class AuthorityBo {
    @Autowired
    private AuthorityDao authorityDao;

    @Autowired
    private UserBo userBo;

    private Set<String> forAllAuthorities = new HashSet<String>();
    private Set<String> mustHasLoginAuthorities = new HashSet<String>();
    private Map<String, Set<String>> roleAuthorities = new HashMap<String, Set<String>>();

    public CheckAuthorityResultEnum checkAuthority(User userInfo, String url) {
        //无条件跳转
        if (forAllAuthorities.contains(url)) {
            if (mustHasLoginAuthorities.contains(url) && userInfo == null) {
                return CheckAuthorityResultEnum.NEED_LOGIN;
            } else {
                return CheckAuthorityResultEnum.RETURN_TRUE;
            }
        }

        //超级用户admin
        if (userInfo != null && userInfo.isSuperAdmin()) {
            return CheckAuthorityResultEnum.RETURN_TRUE;
        }

        if (userInfo != null) {
            if (roleAuthorities.get(userInfo.getRole()).contains(url)) {
                return CheckAuthorityResultEnum.RETURN_TRUE;
            } else {
                return CheckAuthorityResultEnum.NO_AUTHORITY;
            }
        } else {
            return CheckAuthorityResultEnum.NEED_LOGIN;
        }
    }


    //刷新缓存， 1分钟
    @Scheduled(initialDelay = 60000, fixedDelay = 60000)
    public void refreshAuthorityCache() {
        fillAuthorityCache();
    }


    @PostConstruct
    public void fillAuthorityCache() {
        synchronized (roleAuthorities) {
            //for all authorities
            List<Authority> forAllAuthoritiesLst = searchForAllAuthorities();
            for (Authority auth : forAllAuthoritiesLst) {
                forAllAuthorities.add(auth.getValue());

                if (auth.getMustHasLogin() == 1) {
                    mustHasLoginAuthorities.add(auth.getValue());
                }
            }

            //role authorities
            List<String> allRoles = userBo.searchAllRoles();
            for (String role : allRoles) {
                List<Authority> authorities = searchAuthoritiesOfRole(role);
                Set<String> authoritiesSet = new HashSet<String>();
                for (Authority auth : authorities) {
                    authoritiesSet.add(auth.getValue());
                }
                roleAuthorities.put(role, authoritiesSet);
            }
        }
    }

    public Authority getById(Integer id) {
        return authorityDao.getById(id);
    }

    public List<Authority> search(Authority authority) {
        return authorityDao.search(authority);
    }

    public List<Authority> searchForAllAuthorities() {
        return authorityDao.searchForAllAuthorities();
    }

    public List<Authority> searchAuthoritiesOfRole(String role) {
        return authorityDao.searchAuthoritiesOfRole(role);
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
