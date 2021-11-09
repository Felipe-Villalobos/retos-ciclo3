package com.rentcloud.app.controllers;

import com.rentcloud.app.entities.Client;
import com.rentcloud.app.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/all")
    public List<Client> getClients(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id")int id){
        return service.getClient(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return service.save(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client){
        return service.update(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return service.delete(id);
    }
}
