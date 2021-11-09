package com.rentcloud.app.repositories;

import com.rentcloud.app.entities.Message;
import com.rentcloud.app.repositories.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository crudRepository;

    public List<Message> getAll(){
        return (List<Message>) crudRepository.findAll();
    }

    public Optional<Message> getMessage(int id){
        return crudRepository.findById(id);
    }

    public Message save(Message message){
        return crudRepository.save(message);
    }

    public void delete(Message message){
        crudRepository.delete(message);
    }
}
