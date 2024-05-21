package ucentral.edu.co.mikaza.service;

import jakarta.mail.MessagingException;
import ucentral.edu.co.mikaza.dto.user.UserDto;

import java.io.UnsupportedEncodingException;

public interface EmailService {
    void sendVerificationMail(UserDto userDto, String siteURL) throws MessagingException, UnsupportedEncodingException;
}
