package com.jack.doormis.core.user.bo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Jack on 2017/3/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core.xml")
public class UserBoTest {

    @Autowired
    private UserBo userBo;

    @Test
    public void testHello() {
        userBo.login("admin", "aa");
    }
}