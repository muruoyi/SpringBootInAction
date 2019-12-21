package com.muruoyi.springbootdemo.service;

import com.muruoyi.springbootdemo.dto.TodoDto;
import com.muruoyi.springbootdemo.model.Todo;

import java.util.List;

public interface TodoService {

    void addTestTodos(List<Todo> todos);

    void addTodo(Todo todo);

    List<Todo> getTodos();

    List<Todo> getByTitle(String title);

    List<Todo> getByCompleted(Boolean completed);

    List<TodoDto> getByAccountId(Integer accountId);

    Todo saveTodo(Todo todo);
}
