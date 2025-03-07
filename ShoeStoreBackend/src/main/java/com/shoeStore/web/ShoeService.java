package com.shoeStore.web;

import com.shoeStore.model.Color;
import com.shoeStore.model.Shoe;
import com.shoeStore.repository.ShoeRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Service
public class ShoeService implements ShoeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoeService.class);
    private ShoeRepository repository;

    @Override
    public List<Shoe> findAll() {
        LOGGER.info("Find all shoes");
        return repository.findAll();
    }

    @Override
    public List<Shoe> findById(String shoeId) {
        LOGGER.info("Find shoe by ID: {}", shoeId);

        String prefix = shoeId.substring(0, shoeId.length() - 1);
        return repository.findAll()
                .stream()
                .filter(shoe -> shoe.getShoeId().startsWith(prefix))
                .toList();
    }

    @Override
    public List<Shoe> search(@NonNull Optional<String> model,
                             @NonNull Optional<Integer> sum1,
                             @NonNull Optional<Integer> sum2,
                             @NonNull Optional<Boolean> gender,
                             @NonNull Optional<Boolean> adults,
                             @NonNull Optional<Color> color,
                             @NonNull Optional<Integer> size) {

        LOGGER.info("Starting shoe search...");

        List<Shoe> allShoes = repository.findAll();
        LOGGER.info("Total shoes before filtering: {}", allShoes.size());

        return allShoes.stream()
                .filter(shoe -> model.map(s -> s.equals(shoe.getModel())).orElse(true))
                .filter(shoe -> gender.map(g -> g == shoe.isGender()).orElse(true))
                .filter(shoe -> adults.map(a -> a == shoe.isAdults()).orElse(true))
                .filter(shoe -> color.map(c -> c == shoe.getColor()).orElse(true))
                .filter(shoe -> {
                    int price = shoe.getPrice();
                    return sum1.map(min -> price >= min).orElse(true) &&
                            sum2.map(max -> price <= max).orElse(true);
                })
                .filter(shoe -> size.map(s -> {
                    List<Integer> sizes = shoe.getSize();
                    List<Integer> pieces = shoe.getPieces();
                    int index = sizes.indexOf(s);
                    return index >= 0 && index < pieces.size() && pieces.get(index) > 0;
                }).orElse(true))
                .toList();
    }
}
