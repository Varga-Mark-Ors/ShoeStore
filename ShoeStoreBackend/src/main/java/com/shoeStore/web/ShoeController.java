package com.shoeStore.web;

import com.shoeStore.model.*;
import lombok.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
public interface ShoeController {

    @GetMapping("/shoes")
    List<Shoe> findAll();

    @GetMapping("/shoes/{shoeId}")
    List<Shoe> findById(@PathVariable String shoeId);

    @GetMapping("/shoes/search")
    List<Shoe> search(
            @NonNull @RequestParam Optional<String> model,
            @NonNull @RequestParam Optional<Integer> sum1,
            @NonNull @RequestParam Optional<Integer> sum2,
            @NonNull @RequestParam Optional<Boolean> gender,
            @NonNull @RequestParam Optional<Boolean> adults,
            @NonNull @RequestParam Optional<Color> color,
            @NonNull @RequestParam Optional<Integer> size
            );
}
