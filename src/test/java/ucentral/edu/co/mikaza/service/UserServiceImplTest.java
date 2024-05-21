package ucentral.edu.co.mikaza.service;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ucentral.edu.co.mikaza.dto.user.UserDto;
import ucentral.edu.co.mikaza.dto.user.UserInformationDto;
import ucentral.edu.co.mikaza.exception.UserException;
import ucentral.edu.co.mikaza.repository.UserRepository;
import ucentral.edu.co.mikaza.service.implementation.UserServiceImpl;
import ucentral.edu.co.mikaza.util.UserUtilTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;

    //@Test
   // public void createUserTestOk() throws MessagingException, UnsupportedEncodingException, UserException {
     //   given(userRepository.existsByEmail(UserUtilTest.USER_DTO.getEmail())).willReturn(false);
      //  given(userRepository.existsByDocumentNumber(UserUtilTest.USER_DTO.getDocumentNumber())).willReturn(false);
    //    given(userRepository.save(UserUtilTest.USER_MODEL)).willReturn(UserUtilTest.USER_MODEL);

      //  UserDto userDtoSaved = userServiceImpl.createUser(UserUtilTest.USER_DTO, request);

      //  assertEquals(UserUtilTest.EMAIL, userDtoSaved.getEmail());
    //    assertEquals(UserUtilTest.DOCUMENT_NUMBER, userDtoSaved.getDocumentNumber());
    //}

    @Test
    public void createUserTestNotOkOne() {
        given(userRepository.existsByEmail(UserUtilTest.USER_DTO.getEmail())).willReturn(true);

        assertEquals(UserUtilTest.EMAIL_UNIQUE, assertThrows(UserException.class, () -> userServiceImpl.createUser(UserUtilTest.USER_DTO, request)).getMessage());
        assertThrows(UserException.class, () -> userServiceImpl.createUser(UserUtilTest.USER_DTO, request));
    }

    @Test
    public void createUserTestNotOkTwo() {
        given(userRepository.existsByDocumentNumber(UserUtilTest.USER_DTO.getDocumentNumber())).willReturn(true);

        assertEquals(UserUtilTest.DOCUMENT_NUMBER_UNIQUE, assertThrows(UserException.class, () -> userServiceImpl.createUser(UserUtilTest.USER_DTO, request)).getMessage());
        assertThrows(UserException.class, () -> userServiceImpl.createUser(UserUtilTest.USER_DTO, request));
    }

    @Test
    public void verifyUserTestOk() {
        given(userRepository.findByVerificationCode(UserUtilTest.VERIFICATION_CODE)).willReturn(UserUtilTest.USER_MODEL);

        String userVerified = userServiceImpl.verifyUser(UserUtilTest.VERIFICATION_CODE);

        assertEquals(UserUtilTest.EMAIL_VERIFIED_TEMPLATE, userVerified);
    }

    @Test
    public void verifyUserTestNotOk() {
        given(userRepository.findByVerificationCode(UserUtilTest.VERIFICATION_CODE)).willReturn(null);

        String userVerified = userServiceImpl.verifyUser(UserUtilTest.VERIFICATION_CODE);

        assertEquals(UserUtilTest.EMAIL_NOT_VERIFIED_TEMPLATE, userVerified);
    }

    @Test
    public void getUserTestOk() throws UserException {
        given(userRepository.existsByEmail(UserUtilTest.EMAIL)).willReturn(true);
        given(userRepository.findByEmail(UserUtilTest.EMAIL)).willReturn(UserUtilTest.USER_MODEL);

        UserInformationDto userInformationDto = userServiceImpl.getUser(UserUtilTest.EMAIL);

        assertEquals(UserUtilTest.EMAIL, userInformationDto.getEmail());
    }

    @Test
    public void getUserTestNotOk() {
        given(userRepository.existsByEmail(UserUtilTest.EMAIL)).willReturn(false);

        assertEquals(UserUtilTest.EMAIL_NOT_FOUND, assertThrows(UserException.class, () -> userServiceImpl.getUser(UserUtilTest.EMAIL)).getMessage());
        assertThrows(UserException.class, () -> userServiceImpl.getUser(UserUtilTest.EMAIL));
    }

    @Test
    public void loginUserTestOk() throws UserException {
        given(userRepository.existsByEmail(UserUtilTest.EMAIL)).willReturn(true);
        given(userRepository.findByEmail(UserUtilTest.EMAIL)).willReturn(UserUtilTest.USER_MODEL_ENABLED);

        UserDto userDtoSaved = userServiceImpl.loginUser(UserUtilTest.LOGIN_DTO);

        assertEquals(UserUtilTest.EMAIL, userDtoSaved.getEmail());
    }

    @Test
    public void loginUserTestNotOkOne() {
        given(userRepository.existsByEmail(UserUtilTest.EMAIL)).willReturn(false);

        assertEquals(UserUtilTest.EMAIL_NOT_FOUND, assertThrows(UserException.class, () -> userServiceImpl.loginUser(UserUtilTest.LOGIN_DTO)).getMessage());
        assertThrows(UserException.class, () -> userServiceImpl.loginUser(UserUtilTest.LOGIN_DTO));
    }

    @Test
    public void loginUserTestNotOkTwo() {
        given(userRepository.existsByEmail(UserUtilTest.EMAIL)).willReturn(true);
        given(userRepository.findByEmail(UserUtilTest.EMAIL)).willReturn(UserUtilTest.USER_MODEL_NOT_ENABLED);

        assertEquals(UserUtilTest.EMAIL_NOT_VERIFIED, assertThrows(UserException.class, () -> userServiceImpl.loginUser(UserUtilTest.LOGIN_DTO)).getMessage());
        assertThrows(UserException.class, () -> userServiceImpl.loginUser(UserUtilTest.LOGIN_DTO));
    }

    @Test
    public void loginUserTestNotOkThree() {
        given(userRepository.existsByEmail(UserUtilTest.EMAIL)).willReturn(true);
        given(userRepository.findByEmail(UserUtilTest.EMAIL)).willReturn(UserUtilTest.USER_MODEL_ENABLED);

        assertEquals(UserUtilTest.PASSWORD_INCORRECT, assertThrows(UserException.class, () -> userServiceImpl.loginUser(UserUtilTest.LOGIN_DTO_INCORRECT)).getMessage());
        assertThrows(UserException.class, () -> userServiceImpl.loginUser(UserUtilTest.LOGIN_DTO_INCORRECT));
    }
}
