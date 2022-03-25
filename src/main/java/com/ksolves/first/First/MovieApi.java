package com.ksolves.first.First;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieApi {
    @Autowired
    private MovieService ms;
    @RequestMapping("/movie")
    List<Movie> getMovies(){
        return  ms.getMovies();
    }
    @RequestMapping("/movie/{id}")
    Movie getMovie(@PathVariable String id){
        return  ms.getMovieByID(id);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/movies")
    public void addMovie( @RequestBody Movie mv){
        ms.addMovie(mv);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/movies/{id}")
    public void updateMovie( @RequestBody Movie mv,@PathVariable String id){
        ms.updateMovie(id,mv);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/movies/{id}")
    public void deleteMovie(@PathVariable String id){
        ms.deleteMovie(id);
    }
}


