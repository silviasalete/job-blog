package com.empregospernambuco1.repository;

import com.empregospernambuco1.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends OpportunityRepository<Job>{
}
