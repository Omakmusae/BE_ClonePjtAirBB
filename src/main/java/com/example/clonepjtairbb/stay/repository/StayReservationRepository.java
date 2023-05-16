package com.example.clonepjtairbb.stay.repository;

import com.example.clonepjtairbb.stay.entity.Stay;
import com.example.clonepjtairbb.stay.entity.StayReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StayReservationRepository extends JpaRepository<StayReservation,Long> {
    List<StayReservation> findByStay(Stay stay);
}
