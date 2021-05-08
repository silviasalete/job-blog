package com.empregospernambuco1.web.dto;

import com.empregospernambuco1.model.*;

import java.math.BigDecimal;

public class JobDto {
    private Long id;
    private String             title;
    private City                city;
    private Occupation    occupation;
    private String            salary;
    private String           company;
    private String             email;
    private String       description;
    private TypeJob             type;
    private StateJob          status;
    private RecurrentJob   recurrent;

    public JobDto() {
        setStatus(StateJob.ACTIVE);
        setType(TypeJob.FULLTIME);
        setRecurrent(RecurrentJob.NO);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
//        this.salary = new BigDecimal(salary.replace(".","").replace(",","."));
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

    @Override
    public String toString() {
        return "JobDto{" +
                "  title='" + title + '\'' +
                ", city=" + city +
                ", occupation=" + occupation +
                ", salary=" + salary +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", recurrent=" + recurrent +
                '}';
    }
}
