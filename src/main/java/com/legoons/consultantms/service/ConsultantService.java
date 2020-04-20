package com.legoons.consultantms.service;

import com.legoons.consultantms.dto.ConsultantDTO;
import com.legoons.consultantms.dto.SearchRequest;
import org.springframework.data.domain.Page;

public interface ConsultantService {
    Page<ConsultantDTO> search(SearchRequest request);
}
