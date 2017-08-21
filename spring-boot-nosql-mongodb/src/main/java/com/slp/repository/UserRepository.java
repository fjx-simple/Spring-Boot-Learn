package com.slp.repository;

import com.slp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sangliping on 2017/8/21.
 */
    public interface UserRepository extends MongoRepository<User,String> {

        User findByUsername(String username);
}
