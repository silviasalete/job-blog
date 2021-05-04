package com.empregospernambuco1.controller;

import com.empregospernambuco1.model.Job;
import com.empregospernambuco1.service.CityService;
import com.empregospernambuco1.service.JobService;
import com.empregospernambuco1.service.OccupationService;
import com.empregospernambuco1.web.dto.JobDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private CityService cityService;

    @Autowired
    private OccupationService occupationService;

    @GetMapping
    public String job(Model model) {
        model.addAttribute("jobs", jobService.findAll());
        return "job/home";
    }

    @GetMapping("/new")
    public String jobNewGet(Model model) {
        JobDto jobDto = new JobDto();
        System.out.println("jobDto.toString(): "+jobDto.toString());
        model.addAttribute("job", jobDto);
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("occupations", occupationService.findAll());
        return "job/new";

    }

    @PostMapping("/new")
    public String jobNewPost(JobDto jobDto,Principal principal) {
        System.out.println("jobDto.toString(): "+jobDto.toString());
        jobService.save(jobService.jobToEntity(jobDto),principal);
        return "redirect:/job/new?success";
    }

    @GetMapping("/edit/{id}")
    public String editGet(Model model, @PathVariable String id) {
        JobDto jobDto = new JobDto();
        Job job = jobService.findById(Long.parseLong(id));
        JobDto jobDto1 = jobService.jobToDto(job);
//        jobDto1.setSalary("123");
        model.addAttribute("id",id);
        model.addAttribute("job",jobDto1);
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("occupations", occupationService.findAll());
        return "job/edit";
    }

    @PostMapping("/edit")
    public String editPost(JobDto jobDto, Principal principal) {
        Job job = jobService.jobToEntity(jobDto);
        jobService.edit(job, principal);
        return "redirect:/job/edit/" + job.getId() + "?success";
    }

    @GetMapping("/delete/{id}")
    public String deleteGet(Model model, @PathVariable String id) {
        jobService.delete(id);
        return "redirect:/job?success";
    }
}
