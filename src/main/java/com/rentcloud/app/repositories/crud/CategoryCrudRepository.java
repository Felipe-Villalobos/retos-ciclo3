package com.rentcloud.app.repositories.crud;

import com.rentcloud.app.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
}
