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
import ucentral.edu.co.mikaza.controller.UserController;
import ucentral.edu.co.mikaza.dto.user.UserDto;
import ucentral.edu.co.mikaza.dto.user.UserInformationDto;
import ucentral.edu.co.mikaza.exception.UserException;
import ucentral.edu.co.mikaza.service.UserService;
import ucentral.edu.co.mikaza.util.UserUtilTest;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Test
    public void createUserTestOk() throws MessagingException, UnsupportedEncodingException, UserException {
        when(userService.createUser(UserUtilTest.USER_DTO, request)).thenReturn(UserUtilTest.USER_DTO);

        ResponseEntity<UserDto> response = userController.createUser(UserUtilTest.USER_DTO, request);

        verify(userService).createUser(eq(UserUtilTest.USER_DTO), eq(request));

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode().value());
    }

    @Test
    public void createUserTestNotOk() throws MessagingException, UnsupportedEncodingException {
        try {
            ResponseEntity<UserDto> response = userController.createUser(UserUtilTest.USER_DTO_INCORRECT, request);
        } catch (UserException ex) {
            assertEquals(UserUtilTest.NAME_NOT_NULL, ex.getMessage());
        }
    }

    @Test
    public void verifyUserTestOk() throws UserException {
        when(userService.verifyUser(UserUtilTest.VERIFICATION_CODE)).thenReturn(UserUtilTest.EMAIL_VERIFIED_TEMPLATE);

        ModelAndView response = userController.verifyUser(UserUtilTest.VERIFICATION_CODE);

        verify(userService).verifyUser(eq(UserUtilTest.VERIFICATION_CODE));

        assertNotNull(response);
    }

    @Test
    public void verifyUserTestNotOk() {
        try {
            ModelAndView response = userController.verifyUser(UserUtilTest.VERIFICATION_CODE);
        } catch (UserException ex) {
            assertEquals(UserUtilTest.EMAIL_NOT_FOUND, ex.getMessage());
        }
    }

    @Test
    public void getUserTestOk() throws UserException {
        when(userService.getUser(UserUtilTest.EMAIL)).thenReturn(UserUtilTest.USER_INFORMATION_DTO);

        ResponseEntity<UserInformationDto> response = userController.getUser(UserUtilTest.EMAIL);

        verify(userService).getUser(eq(UserUtilTest.EMAIL));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void getUserTestNotOk() {
        try {
            ResponseEntity<UserInformationDto> response = userController.getUser(UserUtilTest.EMAIL);
        } catch (UserException ex) {
            assertEquals(UserUtilTest.EMAIL_NOT_FOUND, ex.getMessage());
        }
    }

    @Test
    public void loginUserTestOk() throws UserException {
        when(userService.loginUser(UserUtilTest.LOGIN_DTO)).thenReturn(UserUtilTest.USER_DTO);

        ResponseEntity<UserDto> response = userController.loginUser(UserUtilTest.LOGIN_DTO);

        verify(userService).loginUser(eq(UserUtilTest.LOGIN_DTO));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void loginUserTestNotOk() {
        try {
            ResponseEntity<UserDto> response = userController.loginUser(UserUtilTest.LOGIN_DTO_INCORRECT);
        } catch (UserException ex) {
            assertEquals(UserUtilTest.PASSWORD_INCORRECT, ex.getMessage());
        }
    }
}
