package com.shoeStore.web;

import com.shoeStore.model.Shoe;
import com.shoeStore.repository.ShoeRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Service
public class ShoeService implements ShoeController{

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoeService.class);

    private ShoeRepository repository;

    @Override
    public List<Shoe> findAll() {
        LOGGER.info("Find all Shoes");
        return repository.findAll();
    }

    @Override
    public Shoe findById(String shoeId) {
        LOGGER.info("Find Shoe by ID");
        return repository.findById(shoeId)
                .orElseThrow(() -> new IllegalArgumentException("Shoe does not exist"));
    }
}
