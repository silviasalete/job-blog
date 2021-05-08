package com.empregospernambuco1.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@MappedSuperclass
public abstract class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long           id;

    @ManyToOne
    private City         city;

    @ManyToOne
    private User    createdBy;

    @ManyToOne
    private User    updatedBy;
    private String      title;
    private BigDecimal salary;
    private Date    createdIn;
    private Date    updatedIn;

    public Opportunity() {
    }

    public Opportunity(City city, User createdBy, User updatedBy, String title, BigDecimal salary, Date createdIn, Date updatedIn) {
        this.city = city;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.title = title;
        this.salary = salary;
        this.createdIn = createdIn;
        this.updatedIn = updatedIn;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(Date createdIn) {
        this.createdIn = createdIn;
    }

    public Date getUpdatedIn() {
        return updatedIn;
    }

    public void setUpdatedIn(Date updatedIn) {
        this.updatedIn = updatedIn;
    }

}
