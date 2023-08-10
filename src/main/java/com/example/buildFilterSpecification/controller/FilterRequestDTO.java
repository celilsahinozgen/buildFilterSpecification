package com.example.buildFilterSpecification.controller;

import com.example.buildFilterSpecification.enumlar.FiltreOperatoru;
import lombok.Data;


@Data
public class FilterRequestDTO {

    private String fieldName;
    private FiltreOperatoru operator;
    private String keyword;

}




