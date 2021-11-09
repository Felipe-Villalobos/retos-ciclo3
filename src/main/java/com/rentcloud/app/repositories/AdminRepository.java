package com.rentcloud.app.repositories;

import com.rentcloud.app.entities.Admin;
import com.rentcloud.app.repositories.crud.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository crudRepository;

    public List<Admin> getAll(){
        return (List<Admin>) crudRepository.findAll();
    }

    public Optional<Admin> getAdmin(int id){
        return crudRepository.findById(id);
    }

    public Admin save(Admin admin){
        return crudRepository.save(admin);
    }

    public void delete(Admin admin){
        crudRepository.delete(admin);
    }
}
