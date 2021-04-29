package com.empregospernambuco1.service;

import com.empregospernambuco1.model.Job;
import com.empregospernambuco1.model.User;
import com.empregospernambuco1.repository.JobRepository;
import com.empregospernambuco1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    JobRepository jobRepository;
    Date today = new Date();

    @Override
    public Job save(Job job, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        job.setCreatedBy(user);
        job.setUpdatedBy(user);
        job.setCreatedIn(today);
        job.setUpdatedIn(today);
        return jobRepository.save(job);
    }

    @Override
    public Job edit(Job job, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        job.setUpdatedBy(user);
        job.setUpdatedIn(today);
        return jobRepository.save(job);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job findById(Long id) {
        Optional<Job> job = jobRepository.findById(id);
        return job.get();
    }

    @Override
    public void delete(String id) {
        Optional<Job> optionalJob = jobRepository.findById(Long.parseLong(id));
        jobRepository.delete(optionalJob.get());
    }
}
