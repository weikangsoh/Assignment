package com.example.workshop01.controller;

import com.example.workshop01.model.IndexModel;
import com.example.workshop01.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {

    @Autowired
//    IndexService indexService = new IndexService();
    private IndexService indexService;

    @GetMapping("/index1")
    public String index1() {
       return indexService.returnData();
    }


    @PostMapping ("/index2")
    public String index2(@RequestParam String name, @RequestParam String mail) {
        IndexModel newData = new IndexModel();
        newData.setData(name, mail);
        return newData.getName() + "\n" + newData.getMail() + "\nSubmitted";
    }

    @PostMapping ("/index3")
    public String index3(@RequestBody IndexModel newIndexModel) {
        return newIndexModel.getName() + "\n" + newIndexModel.getMail() + "\nSubmitted";
    }

    @DeleteMapping ("/index4")
    public String index4(@RequestParam String id) {
        return "ID " +id+ " Deleted";
    }

    @PutMapping ("/index5")
    public String index5(@RequestBody IndexModel newIndexModel) {
        return newIndexModel.getName() + "\n" + newIndexModel.getMail() + "\nUpdated";
    }

    @GetMapping ("/index6")
    public ResponseEntity index6() {
        ResponseEntity payload = new ResponseEntity("success", HttpStatus.OK);
        return payload;
    }
}