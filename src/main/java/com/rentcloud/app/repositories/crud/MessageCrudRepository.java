package com.rentcloud.app.repositories.crud;

import com.rentcloud.app.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
