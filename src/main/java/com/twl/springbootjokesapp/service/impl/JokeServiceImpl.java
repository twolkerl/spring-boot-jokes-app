package com.twl.springbootjokesapp.service.impl;

import com.twl.springbootjokesapp.model.Joke;
import com.twl.springbootjokesapp.repository.JokeRepository;
import com.twl.springbootjokesapp.service.JokeService;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;
    private final JokeRepository jokeRepository;

    public JokeServiceImpl(JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
        this.chuckNorrisQuotes = new ChuckNorrisQuotes();
    }

    @Override
    public String getJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }

    @Override
    public Joke httpGetJoke() {
        return Joke.builder()
                .text(chuckNorrisQuotes.getRandomQuote())
                .build();
    }

    @Override
    public Joke generateJokeAndSave() {

        return jokeRepository.save(
                Joke.builder()
                        .text(chuckNorrisQuotes.getRandomQuote())
                        .build()
        );
    }

    @Override
    public List<Joke> findByTextIsLike(String text) {

        return StringUtils.isNotBlank(text) ? jokeRepository.findByTextIsLike(text) : new ArrayList<>();
    }

    @Override
    public Joke save(String text) {

        return StringUtils.isNotBlank(text) ? jokeRepository.save(Joke.builder().text(text).build()) : null;
    }
}
