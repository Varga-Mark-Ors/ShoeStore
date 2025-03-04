package com.shoeStore.web;

import com.shoeStore.model.Accessory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@CrossOrigin(origins = "*")
public interface AccessoryController {

    @GetMapping("/accessories")
    List<Accessory> findAll();

    @GetMapping("/accessories/{accessoryId}")
    Accessory findById(@PathVariable String accessoryId);
}
