package com.legoons.consultantms.service.impl;

import com.legoons.consultantms.dto.ConsultantDTO;
import com.legoons.consultantms.dto.SearchRequest;
import com.legoons.consultantms.entity.Consultant;
import com.legoons.consultantms.mapper.Mapper;
import com.legoons.consultantms.repository.ConsultantRepository;
import com.legoons.consultantms.service.ConsultantService;
import com.querydsl.core.BooleanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ConsultantServiceImpl implements ConsultantService {

    private ConsultantRepository consultantRepository;
    private Mapper mapper;

    @Autowired
    public ConsultantServiceImpl(ConsultantRepository consultantRepository, Mapper mapper) {
        this.consultantRepository = consultantRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<ConsultantDTO> search(SearchRequest request) {

        log.debug("vehicle search request {}", request);

        Sort sortOrder = createSortOrder(request);
        PageRequest paging = PageRequest.of(request.getPageNo(), request.getPageSize(), sortOrder);
        BooleanBuilder predicate = ConsultantRepository.createSearchPredicate(request);

        Page<Consultant> pageVehicles = consultantRepository.findAll(predicate, paging);

        List<ConsultantDTO> vDTOs = new ArrayList<>();

        for (Consultant c : pageVehicles) {
            vDTOs.add(mapper.transform(c));
        }

        return new PageImpl<>(vDTOs, paging, pageVehicles.getTotalElements());
    }

    protected Sort createSortOrder(SearchRequest searchRequest) {

        List<Sort.Order> orderList = new ArrayList<>();

        if ((searchRequest == null) || (searchRequest.getSortColumn() == null)) {
            //return default sort column
            orderList.add(createSortOrder(null, null));
        } else {

            for (int i = 0; i < searchRequest.getSortColumn().length; i++) {
                String col = searchRequest.getSortColumn()[i];
                String dir = searchRequest.getSortDirection()[i];
                orderList.add(createSortOrder(col, dir));
            }
        }
        log.debug("sort by list is {}", orderList.toString());

        return Sort.by(orderList);
    }

    private Sort.Order createSortOrder(String column, String direction) {

        log.debug("BEFORE column is {} and direction is {}", column, direction);

        if (StringUtils.isEmpty(column)) {
            column = "lastName";
        }
        if (StringUtils.isEmpty(direction)) {
            direction = "ASC";
        }

        log.debug("AFTER column is {} and direction is {}", column, direction);

        if ("DESC".equalsIgnoreCase(direction)) {
            return Sort.Order.desc(column);
        }
        return Sort.Order.asc(column);
    }
}

