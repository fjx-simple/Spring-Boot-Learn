package com.slp;

import com.slp.entity.Department;
import com.slp.entity.Role;
import com.slp.entity.User;
import com.slp.repository.UserRedis;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by sangliping on 2017/8/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisConfig.class, UserRedis.class})
public class RedisTest {
    private static Logger logger = LoggerFactory.getLogger(RedisTest.class);
    @Autowired
    UserRedis userRedis;

    @Before
    public void setup(){
        Department department = new Department();
        department.setName("设计部");

        Role role = new Role();
        role.setName("admin");

        User user = new User();
        user.setName("slp");
        user.setCreatedate(new Date());
        user.setDeparment(department);

        List<Role> roles = new ArrayList<Role>();
        roles.add(role);

        user.setRoles(roles);
        userRedis.delete(this.getClass().getName()+":userByName:"+user.getName());
        userRedis.add(this.getClass().getName()+":userByName:"+user.getName(),10L,user);


    }
    @Test
    public void get(){
        User u = userRedis.get(this.getClass().getName()+":userByName:user");
    }
}
