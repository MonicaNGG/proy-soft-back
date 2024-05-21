package ucentral.edu.co.mikaza.service;

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
import ucentral.edu.co.mikaza.util.UserUtil;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@SpringBootTest
 class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;

    @Test
     void createUserTestNotOkOne() {
        given(userRepository.existsByEmail(UserUtil.USER_DTO.getEmail())).willReturn(true);

        assertEquals(UserUtil.EMAIL_UNIQUE, assertThrows(UserException.class, () -> userServiceImpl.createUser(UserUtil.USER_DTO, request)).getMessage());
        assertThrows(UserException.class, () -> userServiceImpl.createUser(UserUtil.USER_DTO, request));
    }

    @Test
     void createUserTestNotOkTwo() {
        given(userRepository.existsByDocumentNumber(UserUtil.USER_DTO.getDocumentNumber())).willReturn(true);

        assertEquals(UserUtil.DOCUMENT_NUMBER_UNIQUE, assertThrows(UserException.class, () -> userServiceImpl.createUser(UserUtil.USER_DTO, request)).getMessage());
        assertThrows(UserException.class, () -> userServiceImpl.createUser(UserUtil.USER_DTO, request));
    }

    @Test
     void verifyUserTestOk() {
        given(userRepository.findByVerificationCode(UserUtil.VERIFICATION_CODE)).willReturn(UserUtil.USER_MODEL);

        String userVerified = userServiceImpl.verifyUser(UserUtil.VERIFICATION_CODE);

        assertEquals(UserUtil.EMAIL_VERIFIED_TEMPLATE, userVerified);
    }

    @Test
     void verifyUserTestNotOk() {
        given(userRepository.findByVerificationCode(UserUtil.VERIFICATION_CODE)).willReturn(null);

        String userVerified = userServiceImpl.verifyUser(UserUtil.VERIFICATION_CODE);

        assertEquals(UserUtil.EMAIL_NOT_VERIFIED_TEMPLATE, userVerified);
    }

    @Test
     void getUserTestOk() throws UserException {
        given(userRepository.existsByEmail(UserUtil.EMAIL)).willReturn(true);
        given(userRepository.findByEmail(UserUtil.EMAIL)).willReturn(UserUtil.USER_MODEL);

        UserInformationDto userInformationDto = userServiceImpl.getUser(UserUtil.EMAIL);

        assertEquals(UserUtil.EMAIL, userInformationDto.getEmail());
    }

    @Test
     void getUserTestNotOk() {
        given(userRepository.existsByEmail(UserUtil.EMAIL)).willReturn(false);

        assertEquals(UserUtil.EMAIL_NOT_FOUND, assertThrows(UserException.class, () -> userServiceImpl.getUser(UserUtil.EMAIL)).getMessage());
        assertThrows(UserException.class, () -> userServiceImpl.getUser(UserUtil.EMAIL));
    }

    @Test
     void loginUserTestOk() throws UserException {
        given(userRepository.existsByEmail(UserUtil.EMAIL)).willReturn(true);
        given(userRepository.findByEmail(UserUtil.EMAIL)).willReturn(UserUtil.USER_MODEL_ENABLED);

        UserDto userDtoSaved = userServiceImpl.loginUser(UserUtil.LOGIN_DTO);

        assertEquals(UserUtil.EMAIL, userDtoSaved.getEmail());
    }

    @Test
     void loginUserTestNotOkOne() {
        given(userRepository.existsByEmail(UserUtil.EMAIL)).willReturn(false);

        assertEquals(UserUtil.EMAIL_NOT_FOUND, assertThrows(UserException.class, () -> userServiceImpl.loginUser(UserUtil.LOGIN_DTO)).getMessage());
        assertThrows(UserException.class, () -> userServiceImpl.loginUser(UserUtil.LOGIN_DTO));
    }

    @Test
     void loginUserTestNotOkTwo() {
        given(userRepository.existsByEmail(UserUtil.EMAIL)).willReturn(true);
        given(userRepository.findByEmail(UserUtil.EMAIL)).willReturn(UserUtil.USER_MODEL_NOT_ENABLED);

        assertEquals(UserUtil.EMAIL_NOT_VERIFIED, assertThrows(UserException.class, () -> userServiceImpl.loginUser(UserUtil.LOGIN_DTO)).getMessage());
        assertThrows(UserException.class, () -> userServiceImpl.loginUser(UserUtil.LOGIN_DTO));
    }

    @Test
     void loginUserTestNotOkThree() {
        given(userRepository.existsByEmail(UserUtil.EMAIL)).willReturn(true);
        given(userRepository.findByEmail(UserUtil.EMAIL)).willReturn(UserUtil.USER_MODEL_ENABLED);

        assertEquals(UserUtil.PASSWORD_INCORRECT, assertThrows(UserException.class, () -> userServiceImpl.loginUser(UserUtil.LOGIN_DTO_INCORRECT)).getMessage());
        assertThrows(UserException.class, () -> userServiceImpl.loginUser(UserUtil.LOGIN_DTO_INCORRECT));
    }
}
