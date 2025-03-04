package com.shoeStore;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoeStore.model.Accessory;
import com.shoeStore.model.Shoe;
import com.shoeStore.repository.AccessoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@AllArgsConstructor
@Component
public class AccessoryRunner
    implements CommandLineRunner {
    private AccessoryRepository accessoryRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        InputStream is = getClass().getClassLoader().getResourceAsStream("com/shoeStore/accessory.json");

        if (is == null) {
            throw new IllegalArgumentException("shoes.json not found");
        }

        ObjectMapper mapper = new ObjectMapper();
        List<Accessory> accessories = mapper.readValue(is, new TypeReference<List<Accessory>>() {
        });

        accessories.stream()
                .map(accessoryRepository::save)
                .forEach(System.out::println);
    }
}
