package com.empregospernambuco1.repository;

import com.empregospernambuco1.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface OpportunityRepository<T extends Opportunity> extends JpaRepository<T, Long>  {
    Optional<T> findById(Long id);
    List<T>     findAll();
}
