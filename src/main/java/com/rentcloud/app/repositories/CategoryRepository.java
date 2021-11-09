package com.rentcloud.app.repositories;

import com.rentcloud.app.entities.Category;
import com.rentcloud.app.repositories.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository crudRepository;

    public List<Category> getAll(){
        return (List<Category>) crudRepository.findAll();
    }

    public Optional<Category> getCategory(int id){
        return crudRepository.findById(id);
    }

    public Category save(Category category){
        return crudRepository.save(category);
    }

    public void delete(Category category){
        crudRepository.delete(category);
    }
}
