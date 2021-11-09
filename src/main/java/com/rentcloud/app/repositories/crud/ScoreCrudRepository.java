package com.rentcloud.app.repositories.crud;

import com.rentcloud.app.entities.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<Score, Integer> {
}
