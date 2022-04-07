package com.example.workshop01.controller;

import com.example.workshop01.model.IndexModel;
import com.example.workshop01.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class IndexController {

    public static void main(String[] args) {
        SpringApplication.run(IndexController.class, args);
    }

    @Autowired
    private IndexService indexService;

    @GetMapping("/index1")
    public String index1() {
       return indexService.returnData();
    }


    @PostMapping ("/index2")
    public String index2(@RequestParam String name, @RequestParam String mail) {
        IndexModel newData = new IndexModel();
        newData.setData(name, mail);
        return newData.getName() + "\n" + newData.getMail();
    }

    @PostMapping ("/index3")
    public String index3(@RequestBody IndexModel newIndexModel) {
        return newIndexModel.getName() + "\n" + newIndexModel.getMail();
    }

}