package com.dchab.springModel5;



import com.dchab.springModel5.domain.Message;
import com.dchab.springModel5.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
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
@PostMapping // допданные не указываем значит форма идет на тот же адрес с
  public String add(@RequestParam String text,@RequestParam String tag, Map<String,Object>model){ // с которго  отправлена
    //@RequestParam String text по имени полей выдергиваем поля (у нас же Post запрос)
Message message = new Message(text,tag);
messageRepo.save(message);
// сохранили
    Iterable<Message> messages = messageRepo.findAll();
    model.put("messages",messages);
// 2 ой шаг взяли из репозитория и отдали пользователю

return "main";
}

@PostMapping("filter")
    public  String filter( @RequestParam String filter,Map<String,Object>model){
        Iterable<Message> messages;
        // Iterable здесь потому как messageRepo.findAll() возращает Iterable
        // а messageRepo.findByTag(filter) возращает List который имплементит Iterable

        if(filter!=null && !filter.isEmpty())   // проверяем задан ли лист и не пустой тли он
        { messages = messageRepo.findByTag(filter);}
        else {
            messages = messageRepo.findAll();
        }
    model.put("messages",messages);
        return  "main";
}
    }