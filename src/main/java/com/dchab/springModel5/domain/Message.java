package com.dchab.springModel5.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // дает знать Spring чот это сущностьсохр в б.д.
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
// ОБЯЗАТЕЛЬНО создай пустой конструктор   ИНАЧЕ  все сломается
    public Message() {
    }

    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    private  String text;
    private  String tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
