package com.rocket.rockettest.repository;

import com.rocket.rockettest.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskRepository {
    List<Task> findAll();
    void save(Task taskDetails);
    void delete(Long id);
    void update(@Param("id") Long id, @Param("task") Task taskDetails);
}
