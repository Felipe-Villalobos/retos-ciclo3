package com.rentcloud.app.services;

import com.rentcloud.app.entities.Admin;
import com.rentcloud.app.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;

    public List<Admin> getAll(){
        return repository.getAll();
    }

    public Optional<Admin> getAdmin(int id){
        return repository.getAdmin(id);
    }

    public Admin save(Admin admin){
        if (admin.getIdAdmin() == null){
            return repository.save(admin);
        } else {
            Optional<Admin> isAdmin = repository.getAdmin(admin.getIdAdmin());
            if (isAdmin.isPresent()){
                return admin;
            } else {
                return repository.save(admin);
            }
        }
    }

    public Admin update(Admin admin){
        if (admin.getIdAdmin() != null){
            Optional<Admin> isAdmin = repository.getAdmin(admin.getIdAdmin());
            if (isAdmin.isPresent()){
                if (admin.getEmail() != null){
                    isAdmin.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword() != null){
                    isAdmin.get().setPassword(admin.getPassword());
                }
                if (admin.getName() != null){
                    isAdmin.get().setName(admin.getName());
                }
                return repository.save(isAdmin.get());
            } else {
                return admin;
            }
        } else {
            return admin;
        }
    }

    public boolean delete(int id){
        return getAdmin(id).map(admin -> {
            repository.delete(admin);
            return true;
        }).orElse(false);
    }
}
