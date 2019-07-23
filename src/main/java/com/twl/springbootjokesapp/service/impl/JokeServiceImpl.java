package com.twl.springbootjokesapp.service.impl;

import com.twl.springbootjokesapp.model.Joke;
import com.twl.springbootjokesapp.service.JokeService;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    public JokeServiceImpl() {
        this.chuckNorrisQuotes = new ChuckNorrisQuotes();
    }

    @Override
    public String getJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }

    @Override
    public Joke httpGetJoke() {
        return new Joke(chuckNorrisQuotes.getRandomQuote());
    }
}
