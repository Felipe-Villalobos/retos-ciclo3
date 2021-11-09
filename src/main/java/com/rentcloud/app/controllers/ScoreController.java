package com.rentcloud.app.controllers;

import com.rentcloud.app.entities.Score;
import com.rentcloud.app.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ScoreController {

    @Autowired
    private ScoreService service;

    @GetMapping("/all")
    public List<Score> getScores(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id")int id){
        return service.getScore(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score){
        return service.save(score);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score score){
        return service.update(score);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return service.delete(id);
    }
}
