// package com.example.clonepjtairbb.stay.repository;
//
// import com.example.clonepjtairbb.stay.entity.Stay;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.http.ResponseEntity;
//
// public interface StayRepository extends JpaRepository<Stay, Long> {
// 	public ResponseEntity<?> getAllStay();
//
// 	//Reservation Service에서 StayId와 예약 날짜,시간을 넘겨주어서 예약 가능한지 여부 확인하는 용도
// 	public Boolean checkStayReservationOkay();
//
// 	//ReservationRepository에 Reservation을 등록하면, 등록한 시간을 넘겨주어서 Stay Entity의 availability를 수정해주기 위한 용도
// 	public void updateStayAvailability();
// }
