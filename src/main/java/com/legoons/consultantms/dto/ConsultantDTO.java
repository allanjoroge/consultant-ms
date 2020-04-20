package com.legoons.consultantms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultantDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String title;
    private String businessUnit;
    private Boolean travel;
    private Boolean relocate;
}
