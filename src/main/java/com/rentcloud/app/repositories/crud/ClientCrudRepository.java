package com.rentcloud.app.repositories.crud;

import com.rentcloud.app.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, Integer> {
}
