package com.darius.contentcalendar;


import org.springframework.stereotype.Component;

@Component
public class Message {

    public String getMessage() {
        return String.format("%s", "hello world");
    }


}
