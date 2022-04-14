package com.example.workshop01.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IndexModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String mail;

    public IndexModel() { }

    public IndexModel(String name, String mail) {
        this.setName(name);
        this.setMail(mail);
    }

    public IndexModel(int id, String name, String mail) {
        this.setId(id);
        this.setName(name);
        this.setMail(mail);
    }



    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public int getId() { return id; }

    public void setId (int id) {
        this.id = id;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setMail (String mail) {
        this.mail = mail;
    }

    public void setData(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", mail='" + mail + "'" +
                "}";

    }
}
