package io.codehooks.springbootquickguide.movie;

import io.codehooks.springbootquickguide.config.ResponseDto;
import io.codehooks.springbootquickguide.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService service;

    private static Logger logger = LoggerFactory.getLogger(MovieController.class);

    @GetMapping
    public ResponseDto getMovies(@RequestParam String filterBy) {
        logger.info("/movies is called with the request param {}", filterBy);

        List<Movie> movies = null;

        if (filterBy != null && !filterBy.isEmpty()) {
            movies = service.filterByName(filterBy);
        } else {
            movies = service.getMovies();
        }


        if(movies == null || movies.isEmpty()) {
            return ResponseDto.builder()
                    .success(Boolean.TRUE)
                    .data("Movies Not Found")
                    .build();
        }

        return ResponseDto.builder()
                .success(Boolean.TRUE)
                .data(movies)
                .build();
    }

    @GetMapping("/{name}")
    public ResponseDto getMovieByName(@PathVariable String name) {
        List<Movie> movies =  service.getMovieByName(name);

        if(movies == null || movies.isEmpty()) {
            return ResponseDto.builder()
                    .success(Boolean.TRUE)
                    .data("Movies Not Found")
                    .build();
        }

        return ResponseDto.builder()
                .success(Boolean.TRUE)
                .data(movies)
                .build();
    }

    @PostMapping
    public ResponseDto saveMovie(@Valid @RequestBody Movie movie) {
        Movie createdMovie = service.saveMovie(movie);

        if(createdMovie == null) {
            throw new ResourceNotFoundException("Resource Not Found");
        }

        return ResponseDto.builder().data(createdMovie).success(Boolean.TRUE).build();
    }

    @PostMapping(path = "/saveMany")
    public ResponseDto saveMovies(@RequestBody List<Movie> movies) {
        List<Movie> createdMovies = service.saveMovies(movies);

        if(createdMovies == null || createdMovies.isEmpty()) {
            return ResponseDto.builder()
                    .success(Boolean.TRUE)
                    .data("Movies are not saved")
                    .build();
        }

        return ResponseDto.builder()
                .success(Boolean.TRUE)
                .data(createdMovies)
                .build();
    }

//    @DeleteMapping
//    @PutMapping

}
