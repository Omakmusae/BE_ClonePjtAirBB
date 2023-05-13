 package com.example.clonepjtairbb.stay.entity;

 import com.example.clonepjtairbb.common.enums.CityEnum;
 import com.example.clonepjtairbb.common.enums.CountryEnum;
 import com.example.clonepjtairbb.common.enums.StayTypeEnum;
 import com.example.clonepjtairbb.user.entity.User;
 import jakarta.persistence.*;

 @Entity
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






 }
