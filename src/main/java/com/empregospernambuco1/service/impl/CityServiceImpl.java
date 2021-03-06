package com.empregospernambuco1.service.impl;

import com.empregospernambuco1.model.City;
import com.empregospernambuco1.repository.CityRepository;
import com.empregospernambuco1.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll(){
       return cityRepository.findAll();
    }
}
