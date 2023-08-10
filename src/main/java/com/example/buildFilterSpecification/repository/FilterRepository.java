package com.example.buildFilterSpecification.repository;

import com.example.buildFilterSpecification.model.Filter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Long>, JpaSpecificationExecutor<Filter> {
}