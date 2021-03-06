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
        model.addAttribute("job",         new JobDto());
        model.addAttribute("cities",      cityService.findAll());
        model.addAttribute("occupations", occupationService.findAll());
        return "job/new";

    }

    @PostMapping("/new")
    public String jobNewPost(JobDto jobDto,Principal principal) {
        jobService.save(jobService.jobToEntity(jobDto),principal);
        return "redirect:/job/new?success";
    }

    @GetMapping("/edit/{id}")
    public String editGet(Model model, @PathVariable String id) {
        model.addAttribute("job",         jobService.jobToDto(jobService.findById(Long.parseLong(id))));
        model.addAttribute("cities",      cityService.findAll());
        model.addAttribute("occupations", occupationService.findAll());
        return "job/edit";
    }

    @PostMapping("/edit")
    public String editPost(JobDto jobDto, Principal principal) {
        jobService.edit(jobService.jobToEntity(jobDto), principal);
        return "redirect:/job/edit/" + jobDto.getId() + "?success";
    }

    @GetMapping("/delete/{id}")
    public String deleteGet(Model model, @PathVariable String id) {
        jobService.delete(id);
        return "redirect:/job?success";
    }
}
