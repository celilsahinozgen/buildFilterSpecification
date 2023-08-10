package com.example.buildFilterSpecification.servis;

import com.example.buildFilterSpecification.model.Filter;
import com.example.buildFilterSpecification.repository.FilterRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterService {

    private final FilterRepository filterRepository;

    public FilterService(FilterRepository filterRepository) {
        this.filterRepository = filterRepository;
    }

    public List<Filter> filterData(Specification<Filter> filterSpecification) {
        return filterRepository.findAll(filterSpecification);
    }
}
