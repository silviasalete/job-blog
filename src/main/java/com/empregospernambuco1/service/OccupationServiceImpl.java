package com.empregospernambuco1.service;

import com.empregospernambuco1.model.Occupation;
import com.empregospernambuco1.repository.OccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccupationServiceImpl implements OccupationService{

    @Autowired
    OccupationRepository occupationRepository;

    @Override
    public List<Occupation> findAll() {
        return occupationRepository.findAll();
    }
}
