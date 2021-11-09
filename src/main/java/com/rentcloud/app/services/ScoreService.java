package com.rentcloud.app.services;

import com.rentcloud.app.entities.Score;
import com.rentcloud.app.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ScoreService {

    @Autowired
    private ScoreRepository repository;

    public List<Score> getAll(){
        return repository.getAll();
    }

    public Optional<Score> getScore(int id){
        return repository.getScore(id);
    }

    public Score save(Score score){
        if (score.getIdScore() == null){
            return repository.save(score);
        } else {
            Optional<Score> isScore = repository.getScore(score.getIdScore());
            if (isScore.isPresent()){
                return score;
            } else {
                return repository.save(score);
            }
        }
    }

    public Score update(Score score){
        if (score.getIdScore() != null){
            Optional<Score> isScore = getScore(score.getIdScore());
            if (isScore.isPresent()){
                if (score.getMessageText() != null){
                    isScore.get().setMessageText(score.getMessageText());
                }
                if (score.getStars() != null){
                    isScore.get().setStars(score.getStars());
                }
                if (score.getReservation() != null){
                    isScore.get().setReservation(score.getReservation());
                }
                return repository.save(isScore.get());
            } else {
                return score;
            }
        } else {
            return score;
        }
    }

    public boolean delete(int id){
        return getScore(id).map(score -> {
            repository.delete(score);
            return true;
        }).orElse(false);
    }
}
