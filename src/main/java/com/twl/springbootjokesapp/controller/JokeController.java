package com.twl.springbootjokesapp.controller;

import com.twl.springbootjokesapp.model.Joke;
import com.twl.springbootjokesapp.service.JokeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @GetMapping("/get-joke")
    public ResponseEntity<Joke> getJoke() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(jokeService.httpGetJoke());
    }

    @PutMapping("/generate-joke")
    public ResponseEntity<Joke> generateJoke() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(jokeService.generateJokeAndSave());
    }

    @GetMapping("/find-by-text/{text}")
    public ResponseEntity<List<Joke>> findJokeByText(@PathVariable String text) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(jokeService.findByTextIsLike(text));
    }

//    @RequestMapping(path = "/save-joke", method = RequestMethod.POST) // Ambos funcionam
    @PostMapping("/save-joke")
    public ResponseEntity<Joke> saveJoke(@RequestHeader String text) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(jokeService.save(text));
    }
}
