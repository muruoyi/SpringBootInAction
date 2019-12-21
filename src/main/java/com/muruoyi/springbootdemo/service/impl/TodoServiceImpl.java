package com.muruoyi.springbootdemo.service.impl;

import com.muruoyi.springbootdemo.dto.TodoDto;
import com.muruoyi.springbootdemo.exception.ServiceError;
import com.muruoyi.springbootdemo.exception.ServiceException;
import com.muruoyi.springbootdemo.model.Todo;
import com.muruoyi.springbootdemo.repository.TodoRepository;
import com.muruoyi.springbootdemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Transactional
    @Override
    public void addTestTodos(List<Todo> todos) {
        todos.forEach(o -> todoRepository.save(o));
    }

    @Transactional
    @Override
    public void addTodo(Todo todo) {

        todoRepository.save(todo);
    }

    @Override
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @Override
    public List<Todo> getByTitle(String title) {
        return todoRepository.findByTitle(title);
    }

    @Override
    public List<Todo> getByCompleted(Boolean completed) {
        return todoRepository.findByCompleted(completed);
    }

    @Override
    public List<TodoDto> getByAccountId(Integer accountId) {
        return todoRepository.findByAccountId(accountId);
    }

    @Override
    public Todo saveTodo(Todo todo) {
        if ("tom".equalsIgnoreCase(todo.getTitle())){
            throw new ServiceException(ServiceError.TitleCanNotBeTom);
        }
        return todoRepository.save(todo);
    }

}
