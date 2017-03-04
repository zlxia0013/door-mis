package com.jack.doormis.core.authority.bo;


import com.jack.doormis.core.authority.CheckAuthorityResultEnum;
import com.jack.doormis.core.user.RoleEnum;
import com.jack.doormis.core.user.SuperUserName;
import com.jack.doormis.core.user.bo.UserBo;
import com.jack.doormis.core.user.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Jack on 2017/3/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core.xml")
public class AuthorityBoTest {

    @Autowired
    private AuthorityBo authorityBo;

    @Test
    public void testHello() {
        User userInfo = new User();

        CheckAuthorityResultEnum result = authorityBo.checkAuthority(null, "/goto_login_page");
        System.out.println(result);


        result = authorityBo.checkAuthority(null, "/client/goto_main_page");
        System.out.println(result);

        userInfo.setRole(RoleEnum.EMPL.toString());
        result = authorityBo.checkAuthority(userInfo, "/client/goto_main_page");
        System.out.println(result);

        userInfo.setRole(RoleEnum.EMPL.toString());
        result = authorityBo.checkAuthority(userInfo, "/client/add");
        System.out.println(result);

        userInfo.setUserName(SuperUserName.ADMIN);
        result = authorityBo.checkAuthority(userInfo, "/client/goto_main_page");
        System.out.println(result);
    }

}