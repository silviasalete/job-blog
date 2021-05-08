package com.empregospernambuco1.service.impl;

import com.empregospernambuco1.model.Job;
import com.empregospernambuco1.model.User;
import com.empregospernambuco1.repository.JobRepository;
import com.empregospernambuco1.repository.UserRepository;
import com.empregospernambuco1.service.JobService;
import com.empregospernambuco1.web.dto.JobDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

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

    public JobDto jobToDto(Job job){
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setTitle(job.getTitle());
        jobDto.setCity(job.getCity());
        jobDto.setOccupation(job.getOccupation());
        jobDto.setSalary(job.getSalary().toString());
        jobDto.setCompany(job.getCompany());
        jobDto.setEmail(job.getEmail());
        jobDto.setDescription(job.getDescription());
        jobDto.setType(job.getType());
        jobDto.setStatus(job.getStatus());
        jobDto.setRecurrent(job.getRecurrent());
        return jobDto;
    }

    public Job jobToEntity(JobDto jobDto) {

        Job job = new Job();
        job.setId(jobDto.getId());
        job.setTitle(jobDto.getTitle());
        job.setCity(jobDto.getCity());
        job.setOccupation(jobDto.getOccupation());
        job.setSalary(new BigDecimal(jobDto.getSalary().replace(".","").replace(",",".")));
        job.setCompany(jobDto.getCompany());
        job.setEmail(jobDto.getEmail());
        job.setDescription(jobDto.getDescription());
        job.setType(jobDto.getType());
        job.setStatus(jobDto.getStatus());
        job.setRecurrent(jobDto.getRecurrent());

        return job;
    }
}
