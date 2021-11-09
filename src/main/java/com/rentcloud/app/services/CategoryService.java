package com.rentcloud.app.services;

import com.rentcloud.app.entities.Category;
import com.rentcloud.app.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> getAll(){
        return repository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return repository.getCategory(id);
    }

    public Category save(Category category){
        if (category.getId() == null){
            return repository.save(category);
        } else {
            Optional<Category> isCategory = repository.getCategory(category.getId());
            if (isCategory.isPresent()){
                return category;
            } else {
                return repository.save(category);
            }
        }
    }

    public Category update(Category category){
        if (category.getId() != null){
            Optional<Category> isCategory = repository.getCategory(category.getId());
            if (isCategory.isPresent()){
                if (category.getName() != null){
                    isCategory.get().setName(category.getName());
                }
                if (category.getDescription() != null){
                    isCategory.get().setDescription(category.getDescription());
                }
                if (category.getClouds() != null){
                    isCategory.get().setClouds(category.getClouds());
                }
                return repository.save(isCategory.get());
            } else {
                return category;
            }
        } else {
            return category;
        }
    }

    public boolean delete(int id){
        return getCategory(id).map(category -> {
            repository.delete(category);
            return true;
        }).orElse(false);
    }
}
