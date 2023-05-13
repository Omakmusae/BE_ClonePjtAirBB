package com.example.clonepjtairbb.stay.controller;

import com.example.clonepjtairbb.common.security.UserDetailsImpl;
import com.example.clonepjtairbb.common.utils.Message;
import com.example.clonepjtairbb.stay.dto.RegisterStayRequest;
import com.example.clonepjtairbb.stay.dto.StayListResponse;
import com.example.clonepjtairbb.stay.service.StayService;
import com.example.clonepjtairbb.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/stay")
public class StayController {
    private final StayService stayService;

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
        @AuthenticationPrincipal UserDetailsImpl userDetails
    ){
        User user = userDetails.getUser();
        return stayService.getAllStay(user);
    }

}
