package com.dchab.springModel5.repo;

import com.dchab.springModel5.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Integer> {
    List<Message> findByTag(String tag);
    // как сформировали данный метод
    // 1 указали ключевое слово find
    // 2 указали кл. слово By -  переходим к тому поля по коорому мы ищем
    // 3 Tag  - указываем поле которое мы ищем
    // https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
    //  руководство по Spring JPA(описаны  все ключевые методы)
}
