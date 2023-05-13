 package com.example.clonepjtairbb.stay.service;

 import com.example.clonepjtairbb.common.utils.Message;
 import com.example.clonepjtairbb.stay.dto.RegisterStayRequest;
 import com.example.clonepjtairbb.stay.dto.StayListResponse;
 import com.example.clonepjtairbb.stay.entity.Convenience;
 import com.example.clonepjtairbb.stay.entity.ImageUrl;
 import com.example.clonepjtairbb.stay.entity.Stay;
 import com.example.clonepjtairbb.stay.entity.StayDetailFeature;
 import com.example.clonepjtairbb.stay.repository.ConvenienceRepository;
 import com.example.clonepjtairbb.stay.repository.ImageUrlRepository;
 import com.example.clonepjtairbb.stay.repository.StayDetailFeatureRepository;
 import com.example.clonepjtairbb.stay.repository.StayRepository;
 import com.example.clonepjtairbb.user.entity.User;
 import lombok.RequiredArgsConstructor;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import java.util.List;
 import java.util.stream.Collectors;

 @Service
 @RequiredArgsConstructor
 public class StayService{
     private final StayRepository stayRepository;
     private final StayDetailFeatureRepository stayDetailFeatureRepository;
     private final ImageUrlRepository imageUrlRepository;
     private final ConvenienceRepository convenienceRepository;

     @Transactional
     public ResponseEntity<Message> registerNewStay(User user, RegisterStayRequest registerStayRequest) {
         //request parsing
         Stay newStay = registerStayRequest.toStayEntity(user);
         StayDetailFeature detailFeature = registerStayRequest.toStayDetailFeatureEntity(newStay);
         List<ImageUrl> imageUrlList = registerStayRequest.toImageUrlList(detailFeature);
         List<Convenience> convenienceList = registerStayRequest.toConvenienceList(detailFeature);

         //연관관계 세팅 (image랑 convenience는 requestDto의 메서드에서 세팅해주었음)
         newStay.setStayDetailFeature(detailFeature);

         //엔티티들 저장
         stayRepository.save(newStay);
         stayDetailFeatureRepository.save(detailFeature);
         imageUrlRepository.saveAll(imageUrlList);
         convenienceRepository.saveAll(convenienceList);

         return new ResponseEntity<>(new Message("숙소 등록 성공"), HttpStatus.CREATED);
     }

     @Transactional
     public ResponseEntity<List<StayListResponse>> getAllStay(User user) {
         return new ResponseEntity<>(
                 stayRepository.findAll()
                         .stream()
                         .map(StayListResponse::new)
                         .collect(Collectors.toList()),
                 HttpStatus.OK
         );

     }


















     /////////////////////////////////////////////////////////////////////

     @Transactional
     public Boolean checkStayReservationOkay() {
         return true;
     }

     @Transactional
     public void updateStayAvailability() {

     }

     @Transactional
     public Stay getStayById() {
         return null;
     }

 }
