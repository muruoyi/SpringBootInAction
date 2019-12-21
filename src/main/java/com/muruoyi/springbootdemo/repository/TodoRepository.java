package com.muruoyi.springbootdemo.repository;

import com.muruoyi.springbootdemo.dto.TodoDto;
import com.muruoyi.springbootdemo.model.Account;
import com.muruoyi.springbootdemo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {

    List<Todo> findByTitle(String title);

    List<Todo> findByCompleted(Boolean completed);

    @Query("select new com.muruoyi.springbootdemo.dto.TodoDto(t.id,t.title,t.desc,t.completed,t.accountId) " +
            "from Todo t where t.accountId = :accountId ")
    List<TodoDto> findByAccountId(Integer accountId);
}
