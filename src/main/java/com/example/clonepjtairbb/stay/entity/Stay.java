 package com.example.clonepjtairbb.stay.entity;

 import com.example.clonepjtairbb.common.enums.CityEnum;
 import com.example.clonepjtairbb.common.enums.CountryEnum;
 import com.example.clonepjtairbb.common.enums.StayTypeEnum;
 import com.example.clonepjtairbb.user.entity.User;
 import jakarta.persistence.*;
 import lombok.Builder;
 import lombok.Getter;
 import lombok.NoArgsConstructor;

 @Entity
 @Getter
 @NoArgsConstructor
 public class Stay {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @ManyToOne
     private User host;

     private String title;

     private String content;

     private String thumbnailURL;

     private CountryEnum country;

     private CityEnum city;

     private Integer costPerDay;

     private StayTypeEnum stayType;

     @OneToOne
     private StayDetailFeature stayDetailFeature;

     public void setStayDetailFeature(StayDetailFeature stayDetailFeature){ this.stayDetailFeature = stayDetailFeature;}


     @Builder
     public Stay(
             User host, String title, String content, String thumbnailURL, CountryEnum country, CityEnum city,
             Integer costPerDay, StayTypeEnum stayType
     ) {
         this.host = host;
         this.title = title;
         this.content = content;
         this.thumbnailURL = thumbnailURL;
         this.country = country;
         this.city = city;
         this.costPerDay = costPerDay;
         this.stayType = stayType;
     }
 }
