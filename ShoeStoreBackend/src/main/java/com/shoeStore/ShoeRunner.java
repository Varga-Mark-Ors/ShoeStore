package com.shoeStore;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoeStore.model.Shoe;
import com.shoeStore.repository.ShoeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@AllArgsConstructor
@Component
public class ShoeRunner
    implements CommandLineRunner {

    private ShoeRepository shoeRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        InputStream is = getClass().getClassLoader().getResourceAsStream("com/shoeStore/shoes.json");

        if (is == null) {
            throw new IllegalArgumentException("shoes.json not found");
        }

        ObjectMapper mapper = new ObjectMapper();
        List<Shoe> shoes = mapper.readValue(is, new TypeReference<List<Shoe>>() {
        });

        shoes.stream()
                .map(shoeRepository::save)
                .forEach(System.out::println);
    }
}
