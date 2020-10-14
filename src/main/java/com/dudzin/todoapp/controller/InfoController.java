package com.dudzin.todoapp.controller;

import com.dudzin.todoapp.TaskConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private DataSourceProperties dataSource;
    private TaskConfigurationProperties myProp;

    public InfoController(DataSourceProperties dataSource, TaskConfigurationProperties myProp) {
        this.dataSource = dataSource;
        this.myProp = myProp;
    }

    @GetMapping("/info/url")
    public String url() {
        return dataSource.getUrl();
    }

    @GetMapping("/info/prop")
    public boolean myProp() {
        return myProp.getTemplate().isAllowMultipleTasks();
    }
}