package com.mycompany.RemoutedServiceRabbit.restControllers;

import com.mycompany.RemoutedServiceRabbit.model.ChangeRow;
import com.mycompany.RemoutedServiceRabbit.services.modelService.DefaultChangeRowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ChangeRowController {

    @Autowired
    @Qualifier("changeRowService")
    private DefaultChangeRowService service;

    @GetMapping("/all")
    public List<ChangeRow> getAll(){
        return service.getAll();
    }
}
