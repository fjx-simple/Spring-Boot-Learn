package com.slp.repository;

import com.slp.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by sangliping on 2017/8/28.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{
    @Query("select t from Department t where t.name like :name")
    Page<Department> findByName(@Param("name") String name, Pageable pageable);
}
