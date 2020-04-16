package com.legoons.consultantms.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private ModelMapper mapper;

    @Autowired
    public Mapper(ModelMapper mapper) {
        this.mapper = mapper;
    }
}
