package com.slp.repository;

import com.slp.entity.Movie;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by sangliping on 2017/8/23.
 */
@Repository
public interface MovieRepository extends GraphRepository<Movie> {
    Movie findByTitle(@Param("title")String title);
}
