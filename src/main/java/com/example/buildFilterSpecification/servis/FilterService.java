package com.example.buildFilterSpecification.servis;

import com.example.buildFilterSpecification.exception.FilterServiceException;
import com.example.buildFilterSpecification.model.Filter;
import com.example.buildFilterSpecification.repository.FilterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterService {

    private final FilterRepository filterRepository;

    public List<Filter> filterData(Specification<Filter> filterSpecification) {
        try {
            return filterRepository.findAll(filterSpecification);
        } catch (RuntimeException e) {
            throw new FilterServiceException("Filter data could not be retrieved.", e);
        }
    }
}
