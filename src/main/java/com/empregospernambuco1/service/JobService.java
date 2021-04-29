package com.empregospernambuco1.service;

import com.empregospernambuco1.model.Job;

import java.util.List;

public interface JobService {

    Job save(Job job);
    List<Job> findAll();
    Job findById(Long id);
}
