package com.example.studentservice.entity;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullStudent", types = Student.class)
public interface studentProjection {
        public Long getId();
        public String getPrenom();
    }

