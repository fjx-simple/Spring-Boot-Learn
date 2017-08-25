package com.slp;

/**
 * Created by sangliping on 2017/8/23.
 */

import com.google.gson.Gson;
import com.slp.entity.Movie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.net.URL;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootNeo4jApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieTest {
    private static Logger logger = LoggerFactory.getLogger(MovieTest.class);
/*
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ActorRepository actorRepository;

    @Before
    public void initData() {
        movieRepository.deleteAll();
        actorRepository.deleteAll();

        Movie matrix1 = new Movie();
        matrix1.setTitle("The Matrix");
        matrix1.setYear("1999-03-31");

        Movie matrix2 = new Movie();
        matrix2.setTitle("The Matrix Reloaded");
        matrix2.setYear("2003-05-07");

        Movie matrix3 = new Movie();
        matrix3.setTitle("The Matrix Revolutions");
        matrix3.setYear("2003-10-27");

        Actor keanu = new Actor();
        keanu.setName("Keanu Reeves");

        Actor laurence = new Actor();
        laurence.setName("Laurence Fishburne");

        Actor carrieanne = new Actor();
        carrieanne.setName("Carrie-Anne Moss");

        matrix1.addRole(keanu, "Neo");
        matrix1.addRole(laurence, "Morpheus");
        matrix1.addRole(carrieanne, "Trinity");
        movieRepository.save(matrix1);
        Assert.notNull(matrix1.getId());

        matrix2.addRole(keanu, "Neo");
        matrix2.addRole(laurence, "Morpheus");
        matrix2.addRole(carrieanne, "Trinity");
        movieRepository.save(matrix2);
        Assert.notNull(matrix2.getId());

        matrix3.addRole(keanu, "Neo");
        matrix3.addRole(laurence, "Morpheus");
        matrix3.addRole(carrieanne, "Trinity");
        movieRepository.save(matrix3);
        Assert.notNull(matrix3.getId());
    }

    @Test
    public void get() {
        Movie movie = movieRepository.findByTitle("The Matrix");
        Assert.notNull(movie);
        logger.info("===movie=== movie:{}, {}", movie.getTitle(), movie.getYear());
        for (Role role : movie.getRoles()) {
            logger.info("====== actor:{}, role:{}", role.getActor().getName(), role.getRole());
        }
    }*/


   /* @LocalServerPort
    private int port;*/

    private URL base;

    private Gson gson = new Gson();
    /**
     * TestRestTemplate is only auto-configured when @SpringBootTest has been configured with a webEnvironment that means it starts the web container and listens for HTTP requests
     */
    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + "8080" + "/");
    }

    @Test
    public void findByTaskName() {
        ResponseEntity<Movie> test = this.restTemplate.getForEntity(this.base.toString() + "/测试", Movie.class);
        System.out.println(gson.toJson(test.getBody())+"输出数据");
    }

    @Test
    public void saveTask() {
        Movie movie = new Movie();
        movie.setTitle("测试");
        movie.setYear("2017");
        movie.setId(1L);
        ResponseEntity<Movie> test = this.restTemplate.
                postForEntity(this.base.toString() + "/movie", movie,
                        Movie.class);
        System.out.println(gson.toJson(test.getBody())+"保存实体");
    }


}