package com.bestearningapps.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

}