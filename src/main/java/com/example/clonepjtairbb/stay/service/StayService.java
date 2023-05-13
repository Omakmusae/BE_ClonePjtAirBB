 package com.example.clonepjtairbb.stay.service;

 import com.example.clonepjtairbb.common.utils.Message;
 import com.example.clonepjtairbb.dependency.StayServiceInterface;
 import com.example.clonepjtairbb.stay.dto.RegisterStayDto;
 import com.example.clonepjtairbb.stay.dto.StayListResponseDto;
 import com.example.clonepjtairbb.stay.entity.Stay;
 import com.example.clonepjtairbb.stay.repository.StayRepository;
 import com.example.clonepjtairbb.user.entity.User;
 import lombok.RequiredArgsConstructor;
 import org.springframework.http.ResponseEntity;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import java.util.List;

 @Service
 @RequiredArgsConstructor
 public class StayService{

     private final StayRepository stayRepository;


     @Transactional
     public ResponseEntity<Message> registerNewStay(User user, RegisterStayDto registerStayDto) {
         return null;
     }

     @Transactional
     public ResponseEntity<List<StayListResponseDto>> getAllStay(User user) {
         return null;

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
