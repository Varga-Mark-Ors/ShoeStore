package com.shoeStore.web;

import com.shoeStore.model.AccesoryType;
import com.shoeStore.model.Accessory;
import com.shoeStore.model.Color;
import com.shoeStore.model.Size;
import lombok.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
public interface AccessoryController {

    @GetMapping("/accessories")
    List<Accessory> findAll();

    @GetMapping("/accessories/{accessoryId}")
    List<Accessory> findById(@PathVariable String accessoryId);

    @GetMapping("/accessories/search")
    List<Accessory> search(
            @NonNull @RequestParam Optional<AccesoryType> type,
            @NonNull @RequestParam Optional<Size> size,
            @NonNull @RequestParam Optional<Color> color,
            @NonNull @RequestParam Optional<Integer> sum1,
            @NonNull @RequestParam Optional<Integer> sum2);
}
