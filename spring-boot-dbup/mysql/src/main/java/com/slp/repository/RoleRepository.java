package com.slp.repository;

import com.slp.dbexpand.jpa.repository.ExpandJpaRepository;
import com.slp.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by sangliping on 2017/9/1.
 */
@Repository
public interface RoleRepository extends ExpandJpaRepository<Role,Long> {
}
