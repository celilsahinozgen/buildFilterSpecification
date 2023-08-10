package com.example.buildFilterSpecification.config;

import com.example.buildFilterSpecification.enumlar.FiltreOperatoru;
import com.example.buildFilterSpecification.model.Filter;
import org.springframework.data.jpa.domain.Specification;

import static com.example.buildFilterSpecification.enumlar.FiltreOperatoru.*;

public class FilterSpecification {

    public static Specification<Filter> buildFilterSpecification(String fieldName, FiltreOperatoru operator, String keyword) {
        return (root, query, builder) -> {
            switch (operator) {
                case BUYUKTUR:
                    return builder.greaterThan(root.get(fieldName), keyword);
                case KUCUKTUR:
                    return builder.lessThan(root.get(fieldName), keyword);
                case ESITTIR:
                    return builder.equal(root.get(fieldName), keyword);
                case ICERIR:
                    return builder.like(root.get(fieldName), "%" + keyword + "%");
                default:
                    return null;
            }
        };
    }
}