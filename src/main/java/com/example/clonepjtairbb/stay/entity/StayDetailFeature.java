package com.example.clonepjtairbb.stay.entity;

import com.example.clonepjtairbb.common.enums.BathTypeEnum;
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

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Convenience> convenienceList = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    private List<ImageUrl> imageUrlList = new ArrayList<>();

    private DescTagEnum descTag;

    private Integer checkInAfter;
    private Integer checkOutBefore;
    private Integer maxGroupNum;
    private Boolean hasWIFI = false;
    private Boolean hasTV = false;
    private Boolean hasKITCHEN = false;
    private Boolean hasWASHER = false;
    private Boolean hasPARKINGLOT = false;
    private Boolean hasAIRCONDITION = false;
    private Boolean hasSWIMMINGPOOL = false;
    private Boolean hasBBQGRILL = false;
    private Boolean hasSPORTEQUIPMENT = false;
    private Boolean hasFIRSTAID = false;
    private Boolean hasFIREEXTINGUISHER = false;

    public void addImageUrl(ImageUrl imageUrl){ this.imageUrlList.add(imageUrl); }

    @Builder
    public StayDetailFeature(Stay stay, Integer numBed, BedTypeEnum bedType, Boolean isAlone,
                             DescTagEnum descTag, Integer checkInAfter,
                             Integer checkOutBefore, Integer maxGroupNum, Boolean hasWIFI, Boolean hasTV,
                             Boolean hasKITCHEN, Boolean hasWASHER, Boolean hasPARKINGLOT, Boolean hasAIRCONDITION,
                             Boolean hasSWIMMINGPOOL, Boolean hasBBQGRILL, Boolean hasSPORTEQUIPMENT,
                             Boolean hasFIRSTAID, Boolean hasFIREEXTINGUISHER
    ) {
        this.stay = stay;
        this.numBed = numBed;
        this.bedType = bedType;
        this.isAlone = isAlone;
        this.descTag = descTag;
        this.checkInAfter = checkInAfter;
        this.checkOutBefore = checkOutBefore;
        this.maxGroupNum = maxGroupNum;
        this.hasWIFI = hasWIFI;
        this.hasTV = hasTV;
        this.hasKITCHEN = hasKITCHEN;
        this.hasWASHER = hasWASHER;
        this.hasPARKINGLOT = hasPARKINGLOT;
        this.hasAIRCONDITION = hasAIRCONDITION;
        this.hasSWIMMINGPOOL = hasSWIMMINGPOOL;
        this.hasBBQGRILL = hasBBQGRILL;
        this.hasSPORTEQUIPMENT = hasSPORTEQUIPMENT;
        this.hasFIRSTAID = hasFIRSTAID;
        this.hasFIREEXTINGUISHER = hasFIREEXTINGUISHER;
    }
}
