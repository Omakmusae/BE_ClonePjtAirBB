// package com.example.clonepjtairbb.stay.repository;
//
// import static com.example.clonepjtairbb.common.enums.CityEnum.*;
// import static com.example.clonepjtairbb.common.enums.CountryEnum.*;
// import static com.example.clonepjtairbb.common.enums.StayTypeEnum.*;
// import static com.example.clonepjtairbb.user.entity.QUser.*;
// import static org.assertj.core.api.Fail.fail;
// import static org.junit.jupiter.api.Assertions.*;
//
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.util.stream.IntStream;
//
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.TestPropertySource;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.test.context.web.WebAppConfiguration;
//
// import com.example.clonepjtairbb.common.config.JasyptConfig;
// import com.example.clonepjtairbb.common.utils.JwtUtil;
// import com.example.clonepjtairbb.stay.entity.Stay;
// import com.example.clonepjtairbb.stay.entity.StayDetailFeature;
// import com.example.clonepjtairbb.user.entity.User;
//
// @ExtendWith(SpringExtension.class)
// @DataJpaTest
// class StayRepositoryTest {
//
// 	@Autowired
// 	StayRepository stayRepository;
//
//
//
//
// 	@Test
// 	public void test() {
// 		User host = new User("tejw@test.com", "1234", "1df34");
//
// 		Stay stay = new Stay(host, "제목 테스트", "내용 테스트", "URL", KOREA, SEOUL, 123, ROOM);
// 		stayRepository.save(stay);
//
// 	}
//
//
//
// }