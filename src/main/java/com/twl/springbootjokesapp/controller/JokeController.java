package com.twl.springbootjokesapp.controller;

import com.twl.springbootjokesapp.service.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private static final String CHUCKNORRIS_VIEW = "chucknorris";

    private JokeService jokeService;

    // Spring irá fazer o Autowire automaticamente, não sendo necessária a annotation
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String showJoke(Model model) {

        model.addAttribute("joke", jokeService.getJoke());

        return CHUCKNORRIS_VIEW;
    }
}
