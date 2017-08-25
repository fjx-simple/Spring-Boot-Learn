package com.slp.repository;

import com.slp.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by sangliping on 2017/8/24.
 */
@Repository
public interface MovieRepository extends GraphRepository<Movie> {

    Movie findByName(@Param("name")String name);

    @Query("MATCH (m:Movie) WHERE m.name =~ ('(?i).*'+{name}+'.*') RETURN m")
    Page<Movie> findByName(@Param("name")String name, Pageable pageable);
}
