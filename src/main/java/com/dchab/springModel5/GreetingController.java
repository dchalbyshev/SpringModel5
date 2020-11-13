package com.dchab.springModel5;



import com.dchab.springModel5.domain.Message;
import com.dchab.springModel5.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
 @Autowired
 private MessageRepo messageRepo;

    // в model складываем данные котторые хотим вернуть пользователю
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="friend") String name, Map<String,Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public  String main(Map<String,Object>model ){
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages",messages);

     return "main";
    }

}