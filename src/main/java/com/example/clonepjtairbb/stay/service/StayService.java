 package com.example.clonepjtairbb.stay.service;


 import com.example.clonepjtairbb.common.utils.Message;
 import com.example.clonepjtairbb.common.utils.S3Util;
 import com.example.clonepjtairbb.stay.dto.*;
 import com.example.clonepjtairbb.stay.entity.ImageUrl;
 import com.example.clonepjtairbb.stay.entity.Stay;
 import com.example.clonepjtairbb.stay.entity.StayDetailFeature;
 import com.example.clonepjtairbb.stay.repository.*;
 import com.example.clonepjtairbb.stay.repository.QueryDSL.StayRepositoryCustom;
 import com.example.clonepjtairbb.stay.repository.QueryDSL.StayReservationRepositoryCustom;
 import com.example.clonepjtairbb.user.entity.User;
 import lombok.RequiredArgsConstructor;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.beans.factory.annotation.Value;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.cache.annotation.EnableCaching;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;
 import org.springframework.web.multipart.MultipartFile;

 import java.io.File;
 import java.io.FileOutputStream;
 import java.io.IOException;
 import java.util.Calendar;
 import java.util.List;
 import java.util.UUID;
 import java.util.stream.Collectors;

 @Slf4j
 @Service
 @EnableCaching
 @RequiredArgsConstructor
 public class StayService{
     private final StayRepository stayRepository;
     private final StayRepositoryCustom stayRepositoryCustom;
     private final StayDetailFeatureRepository stayDetailFeatureRepository;
     private final ImageUrlRepository imageUrlRepository;
     private final StayReservationRepository stayReservationRepository;
     private final StayReservationRepositoryCustom stayReservationRepositoryCustom;
     private final S3Util s3Util;

     @Transactional
     public ResponseEntity<Message> registerNewStay(User user, RegisterStayRequest registerStayRequest) {

         //request parsing
         Stay newStay = registerStayRequest.toStayEntity(user);
         StayDetailFeature detailFeature = registerStayRequest.toStayDetailFeatureEntity(newStay);
         List<ImageUrl> imageUrlList = registerStayRequest.toImageUrlList(detailFeature);

         //연관관계 세팅 (image랑 convenience는 requestDto의 메서드에서 세팅해주었음)
         newStay.setStayDetailFeature(detailFeature);

         //엔티티들 저장
         stayRepository.save(newStay);
         stayDetailFeatureRepository.save(detailFeature);
         imageUrlRepository.saveAll(imageUrlList);

         return new ResponseEntity<>(new Message("숙소 등록 성공"), HttpStatus.CREATED);
     }

     @Cacheable(value = "getAllStay")
     @Transactional
     public ResponseEntity<List<StayListResponse>> getAllStay() {
         return new ResponseEntity<>(
             stayRepository.findTop60ByIdIsGreaterThan(0L)
                         .stream()
                         .map(StayListResponse::new)
                         .collect(Collectors.toList()),
                 HttpStatus.OK
         );
     }

     @Cacheable(value = "getA")
     @Transactional
     public ResponseEntity<List<StayListResponse>> getSearchItem(SearchOptionRequest request) {
//         List<Stay> stayList = stayRepository.findBySearchOption(cost, title);
         MappedSearchRequest mappedRequest = request.toMappedSearchRequest();
         List<StayListResponse> stayResponseList = stayRepositoryCustom.findBySearchOption(mappedRequest)
                 .stream()
                 .map(StayListResponse::new)
                 .toList();
         return new ResponseEntity<>(stayResponseList, HttpStatus.OK);
     }
     @Transactional(readOnly = true)
     public StayOneResponse getStayById(Long id) {

         Stay stay = loadStayById(id);
         return new StayOneResponse(stay);
     }

     @Transactional
     public ResponseEntity<Message> makeStayReservation(User user, Long stayId, ReservationRequest reservationRequest) {
         Stay stay = loadStayById(stayId);
         if(checkStayReservationAvailable(reservationRequest, stay)){
             stayReservationRepository.save(reservationRequest.toStayReservationEntity(user, stay));
         }
         else{
             throw new IllegalArgumentException("해당 날짜는 예약이 불가능합니다");
         }
         return new ResponseEntity<>(new Message("예약에 성공하였습니다!"), HttpStatus.ACCEPTED);
     }

     @Transactional
     public ResponseEntity<List<BookedDateListResponse>> getStayBookedDateList(Long stayId) {
         Stay stay = loadStayById(stayId);
         List<BookedDateListResponse> responseList = stayReservationRepository.findByStay(stay)
                 .stream()
                 .map(BookedDateListResponse::new)
                 .toList();
         return new ResponseEntity<>(responseList, HttpStatus.OK);
     }

     ///////////////////////////////////////////////////////////////////////

     @Transactional
     public Boolean checkStayReservationAvailable(ReservationRequest reservationRequest, Stay stay) {
         return stayReservationRepositoryCustom.existsOverlappingPreviousReservation(reservationRequest, stay)
                 && !reservationRequest.checkinAsCalendar().before(Calendar.getInstance());
     }
     public Stay loadStayById(Long stayId){
         return stayRepository.findById(stayId).orElseThrow(
                 ()-> new NullPointerException("해당 숙소정보를 찾을 수 없습니다")
         );
     }
 }
