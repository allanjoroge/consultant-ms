package com.legoons.consultantms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {

    private String email;

    //sorting
    private String[] sortColumn;
    private String[] sortDirection;
    //pagination
    private Integer pageNo = 0;
    private Integer pageSize = 10;
}

