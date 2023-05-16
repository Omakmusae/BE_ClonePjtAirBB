// package com.example.clonepjtairbb.stay.service;
// import com.example.clonepjtairbb.stay.dto.SearchOptionRequest;
// import com.example.clonepjtairbb.stay.dto.StayListResponse;
// import com.example.clonepjtairbb.stay.entity.Stay;
// import com.example.clonepjtairbb.stay.repository.StayRepository;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
//
// import java.util.ArrayList;
// import java.util.List;
//
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.*;
//
// @ExtendWith(MockitoExtension.class) // Mockito를 사용함을 명시적으로 알립니다.
// public class StayServiceTest {
//
// 	private StayService stayService;
//
// 	@Mock
// 	private StayRepository stayRepository;
//
// 	@BeforeEach
// 	public void setUp() {
// 		MockitoAnnotations.openMocks(this);
// 		stayService = new StayService(stayRepository);
// 	}
//
// 	@Test
// 	public void getSearchItem_ValidSearchOptionRequest_ReturnsStayListResponse() {
// 		// Arrange
// 		SearchOptionRequest searchOptionRequest = new SearchOptionRequest();
// 		// Set the data for the searchOptionRequest as needed
//
// 		// Create a list of Stay objects to be returned by the stayRepository
// 		List<Stay> stayList = new ArrayList<>();
// 		// Add Stay objects to stayList as needed
//
// 		// Mock the behavior of stayRepository.findBySearchOption()
// 		when(stayRepository.findBySearchOption(searchOptionRequest)).thenReturn(stayList);
//
// 		// Act
// 		ResponseEntity<List<StayListResponse>> responseEntity = stayService.getSearchItem(searchOptionRequest);
//
// 		// Assert
// 		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
// 		assertEquals(stayList.size(), responseEntity.getBody().size());
// 		// Add more assertions as needed
//
// 		// Verify that stayRepository.findBySearchOption() was called once
// 		verify(stayRepository, times(1)).findBySearchOption(searchOptionRequest);
// 	}
// }
