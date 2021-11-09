package com.rentcloud.app.services;

import com.rentcloud.app.entities.Client;
import com.rentcloud.app.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> getAll(){
        return repository.getAll();
    }

    public Optional<Client> getClient(int id){
        return repository.getClient(id);
    }

    public Client save(Client client){
        if (client.getIdClient() == null){
            return repository.save(client);
        } else {
            Optional<Client> isClient = repository.getClient(client.getIdClient());
            if (isClient.isPresent()){
                return client;
            } else {
                return repository.save(client);
            }
        }
    }

    public Client update(Client client){
        if (client.getIdClient() != null){
            Optional<Client> isClient = repository.getClient(client.getIdClient());
            if (isClient.isPresent()){
                if (client.getEmail() != null){
                    isClient.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null){
                    isClient.get().setPassword(client.getPassword());
                }
                if (client.getName() != null){
                    isClient.get().setName(client.getName());
                }
                if (client.getAge() != null){
                    isClient.get().setAge(client.getAge());
                }
                if (client.getMessages() != null){
                    isClient.get().setMessages(client.getMessages());
                }
                if (client.getReservations() != null){
                    isClient.get().setReservations(client.getReservations());
                }
                return repository.save(isClient.get());
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean delete(int id){
        return getClient(id).map(client -> {
            repository.delete(client);
            return true;
        }).orElse(false);
    }
}
