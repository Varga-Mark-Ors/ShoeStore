package com.shoeStore.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Shoe {

    @Id
    @EqualsAndHashCode.Include
    String shoeId;

    String model;
    int price;
    Color color;
    boolean gender;
    boolean adults;

    @ElementCollection
    @CollectionTable(name = "shoe_sizes")
    @Column(name = "size")
    List<Integer> size;

    @ElementCollection
    @CollectionTable(name = "number_of_shoe_sizes")
    @Column(name = "pieces")
    List<Integer> pieces;

    String image;
}
