package com.ikea.warehouse.repository;

import com.ikea.warehouse.models.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Articles,Long> {
}
