package com.twl.springbootjokesapp.service;

import com.twl.springbootjokesapp.model.Joke;

public interface JokeService {

    String getJoke();

    Joke httpGetJoke();
}
