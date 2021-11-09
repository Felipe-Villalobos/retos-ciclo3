package com.rentcloud.app.repositories;

import com.rentcloud.app.entities.Client;
import com.rentcloud.app.repositories.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository crudRepository;

    public List<Client> getAll(){
        return (List<Client>) crudRepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return crudRepository.findById(id);
    }

    public Client save(Client client){
        return crudRepository.save(client);
    }

    public void delete(Client client){
        crudRepository.delete(client);
    }
}
