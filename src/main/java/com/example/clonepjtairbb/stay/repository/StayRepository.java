 package com.example.clonepjtairbb.stay.repository;

 import java.util.List;

 import com.example.clonepjtairbb.stay.entity.Stay;

<<<<<<< HEAD
=======
 import com.example.clonepjtairbb.stay.repository.QueryDSL.StayRepositoryCustom;
 import org.springframework.context.annotation.Configuration;
>>>>>>> c24a81511fa96bc063b7af75430377178f86af8d
 import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
 public interface StayRepository extends JpaRepository<Stay, Long>{
=======
 public interface StayRepository extends JpaRepository<Stay, Long>, StayRepositoryCustom {
>>>>>>> c24a81511fa96bc063b7af75430377178f86af8d

  List<Stay> findTop20();
 }
