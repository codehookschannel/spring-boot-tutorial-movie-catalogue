package io.codehooks.springbootquickguide.movie;

import io.codehooks.springbootquickguide.config.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    Movie movie;

    @Autowired
    private MovieRepository repo;

    public List<Movie> getMovies() {
        return repo.findAll();
    }

    public Movie saveMovie(Movie movie) {
        return repo.save(movie);
    }

    public List<Movie> getMovieByName(String name) {
        return repo.findByName(name);
    }

    public List<Movie> filterByName(String name) {
        return repo.filterByName(name);
    }


    public List<Movie> saveMovies(List<Movie> movies) {
        List<Movie> newMovies = new ArrayList<>();
        movies.forEach(movie -> {
            newMovies.add(saveMovie(movie));
        });
        return newMovies;
    }
}
