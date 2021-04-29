package com.empregospernambuco1.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Job extends Opportunity {

    @ManyToOne
    private Occupation        occupation;

    @Enumerated(EnumType.STRING)
    private TypeJob                 type;

    @Enumerated(EnumType.STRING)
    private StateJob              status;

    @Enumerated(EnumType.STRING)
    private RecurrentJob       recurrent;
    private String               company;
    private String                 email;
    private String           description;

    public Job() {
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

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }
}
