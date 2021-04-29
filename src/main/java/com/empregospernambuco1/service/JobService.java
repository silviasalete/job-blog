package com.empregospernambuco1.service;

import com.empregospernambuco1.model.Job;

import java.security.Principal;
import java.util.List;

public interface JobService {

    Job save(Job job, Principal principal);
    Job edit(Job job, Principal principal);
    List<Job> findAll();
    Job findById(Long id);
    void delete(String id);
}
