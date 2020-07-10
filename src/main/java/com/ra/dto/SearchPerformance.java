package com.ra.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SearchPerformance {
    @NotNull
    private Integer year;
    @NotNull
    private Integer studentClass;
    @NotBlank
    private String section;
    @NotBlank
    private String exam;

    private Integer roll;
}
