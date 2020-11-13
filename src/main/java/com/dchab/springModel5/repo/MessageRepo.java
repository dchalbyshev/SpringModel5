package com.dchab.springModel5.repo;

import com.dchab.springModel5.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Integer> {
}
