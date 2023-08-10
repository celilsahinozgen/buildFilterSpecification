package com.example.buildFilterSpecification.controller;

import com.example.buildFilterSpecification.config.FilterSpecification;
import com.example.buildFilterSpecification.enumlar.FiltreOperatoru;
import com.example.buildFilterSpecification.model.Filter;
import com.example.buildFilterSpecification.servis.FilterService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filter")
@CrossOrigin("*")
public class FilterController {

    private final FilterService filterService;

    public FilterController(FilterService filterService) {
        this.filterService = filterService;
    }

    @GetMapping("/datafilter")
    public ResponseEntity<List<Filter>> filterData(
            @RequestParam(name = "fieldName") String fieldName,
            @RequestParam(name = "operator") FiltreOperatoru operator,
            @RequestParam(name = "keyword") String keyword) {

        Specification<Filter> filterSpecification = FilterSpecification.buildFilterSpecification(fieldName, operator, keyword);
        List<Filter> filteredData = filterService.filterData(filterSpecification);

        return ResponseEntity.ok(filteredData);
    }
}
