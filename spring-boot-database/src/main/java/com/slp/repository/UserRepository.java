package com.slp.repository;

import com.slp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by sangliping on 2017/8/18.
 * @Repository将该接口定义为一个资源库，使它能被其他程序引用，为其他程序提供存储数据的功能
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
