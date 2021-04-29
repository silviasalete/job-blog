package com.empregospernambuco1.web.dto;

import com.empregospernambuco1.model.*;
import com.empregospernambuco1.utils.FormatService;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class JobDto {

    private String       title;
    private City         city;
    private Occupation   occupation;
    private String   salary;
    private String       company;
    private String       email;
    private String       description;
    private TypeJob      type;
    private StateJob     status;
    private RecurrentJob recurrent;

    public JobDto() {
        setStatus(StateJob.ACTIVE);
        setType(TypeJob.FULLTIME);
        setRecurrent(RecurrentJob.NO);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeJob getType() {
        return type;
    }

    public void setType(TypeJob type) {
        this.type = type;
    }

    public StateJob getStatus() {
        return status;
    }

    public void setStatus(StateJob status) {
        this.status = status;
    }

    public RecurrentJob getRecurrent() {
        return recurrent;
    }

    public void setRecurrent(RecurrentJob recurrent) {
        this.recurrent = recurrent;
    }

    public Job toJob() {
        Job job = new Job();
        FormatService formatService = new FormatService();

        job.setTitle(getTitle());
        job.setCity(getCity());
        job.setOccupation(getOccupation());
        job.setSalary(formatService.stringToBigDecimail(getSalary()));
        job.setCompany(getCompany());
        job.setEmail(getEmail());
        job.setDescription(getDescription());
        job.setType(getType());
        job.setStatus(getStatus());
        job.setRecurrent(getRecurrent());
        return job;
    }
}