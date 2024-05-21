package ucentral.edu.co.mikaza.service;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import ucentral.edu.co.mikaza.dto.user.LoginDto;
import ucentral.edu.co.mikaza.dto.user.UserDto;
import ucentral.edu.co.mikaza.dto.user.UserInformationDto;
import ucentral.edu.co.mikaza.exception.UserException;

import java.io.UnsupportedEncodingException;

public interface UserService {
    UserDto createUser(UserDto userDto, HttpServletRequest request) throws UserException, MessagingException, UnsupportedEncodingException;
    String verifyUser(String verificationCode);
    UserInformationDto getUser(String email) throws UserException;
    UserDto loginUser(LoginDto loginDto) throws UserException;
}
