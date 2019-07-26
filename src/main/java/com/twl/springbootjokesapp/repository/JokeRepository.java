package com.twl.springbootjokesapp.repository;

import com.twl.springbootjokesapp.model.Joke;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JokeRepository extends MongoRepository<Joke, String> {

    boolean existsByTextIsLike(String text);

    List<Joke> findByTextIsLike(String text);
}
