 package com.example.clonepjtairbb.stay.repository;

 import com.example.clonepjtairbb.stay.entity.Stay;
 import com.example.clonepjtairbb.stay.repository.QueryDSL.StayRepositoryCustom;
 import org.springframework.data.jpa.repository.JpaRepository;

 import java.util.List;

 public interface StayRepository extends JpaRepository<Stay, Long> {
  List<Stay> findTop20ByIdIsGreaterThan(Long zero);
}