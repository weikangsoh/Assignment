package com.example.workshop01.controller;

import com.example.workshop01.model.IndexModel;
import com.example.workshop01.repo.IndexRepository;
import com.example.workshop01.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class IndexController {

    @Autowired
    IndexService indexService;

    @Autowired
    IndexRepository indexRepository;

    @GetMapping("/index1")
    public String index1() {
       return indexService.returnData();
    }


    @PostMapping ("/index2")
    public String index2(@RequestParam String name, @RequestParam String mail) {
        IndexModel newData = new IndexModel(name, mail);
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
    public ResponseEntity<String> index6() {
        ResponseEntity<String> payload = new ResponseEntity<String>("success", HttpStatus.OK);
        return payload;
    }

    @GetMapping("/index7")
    public ResponseEntity<List> index() {
        List<IndexModel> indexModel = indexRepository.findAll();
        ResponseEntity<List> payload = new ResponseEntity<List>(indexModel, HttpStatus.OK);
        return payload;
    }

    @GetMapping("/index8/{id}")
    public ResponseEntity<Optional> show(@PathVariable String id){
        int indexId = Integer.parseInt(id);
        ResponseEntity<Optional> payload = new ResponseEntity<Optional>(indexRepository.findById(indexId), HttpStatus.OK);
        return payload;
    }

    @PostMapping("/index9")
    public ResponseEntity<IndexModel> create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        String mail = body.get("mail");
        ResponseEntity<IndexModel> payload = new ResponseEntity<IndexModel>(indexRepository.save(new IndexModel(name, mail)), HttpStatus.OK);
        return payload;
    }

    @PutMapping("/index10/{id}")
    public ResponseEntity<IndexModel> update(@PathVariable String id, @RequestBody Map<String, String> body){
        int indexId = Integer.parseInt(id);
        Optional<IndexModel> indexModelOp = indexRepository.findById(indexId);
        IndexModel indexModel = indexModelOp.get();
        indexModel.setName(body.get("name"));
        indexModel.setMail(body.get("mail"));
        ResponseEntity<IndexModel> payload = new ResponseEntity<IndexModel>(indexRepository.save(indexModel), HttpStatus.OK);
        return payload;
    }

    @DeleteMapping("index11/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id){
        int indexId = Integer.parseInt(id);
        indexRepository.deleteById(indexId);
        ResponseEntity payload = new ResponseEntity(true, HttpStatus.OK);
        return payload;
    }

}