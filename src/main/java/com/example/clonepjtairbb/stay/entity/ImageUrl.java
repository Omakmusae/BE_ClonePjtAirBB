package com.example.clonepjtairbb.stay.entity;

import jakarta.persistence.*;

@Entity
public class ImageUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private StayDetailFeature stayDetailFeature;
    private String url;
}
