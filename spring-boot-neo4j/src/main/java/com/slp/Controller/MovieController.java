package com.slp.Controller;

import com.slp.entity.Movie;
import com.slp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sangliping on 2017/8/25.
 */
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieRepository movieRepository;

    @RequestMapping(value = "", method = RequestMethod.POST,consumes = "application/json")
    @Transactional
    public Movie saveTask(@RequestBody Movie movieInfo){
        Movie movie = movieRepository.save(movieInfo);
        return movie;
    }
    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public Movie findByTitle(@PathVariable String title){
       // Movie movie = movieRepository.findByTitle(title);
        Movie movie = movieRepository.findOne(1L);
        return movie;
    }
}
