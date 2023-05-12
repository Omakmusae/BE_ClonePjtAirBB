package com.example.clonepjtairbb.stay.service;

import com.example.clonepjtairbb.dependency.StayServiceInterface;
import com.example.clonepjtairbb.stay.entity.Stay;
import com.example.clonepjtairbb.stay.repository.StayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public class StayService implements StayServiceInterface{

    private final StayRepository stayRepository;
    @Transactional
    public ResponseEntity<List<Stay>> getAllStay() {
        return null;

    }
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
