package com.twl.springbootjokesapp.service;

import com.twl.springbootjokesapp.model.Joke;

import java.util.List;

public interface JokeService {

    String getJoke();

    Joke httpGetJoke();

    Joke generateJokeAndSave();

    List<Joke> findByTextIsLike(String text);

    Joke save(String text);
}
