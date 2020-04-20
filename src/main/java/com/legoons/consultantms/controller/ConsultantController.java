package com.legoons.consultantms.controller;

import com.legoons.consultantms.dto.ConsultantDTO;
import com.legoons.consultantms.dto.SearchRequest;
import com.legoons.consultantms.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/consultants")
@RestController
public class ConsultantController {

    private ConsultantService consultantService;

    @Autowired
    public ConsultantController(ConsultantService consultantService) {
        this.consultantService = consultantService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ConsultantDTO> search(SearchRequest request) {

        return consultantService.search(request);
    }
}

