package com.slp.repository;

import com.slp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by sangliping on 2017/8/18.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
