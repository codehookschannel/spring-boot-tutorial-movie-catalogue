package io.codehooks.springbootquickguide.movie;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findByName(String name);

    @Query("{ 'name' : { $regex: ?0 }}")
    List<Movie> filterByName(String name);
}
