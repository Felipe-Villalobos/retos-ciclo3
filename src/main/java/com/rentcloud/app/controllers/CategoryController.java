package com.rentcloud.app.controllers;

import com.rentcloud.app.entities.Category;
import com.rentcloud.app.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/all")
    public List<Category> getCategories(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id")int id){
        return service.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return service.save(category);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
        return service.update(category);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoryId){
        return service.delete(categoryId);
    }
}
