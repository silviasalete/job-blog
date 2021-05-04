package com.empregospernambuco1.service;

import com.empregospernambuco1.model.Job;
import com.empregospernambuco1.web.dto.JobDto;

import java.security.Principal;
import java.util.List;

public interface JobService {

    Job       findById(Long id);
    List<Job> findAll();
    Job       save(Job job, Principal principal);
    Job       edit(Job job, Principal principal);
    void      delete(String id);
    JobDto jobToDto(Job job);
    Job jobToEntity(JobDto jobDto);
}
