package com.rentcloud.app.services;

import com.rentcloud.app.entities.Cloud;
import com.rentcloud.app.repositories.CloudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CloudService {

    @Autowired
    private CloudRepository repository;

    public List<Cloud> getAll(){
        return repository.getAll();
    }

    public Optional<Cloud> getCloud(int id){
        return repository.getCloud(id);
    }

    public Cloud save(Cloud cloud){
        if (cloud.getId() == null){
            return repository.save(cloud);
        } else {
            Optional<Cloud> isCloud = repository.getCloud(cloud.getId());
            if (isCloud.isPresent()){
                return cloud;
            } else {
                return repository.save(cloud);
            }
        }
    }

    public Cloud update(Cloud cloud){
        if (cloud.getId() != null){
            Optional<Cloud> isCloud = getCloud(cloud.getId());
            if (isCloud.isPresent()){
                if (cloud.getName() != null){
                    isCloud.get().setName(cloud.getName());
                }
                if (cloud.getBrand() != null){
                    isCloud.get().setBrand(cloud.getBrand());
                }
                if (cloud.getYear() != null){
                    isCloud.get().setYear(cloud.getYear());
                }
                if (cloud.getDescription() != null){
                    isCloud.get().setDescription(cloud.getDescription());
                }
                if (cloud.getCategory() != null){
                    isCloud.get().setCategory(cloud.getCategory());
                }
                if (cloud.getMessages() != null){
                    isCloud.get().setMessages(cloud.getMessages());
                }
                if (cloud.getReservations() != null){
                    isCloud.get().setReservations(cloud.getReservations());
                }
                return repository.save(isCloud.get());
            } else {
                return cloud;
            }
        } else {
            return cloud;
        }
    }

    public boolean delete(int id){
        return getCloud(id).map(cloud -> {
            repository.delete(cloud);
            return true;
        }).orElse(false);
    }
}
