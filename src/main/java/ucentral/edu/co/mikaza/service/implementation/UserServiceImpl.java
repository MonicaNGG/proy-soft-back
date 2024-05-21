package ucentral.edu.co.mikaza.service.implementation;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;
import ucentral.edu.co.mikaza.dto.user.LoginDto;
import ucentral.edu.co.mikaza.dto.user.UserDto;
import ucentral.edu.co.mikaza.dto.user.UserInformationDto;
import ucentral.edu.co.mikaza.exception.UserException;
import ucentral.edu.co.mikaza.mapper.UserInformationMapper;
import ucentral.edu.co.mikaza.mapper.UserMapper;
import ucentral.edu.co.mikaza.model.User;
import ucentral.edu.co.mikaza.repository.UserRepository;
import ucentral.edu.co.mikaza.service.EmailService;
import ucentral.edu.co.mikaza.service.UserService;
import ucentral.edu.co.mikaza.util.UserValidateUtil;

import java.io.UnsupportedEncodingException;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final EmailService emailService;

    @Override
    @Transactional
    public UserDto createUser(UserDto userDto, HttpServletRequest request) throws UserException, MessagingException, UnsupportedEncodingException {
        if (userRepository.existsByEmail(userDto.getEmail())) throw new UserException(UserValidateUtil.EMAIL_UNIQUE);
        if (userRepository.existsByDocumentNumber(userDto.getDocumentNumber())) throw new UserException(UserValidateUtil.DOCUMENT_NUMBER_UNIQUE);

        String randomCode = RandomString.make(64);
        userDto.setVerificationCode(randomCode);
        userDto.setEnabled(false);

        emailService.sendVerificationMail(userDto, getSiteURL(request));

        return UserMapper.modelToDto(userRepository.save(UserMapper.dtoToModel(userDto)));
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();

        return siteURL.replace(request.getServletPath(), "");
    }

    @Override
    @Transactional
    public String verifyUser(String verificationCode) throws UserException{
        User user = userRepository.findByVerificationCode(verificationCode);

        if (user != null && !user.isEnabled()) {
            user.setVerificationCode(null);
            user.setEnabled(true);
            userRepository.save(user);

            return "email-verified";
        }

        return "email-not-verified";
    }

    @Override
    @Transactional
    public UserInformationDto getUser(String email) throws UserException {
        User user = userRepository.findByEmail(email);

        if (user == null) throw new UserException(UserValidateUtil.EMAIL_NOT_FOUND);

        return UserInformationMapper.modelToDto(user);
    }

    @Override
    @Transactional
    public UserDto loginUser(LoginDto loginDto) throws UserException {
        User user = userRepository.findByEmail(loginDto.getEmail());

        if (user == null) throw new UserException(UserValidateUtil.EMAIL_NOT_FOUND);
        if (!user.isEnabled()) throw new UserException(UserValidateUtil.EMAIL_NOT_VERIFIED);
        if (!user.getPassword().equals(loginDto.getPassword())) throw new UserException(UserValidateUtil.PASSWORD_INCORRECT);

        return UserMapper.modelToDto(user);
    }
}
