package com.rentcloud.app.controllers;

import com.rentcloud.app.entities.Admin;
import com.rentcloud.app.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/all")
    public List<Admin> getAdmins(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id")int id){
        return service.getAdmin(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin){
        return service.save(admin);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin){
        return service.update(admin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int adminId){
        return service.delete(adminId);
    }
}
