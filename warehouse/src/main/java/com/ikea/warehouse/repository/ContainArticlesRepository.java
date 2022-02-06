package com.ikea.warehouse.repository;

import com.ikea.warehouse.models.ContainArticles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContainArticlesRepository extends JpaRepository<ContainArticles,Long> {
}
