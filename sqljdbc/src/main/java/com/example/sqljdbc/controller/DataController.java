package com.example.sqljdbc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sqljdbc.model.Data;
import com.example.sqljdbc.Repository.DataRepository;

@RestController
@RequestMapping("/apis")
public class DataController {

    @Autowired
    DataRepository obj;

    @GetMapping("/dataapi")
    public List<Data> getAllData() {
        return obj.findAll();
    }

    @PostMapping("/dataapi")
    public String Addition(@RequestBody Data temp) {
        obj.save(temp);
        return "Yes";
    }

    @GetMapping("/dataapi/{id}")
    public Data Retrieval(long id) {
        return obj.findById(id);
    }

    @PutMapping("/dataapi/{id}")
    public String Update( long id, @RequestBody Data temp) {
        
            obj.update(temp);
           
    }

    @DeleteMapping("/dataapi/{id}")
    public void Delete( long id) {
        obj.deleteById(id);

    }
}
