package com.ksolves.first.First;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {
    private List<Movie> list1= new ArrayList<Movie>(Arrays.asList(
            new Movie("1", "Bahu", "THrill"),
        new Movie("2", "simba", "crime")
            ));

     void addMovie(Movie mv) {
        list1.add(mv);
    }

    public List<Movie> getMovies() {
        return  list1;
    }
    public Movie getMovieByID(String id) {
        return list1.stream().filter(movie -> movie.getId().equals(id)).findFirst().get();
    }


    public void updateMovie(String id, Movie mv) {
        for (int i = 0; i < list1.size(); i++) {
            Movie t = list1.get(i);
            if (t.getId().equals(id)) {
                list1.set(i, mv);
            }

        }
    }

    public void deleteMovie(String id) {
        list1.removeIf(t -> t.getId().equals(id));

    }
}
