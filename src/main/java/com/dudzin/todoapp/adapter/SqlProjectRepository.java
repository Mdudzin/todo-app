package com.dudzin.todoapp.adapter;

import com.dudzin.todoapp.model.Project;
import com.dudzin.todoapp.model.ProjectRepository;
import com.dudzin.todoapp.model.TaskGroup;
import com.dudzin.todoapp.model.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlProjectRepository extends ProjectRepository, JpaRepository<Project, Integer> {

    @Override
    @Query("select distinct p from Project p join fetch p.steps")
    List<Project> findAll();
}