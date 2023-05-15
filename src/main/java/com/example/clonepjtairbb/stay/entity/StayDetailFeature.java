package com.example.clonepjtairbb.stay.entity;

import com.example.clonepjtairbb.common.enums.BedTypeEnum;
import com.example.clonepjtairbb.common.enums.DescTagEnum;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class StayDetailFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Stay stay;

    private Integer numBed;

    private BedTypeEnum bedType;

    private Boolean isAlone;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Convenience> convenienceList = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    private List<ImageUrl> imageUrlList = new ArrayList<>();

    private DescTagEnum descTag;

    private Integer checkInAfter;
    private Integer checkOutBefore;
    private Integer maxGroupNum;

    public void addImageUrl(ImageUrl imageUrl){ this.imageUrlList.add(imageUrl); }
    public void addConvenience(Convenience convenience){ this.convenienceList.add(convenience); }

    @Builder
    public StayDetailFeature(
            Stay stay, Integer numBed, BedTypeEnum bedType, Boolean isAlone, DescTagEnum descTag,
            Integer checkInAfter, Integer checkOutBefore, Integer maxGroupNum) {
        this.stay = stay;
        this.numBed = numBed;
        this.bedType = bedType;
        this.isAlone = isAlone;
        this.descTag = descTag;
        this.checkInAfter = checkInAfter;
        this.checkOutBefore = checkOutBefore;
        this.maxGroupNum = maxGroupNum;
    }
}
