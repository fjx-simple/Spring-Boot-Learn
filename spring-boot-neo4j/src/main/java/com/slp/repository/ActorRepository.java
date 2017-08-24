package com.slp.repository;

import com.slp.entity.Actor;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sangliping on 2017/8/23.
 */
@Repository
public interface ActorRepository  extends GraphRepository<Actor>{
}
