package com.shoeStore.web;

import com.shoeStore.model.AccesoryType;
import com.shoeStore.model.Accessory;
import com.shoeStore.model.Color;
import com.shoeStore.model.Size;
import com.shoeStore.repository.AccessoryRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Accessory> search(@NonNull Optional<AccesoryType> type,
                                  @NonNull Optional<Size> size,
                                  @NonNull Optional<Color> color,
                                  @NonNull Optional<Integer> sum1,
                                  @NonNull Optional<Integer> sum2) {
        return repository.findAll()
                .stream()
                .filter(accessory -> type.map(s -> s == accessory.getAccessoryType()).orElse(true))
                .filter(accessory -> size.map(size1 -> size1 == accessory.getSize()).orElse(true))
                .filter(accessory -> color.map(color1 -> color1 == accessory.getColor()).orElse(true))
                .filter(accessory -> {
                    int price = accessory.getPrice();
                    return sum1.map(min -> price >= min).orElse(true) &&
                            sum2.map(max -> price <= max).orElse(true);
                })
                .toList();
    }
}
