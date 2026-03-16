package com.bestearningapps.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String appName;
    private String gameTitle;
    private String bonus;
    private String image;
    private String keywords;
    private String downloadLink;
    private String category;
}