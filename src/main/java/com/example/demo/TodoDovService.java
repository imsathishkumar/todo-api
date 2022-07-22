package com.example.demo;

import com.example.demo.customException.NoRecordFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TodoDovService {
    private static final ArrayList<TodoModel> todoList = new ArrayList<>();
    private static Integer listCount=3;

    static {
        todoList.add(new TodoModel(1,"sathish","WorkFast"));
        todoList.add(new TodoModel(2,"ruban","todo"));
        todoList.add(new TodoModel(3,"rohith","WorkFast"));
    }

    public ArrayList<TodoModel> findAll(){
        return todoList;
    }

    public void save(TodoModel list){
        if(list.getId() == 0){
            list.setId(++listCount);
        }
        todoList.add(list);
    }
    public void  edit(Integer id,TodoModel list){
        for(TodoModel item:todoList){
            if(item.getId().equals(id)){
                item.setDiscription(list.getDiscription());
                item.setTitle(list.getTitle());
            }
        }
    }
    public ResponseEntity<?> delete(Integer id) throws NoRecordFoundException {
        TodoModel removeItem = null;
        for(int i = 0; i < todoList.size(); i++){
            if(todoList.get(i).getId().equals(id)){
                removeItem = todoList.remove(i);
            }
        }
        if(removeItem==null) throw new NoRecordFoundException();
        return new ResponseEntity<>(removeItem, HttpStatus.OK);
    }

}
