package com.example.demo;

import com.example.demo.customException.NoRecordFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TodoController {
    @Autowired
    private TodoDovService service;

    @GetMapping("/list")
    public ArrayList<TodoModel> getList(){
        return service.findAll();
    }

    @PostMapping("/list")
    public ArrayList<TodoModel> postList(@RequestBody TodoModel list){
        service.save(list);
        return service.findAll();
    }
    @PutMapping("/list/{id}")
    public ArrayList<TodoModel> editList(@PathVariable Integer id,
                                         @RequestBody TodoModel list){
        service.edit(id,list);
        return service.findAll();
    }
    @DeleteMapping("/list/{id}")
    public ResponseEntity<?> deleteList(@PathVariable Integer id) throws NoRecordFoundException {
        return (service.delete(id));
    }


}
