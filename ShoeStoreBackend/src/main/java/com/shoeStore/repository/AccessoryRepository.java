package com.shoeStore.repository;

import com.shoeStore.model.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessoryRepository
    extends JpaRepository<Accessory, String> {
}
