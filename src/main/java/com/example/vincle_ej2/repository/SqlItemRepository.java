package com.example.vincle_ej2.repository;

import com.example.vincle_ej2.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlItemRepository extends JpaRepository<ItemEntity, Integer> {


}
