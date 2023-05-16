package com.example.clonepjtairbb.stay.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class ImageUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private StayDetailFeature stayDetailFeature;
    private String url;

    public ImageUrl(StayDetailFeature stayDetailFeature, String url) {
        this.stayDetailFeature = stayDetailFeature;
        this.url = url;
    }
}
