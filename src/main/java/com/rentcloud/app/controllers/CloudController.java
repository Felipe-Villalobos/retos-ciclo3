package com.rentcloud.app.controllers;

import com.rentcloud.app.entities.Cloud;
import com.rentcloud.app.services.CloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("Cloud")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CloudController {

    @Autowired
    private CloudService service;

    @GetMapping("/all")
    public List<Cloud> getClouds(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cloud> getCloud(@PathVariable("id")int id){
        return service.getCloud(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud save(@RequestBody Cloud cloud){
        return service.save(cloud);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud update(@RequestBody Cloud cloud){
        return service.update(cloud);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return service.delete(id);
    }
}
