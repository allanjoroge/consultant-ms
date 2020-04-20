package com.legoons.consultantms.mapper;

import com.legoons.consultantms.dto.ConsultantDTO;
import com.legoons.consultantms.entity.Consultant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private ModelMapper modelMapper;

    @Autowired
    public Mapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ConsultantDTO transform(Consultant vehicle){
        return modelMapper.map(vehicle, ConsultantDTO.class);
    }
    public Consultant reverseTransform(ConsultantDTO vehicleDTO){
        return modelMapper.map(vehicleDTO, Consultant.class);
    }
}
