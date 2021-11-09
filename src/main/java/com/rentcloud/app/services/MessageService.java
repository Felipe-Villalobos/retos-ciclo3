package com.rentcloud.app.services;

import com.rentcloud.app.entities.Message;
import com.rentcloud.app.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    public List<Message> getAll(){
        return repository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return repository.getMessage(id);
    }

    public Message save(Message message){
        if (message.getIdMessage() == null){
            return repository.save(message);
        } else {
            Optional<Message> isMessage = repository.getMessage(message.getIdMessage());
            if (isMessage.isPresent()){
                return message;
            } else {
                return repository.save(message);
            }
        }
    }

    public Message update(Message message){
        if (message.getIdMessage() != null){
            Optional<Message> isMessage = repository.getMessage(message.getIdMessage());
            if (isMessage.isPresent()){
                if (message.getMessageText() != null){
                    isMessage.get().setMessageText(message.getMessageText());
                }
                if (message.getCloud() != null){
                    isMessage.get().setCloud(message.getCloud());
                }
                if (message.getClient() != null){
                    isMessage.get().setClient(message.getClient());
                }
                return repository.save(isMessage.get());
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean delete(int id){
        return getMessage(id).map(message -> {
            repository.delete(message);
            return true;
        }).orElse(false);
    }
}
