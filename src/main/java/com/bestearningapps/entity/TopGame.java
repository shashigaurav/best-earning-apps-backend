package com.bestearningapps.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TopGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long gameId;

}
