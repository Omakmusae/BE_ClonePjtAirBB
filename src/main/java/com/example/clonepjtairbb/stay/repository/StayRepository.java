 package com.example.clonepjtairbb.stay.repository;

 import java.util.List;

 import com.example.clonepjtairbb.stay.entity.Stay;

 import org.springframework.data.jpa.repository.JpaRepository;

 public interface StayRepository extends JpaRepository<Stay, Long>{

   List<Stay> findAll();
 }
