package com.example.clonepjtairbb.stay.entity;

import com.example.clonepjtairbb.common.enums.ConvenienceEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Convenience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private StayDetailFeature stayDetailFeature;
    private ConvenienceEnum convenience;

    public Convenience(StayDetailFeature stayDetailFeature, ConvenienceEnum convenience) {
        this.stayDetailFeature = stayDetailFeature;
        this.convenience = convenience;
    }
}
