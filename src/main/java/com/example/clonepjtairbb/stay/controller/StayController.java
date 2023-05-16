
package com.example.clonepjtairbb.stay.controller;

import com.example.clonepjtairbb.common.security.UserDetailsImpl;
import com.example.clonepjtairbb.common.utils.Message;
import com.example.clonepjtairbb.stay.dto.*;
import com.example.clonepjtairbb.stay.entity.Stay;
import com.example.clonepjtairbb.stay.service.StayService;
import com.example.clonepjtairbb.user.entity.User;
import com.example.clonepjtairbb.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/stay")
public class StayController {
    private final StayService stayService;
    private final UserRepository userRepository;

    //숙소 등록
    @PostMapping
    public ResponseEntity<Message> registerNewStay(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @RequestBody RegisterStayRequest registerStayRequest
    ){
        User user = userDetails.getUser();
        return stayService.registerNewStay(user, registerStayRequest);
    }

    //전체 숙소 조회(no filter)
    @GetMapping
    public ResponseEntity<List<StayListResponse>> getAllStay(
    ){
        return stayService.getAllStay();
    }

    //숙소 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<StayOneResponse> getStayById(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(stayService.getStayById(id), HttpStatus.OK);
    }



    @GetMapping("/search")
    public ResponseEntity<List<StayListResponse>> getSearchItem(SearchOptionRequest request) {
        return stayService.getSearchItem(request);
    }

    @GetMapping("/book/{stayId}")
    public ResponseEntity<List<BookedDateListResponse>> getBookedDateList(
            @PathVariable Long stayId
    ){
        return stayService.getStayBookedDateList(stayId);
    }


    @PostMapping("/book/{stayId}")
    public ResponseEntity<Message> makeStayReservation(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long stayId,
            @RequestBody ReservationRequest reservationRequest
    ){
        User user = userDetails.getUser();
        if (user == null){ user = userRepository.findById(1L).orElseThrow(()-> new NullPointerException("test없음"));}
        if (reservationRequest.getCheckoutDate() == null || reservationRequest.getCheckinDate() == null){
            throw new IllegalArgumentException("날짜를 선택하지 않았습니다.");
        }
        return stayService.makeStayReservation(user, stayId, reservationRequest);
    }
}

