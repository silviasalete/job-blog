package com.empregospernambuco1.service.impl;

import com.empregospernambuco1.automation.Automation;
import com.empregospernambuco1.service.AutomationService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AutomationImpl implements AutomationService {

    private Automation automation = new Automation();

//    @Autowired
//    private AutomationRepository automationRepository;

    @Override
    public List<String> findAll() {
//        return automationRepository.findAll();

        return automation.getTitulos();
    }
}
