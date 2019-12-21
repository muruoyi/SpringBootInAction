package com.muruoyi.springbootdemo.api;

import com.muruoyi.springbootdemo.api.vo.ApiResult;
import com.muruoyi.springbootdemo.model.Account;
import com.muruoyi.springbootdemo.model.Todo;
import com.muruoyi.springbootdemo.service.AccountService;
import com.muruoyi.springbootdemo.service.TodoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoApi {

    @Autowired
    TodoService todoService;

    @Autowired
    AccountService accountService;

    @GetMapping("/addTodo")
    @ApiOperation(value = "add a todo", notes = "在新增时，id是不需要的，title is requried.")
    public String ok(){
        List<Todo> todoList = new ArrayList<>();
        Todo todo = Todo.builder().id(1).desc("desc1").title("title1").completed(false).build();
        todoList.add(todo);
        todo = Todo.builder().id(2).desc("desc2").title("title2").completed(false).build();
        todoList.add(todo);
        todoService.addTestTodos(todoList);
        return "OK";
    }

    @GetMapping("/todo")
    public ApiResult getTodo(){
        return ApiResult.success(todoService.getTodos());
    }

    @GetMapping("/todo/title")
    public List<Todo> getTodoByTitle(String title){
        return todoService.getByTitle(title);
    }

    @PostMapping("/todo/title")
    public ApiResult getTodoByTitle(@RequestBody @Validated Todo todo){
        todoService.saveTodo(todo);
        return ApiResult.success(null);
    }

    @GetMapping("/todo/completed/{completed}")
    public List<Todo> getTodoByCompleted(@PathVariable(name = "completed") String completed){
        return todoService.getByCompleted(completed.equalsIgnoreCase("true"));
    }

    @GetMapping("/todo/account/{accountId}")
    public ApiResult getTodoByAccount(@PathVariable(name = "accountId") Integer accountId){
        return ApiResult.success(todoService.getByAccountId(accountId));
    }
}
