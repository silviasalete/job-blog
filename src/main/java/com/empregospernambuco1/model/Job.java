package com.empregospernambuco1.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String                 title;
    @ManyToOne
    private City                    city;
    @ManyToOne
    private Occupation        occupation;
    private BigDecimal            salary;
    private String               company;
    private String                 email;
    private String           description;

    @Enumerated(EnumType.STRING)
    private TypeJob type;

    @Enumerated(EnumType.STRING)
    private StateJob status;

    @Enumerated(EnumType.STRING)
    private RecurrentJob recurrent;

    public Job() {
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
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
}
