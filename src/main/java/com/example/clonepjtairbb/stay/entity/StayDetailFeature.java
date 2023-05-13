package com.example.clonepjtairbb.stay.entity;

import com.example.clonepjtairbb.common.enums.BedTypeEnum;
import com.example.clonepjtairbb.common.enums.DescTagEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class StayDetailFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Stay stay;

    private Integer numBed;

    private BedTypeEnum bedType;

    private Boolean isAlone;

    @OneToMany
    private List<Convenience> convenienceList;

    @OneToMany(fetch = FetchType.EAGER)
    private List<ImageUrl> imaUrlList;

    private DescTagEnum descTag;

    private Integer checkInAfter;
    private Integer checkOutBefore;
    private Integer maxGroupNum;
}
