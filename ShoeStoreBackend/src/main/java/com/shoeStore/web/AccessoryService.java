package com.shoeStore.web;

import com.shoeStore.model.Accessory;
import com.shoeStore.repository.AccessoryRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@Service
public class AccessoryService implements AccessoryController{

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoeService.class);

    private AccessoryRepository repository;

    @Override
    public List<Accessory> findAll() {
        LOGGER.info("Find all accesories");
        return repository.findAll();
    }

    @Override
    public List<Accessory> findById(String accessoryId) {
        LOGGER.info("Find accessory by ID");
        String prefix = accessoryId.substring(0, accessoryId.length() - 1);
        return repository.findAll()
                .stream()
                .filter(accessory -> accessory.getAccessoryId().startsWith(prefix))
                .toList();
    }
}
