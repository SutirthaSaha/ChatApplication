package com.example.dell.chatapplication;

/**
 * Created by DELL on 25-Jan-18.
 */

public class Message {
    private String content,username;

    public Message(String content,String username) {
        this.content = content;
        this.username=username;
    }

    public Message() {
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {

        return content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
