package com.shoeStore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Accessory {

    @Id
    @EqualsAndHashCode.Include
    String accessoryId;

    AccesoryType accessoryType;
    Size size;
    Color color;
    int price;
}
