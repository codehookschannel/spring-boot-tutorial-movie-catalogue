package io.codehooks.springbootquickguide.config;

import io.codehooks.springbootquickguide.movie.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public Movie movie() {
        return Movie.builder().name("Mirage")
                .type("Movie")
                .rating(8.9)
                .build();
    }
}
