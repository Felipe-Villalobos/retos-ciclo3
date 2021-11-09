package com.rentcloud.app.repositories;

import com.rentcloud.app.entities.Score;
import com.rentcloud.app.repositories.crud.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository crudRepository;

    public List<Score> getAll(){
        return (List<Score>) crudRepository.findAll();
    }

    public Optional<Score> getScore(int id){
        return crudRepository.findById(id);
    }

    public Score save(Score score){
        return crudRepository.save(score);
    }

    public void delete(Score score){
        crudRepository.delete(score);
    }
}
