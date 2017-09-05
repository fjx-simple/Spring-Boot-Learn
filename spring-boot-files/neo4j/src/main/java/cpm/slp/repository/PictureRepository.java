package cpm.slp.repository;

import cpm.slp.domain.Picture;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sangliping on 2017/9/4.
 */
@Repository
public interface PictureRepository extends GraphRepository<Picture> {
    Picture findByFileName(String fileName);
}
