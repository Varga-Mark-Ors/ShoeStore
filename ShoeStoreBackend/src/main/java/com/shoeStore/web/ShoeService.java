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
        LOGGER.info("Find all shoes");
        return repository.findAll();
    }

    @Override
    public List<Shoe> findById(String shoeId) {
        LOGGER.info("Find shoe by ID");
        String prefix = shoeId.substring(0, shoeId.length() - 1);
        return repository.findAll()
                .stream()
                .filter(shoe -> shoe.getShoeId().startsWith(prefix))
                .toList();
    }
}
