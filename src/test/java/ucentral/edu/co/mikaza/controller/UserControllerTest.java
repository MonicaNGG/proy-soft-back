package ucentral.edu.co.mikaza.controller;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;
import ucentral.edu.co.mikaza.dto.user.UserDto;
import ucentral.edu.co.mikaza.dto.user.UserInformationDto;
import ucentral.edu.co.mikaza.exception.UserException;
import ucentral.edu.co.mikaza.service.UserService;
import ucentral.edu.co.mikaza.util.UserUtil;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
 class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Test
     void createUserTestOk() throws MessagingException, UnsupportedEncodingException, UserException {
        when(userService.createUser(UserUtil.USER_DTO, request)).thenReturn(UserUtil.USER_DTO);

        ResponseEntity<UserDto> response = userController.createUser(UserUtil.USER_DTO, request);

        verify(userService).createUser(UserUtil.USER_DTO, request);

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode().value());
    }

    @Test
     void createUserTestNotOk() throws MessagingException, UnsupportedEncodingException {
        try {
            userController.createUser(UserUtil.USER_DTO_INCORRECT, request);
        } catch (UserException ex) {
            assertEquals(UserUtil.NAME_NOT_NULL, ex.getMessage());
        }
    }

    @Test
     void verifyUserTestOk() throws UserException {
        when(userService.verifyUser(UserUtil.VERIFICATION_CODE)).thenReturn(UserUtil.EMAIL_VERIFIED_TEMPLATE);

        ModelAndView response = userController.verifyUser(UserUtil.VERIFICATION_CODE);

        verify(userService).verifyUser(UserUtil.VERIFICATION_CODE);

        assertNotNull(response);
    }

    @Test
     void verifyUserTestNotOk() {
        try {
            userController.verifyUser(UserUtil.VERIFICATION_CODE);
        } catch (UserException ex) {
            assertEquals(UserUtil.EMAIL_NOT_FOUND, ex.getMessage());
        }
    }

    @Test
     void getUserTestOk() throws UserException {
        when(userService.getUser(UserUtil.EMAIL)).thenReturn(UserUtil.USER_INFORMATION_DTO);

        ResponseEntity<UserInformationDto> response = userController.getUser(UserUtil.EMAIL);

        verify(userService).getUser(UserUtil.EMAIL);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
     void getUserTestNotOk() {
        try {
            userController.getUser(UserUtil.EMAIL);
        } catch (UserException ex) {
            assertEquals(UserUtil.EMAIL_NOT_FOUND, ex.getMessage());
        }
    }

    @Test
     void loginUserTestOk() throws UserException {
        when(userService.loginUser(UserUtil.LOGIN_DTO)).thenReturn(UserUtil.USER_DTO);

        ResponseEntity<UserDto> response = userController.loginUser(UserUtil.LOGIN_DTO);

        verify(userService).loginUser(UserUtil.LOGIN_DTO);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
     void loginUserTestNotOk() {
        try {
            userController.loginUser(UserUtil.LOGIN_DTO_INCORRECT);
        } catch (UserException ex) {
            assertEquals(UserUtil.PASSWORD_INCORRECT, ex.getMessage());
        }
    }
}
