package com.example.workshop01.model;

import org.springframework.web.bind.annotation.ModelAttribute;

public class IndexModel {
    private String name = null;
    private String mail = null;

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public void setData(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }
}
