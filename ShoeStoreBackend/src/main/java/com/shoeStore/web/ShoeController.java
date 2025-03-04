package com.shoeStore.web;

import com.shoeStore.model.Shoe;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@CrossOrigin(origins = "*")
public interface ShoeController {

    @GetMapping("/shoes")
    List<Shoe> findAll();

    @GetMapping("/shoes/{shoeId}")
    List<Shoe> findById(@PathVariable String shoeId);
}
