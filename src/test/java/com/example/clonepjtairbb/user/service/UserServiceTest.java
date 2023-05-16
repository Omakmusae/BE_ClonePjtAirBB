// package com.example.clonepjtairbb.user.service;
// import com.example.clonepjtairbb.common.utils.JwtUtil;
// import com.example.clonepjtairbb.user.dto.SignInRequest;
// import com.example.clonepjtairbb.user.dto.SignUpRequest;
// import com.example.clonepjtairbb.user.entity.User;
// import com.example.clonepjtairbb.user.repository.UserRepository;
// import jakarta.servlet.http.Cookie;
// import jakarta.servlet.http.HttpServletResponse;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import org.springframework.test.util.ReflectionTestUtils;
// import org.springframework.transaction.annotation.Transactional;
//
// import java.util.Optional;
//
// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.Mockito.*;
// @ExtendWith(MockitoExtension.class)
// @Transactional
// @SpringBootTest
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// class UserServiceTest {
//
// 	private UserService userService;
// 	@Mock
// 	private UserRepository userRepository;
// 	@Mock
// 	private JwtUtil jwtUtil;
//
// 	@Mock
// 	private HttpServletResponse httpServletResponse;
//
// 	@BeforeEach
// 	public void setUp() {
// 		MockitoAnnotations.openMocks(this);
// 		userService = new UserService(userRepository, new JwtUtil());
// 		ReflectionTestUtils.setField(userService, "ADMIN_TOKEN", "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC");
// 	}
//
// 	@Test
// 	public void signup_ValidSignUpRequest_SuccessfullyRegistersUser() {
// 		// Arrange
// 		SignUpRequest signUpRequest = new SignUpRequest("te123", "password", "TestUser");
// 		User mockUser = new User("test@example.com", "password", "TestUser");
//
// 		when(userRepository.findByEmail(signUpRequest.getEmail())).thenReturn(Optional.empty());
// 		when(userRepository.save(any(User.class))).thenReturn(mockUser);
//
// 		// Act
// 		userService.signup(signUpRequest);
//
// 		// Assert
// 		verify(userRepository, times(1)).findByEmail(signUpRequest.getEmail());
// 		verify(userRepository, times(1)).save(any(User.class));
// 	}
//
// 	@Test
// 	public void signup_DuplicateEmail_ThrowsIllegalArgumentException() {
// 		// Arrange
// 		SignUpRequest signUpRequest = new SignUpRequest("test@example.com", "password", "TestUser");
// 		User existingUser = new User("test@example.com", "password", "ExistingUser");
//
// 		when(userRepository.findByEmail(signUpRequest.getEmail())).thenReturn(Optional.of(existingUser));
//
// 		// Act and Assert
// 		assertThrows(IllegalArgumentException.class, () -> userService.signup(signUpRequest));
//
// 		verify(userRepository, times(1)).findByEmail(signUpRequest.getEmail());
// 		verify(userRepository, never()).save(any(User.class));
// 	}
// 	//
// 	// @Test
// 	// public void signIn_ValidSignInRequestWithMatchingCredentials_CreatesTokenAndAddsToResponseCookie() {
// 	// 	// Arrange
// 	// 	SignInRequest signInRequest = new SignInRequest("test@example.com", "password");
// 	// 	User mockUser = new User("test@example.com", "password", "TestUser");
// 	// 	String expectedToken = "sampleToken";
// 	//
// 	// 	when(userRepository.findByEmail(signInRequest.getEmail())).thenReturn(Optional.of(mockUser));
// 	// 	when(httpServletResponse.addCookie(any(Cookie.class))).thenReturn(true);
// 	// 	when(jwtUtil.createToken(signInRequest.getEmail(), mockUser.getNickname())).thenReturn(expectedToken);
// 	//
// 	// 	// Act
// 	// 	userService.signIn(signInRequest, httpServletResponse);
// 	//
// 	// 	// Assert
// 	// 	verify(userRepository, times(1)).findByEmail(signInRequest.getEmail());
// 	// 	verify(httpServletResponse, times(1)).addCookie(any(Cookie.class));
// 	//
// 	// 	// Verify if the cookie contains the expected token
// 	// 	Cookie addedCookie = verifyCookieAdded(httpServletResponse);
// 	// 	assertNotNull(addedCookie);
// 	// }
//
// }