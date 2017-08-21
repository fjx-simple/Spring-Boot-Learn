package com.slp;

import com.slp.config.TestDataSourceConfig;
import com.slp.entity.User;
import com.slp.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sangliping on 2017/8/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = (TestDataSourceConfig.class))
@FixMethodOrder
public class RepositoryTests {
    private static Logger logger = LoggerFactory.getLogger(RepositoryTests.class);

     @Autowired(required = false)
    UserRepository userRepository;

    @Before
    public  void setup(){
        Set<String> roles = new HashSet<>();
        roles.add("manage");
        User user = new User("1","user","122222","name","email@com.cn",new Date(),roles);
        userRepository.save(user);
    }
    @Test
    public void findAll(){
        List<User> users = userRepository.findAll();
        Assert.assertNotNull(users);
        for (User user:users){
            logger.info("====user====userid:{},username:{},pass:{},registeDate:{}",user.getUserId(),user.getName(),user.getPassword(),user.getRegisionDate());

        }
    }
}
