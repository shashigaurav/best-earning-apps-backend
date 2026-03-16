package com.bestearningapps.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logo;
    private String banner;
    private String favicon;

    private String metaTitle;
    private String metaDescription;
    private String metaKeywords;

    private String whatsapp;
    private String telegram;

    @Column(columnDefinition = "TEXT")
    private String headCode;

    @Column(columnDefinition = "TEXT")
    private String bodyCode;

    @Column(columnDefinition = "TEXT")
    private String footerCode;

}
