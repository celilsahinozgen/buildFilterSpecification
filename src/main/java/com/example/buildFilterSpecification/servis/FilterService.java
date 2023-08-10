package com.example.buildFilterSpecification.servis;

import com.example.buildFilterSpecification.config.FilterSpecification;
import com.example.buildFilterSpecification.controller.FilterRequestDTO;
import com.example.buildFilterSpecification.exception.FilterServiceException;
import com.example.buildFilterSpecification.model.Filter;
import com.example.buildFilterSpecification.repository.FilterRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilterService {

    private final FilterRepository filterRepository;
    private final ModelMapper modelMapper;

    public List<Filter> filterData(Specification<Filter> filterSpecification) {
        try {
            return filterRepository.findAll(filterSpecification);
        } catch (RuntimeException e) {
            throw new FilterServiceException("Filter data could not be retrieved.", e);
        }
    }


    // Body olarak kontrol edilmiştir
    public List<FilterRequestDTO> filterData2(FilterRequestDTO filterRequestDTO) {
        Specification<Filter> filterSpecification = FilterSpecification.buildFilterSpecification(
                filterRequestDTO.getFieldName(),
                filterRequestDTO.getOperator(),
                filterRequestDTO.getKeyword()
        );

        List<Filter> filteredData = filterRepository.findAll(filterSpecification);
        return mapToFilterRequestDTOs(filteredData);
    }

    private List<FilterRequestDTO> mapToFilterRequestDTOs(List<Filter> filterList) {
        return filterList.stream()
                .map(filter -> modelMapper.map(filter, FilterRequestDTO.class))
                .collect(Collectors.toList());
    }



}
