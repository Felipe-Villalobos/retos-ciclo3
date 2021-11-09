package com.rentcloud.app.repositories;

import com.rentcloud.app.entities.Cloud;
import com.rentcloud.app.repositories.crud.CloudCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class CloudRepository {

    @Autowired
    private CloudCrudRepository crudRepository;

    public List<Cloud> getAll(){
        return (List<Cloud>) crudRepository.findAll();
    }

    public Optional<Cloud> getCloud(int id){
        return crudRepository.findById(id);
    }

    public Cloud save(Cloud cloud){
        return crudRepository.save(cloud);
    }

    public void delete(Cloud cloud){
        crudRepository.delete(cloud);
    }
}
