package ucentral.edu.co.mikaza.controller;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ucentral.edu.co.mikaza.dto.user.LoginDto;
import ucentral.edu.co.mikaza.dto.user.UserDto;
import ucentral.edu.co.mikaza.dto.user.UserInformationDto;
import ucentral.edu.co.mikaza.exception.UserException;
import ucentral.edu.co.mikaza.service.UserService;

import java.io.UnsupportedEncodingException;

@AllArgsConstructor
@RequestMapping("/api/user")
@RestController
@Slf4j
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class UserController {
    private final UserService userService;

    @PostMapping(path = "/createUser",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto, HttpServletRequest request) throws UserException, MessagingException, UnsupportedEncodingException {
        return new ResponseEntity(userService.createUser(userDto, request), HttpStatus.CREATED);
    }

    @GetMapping(path = "/verifyUser/{verificationCode}")
    public ModelAndView verifyUser(@PathVariable String verificationCode) throws UserException {
        String templateName = userService.verifyUser(verificationCode);
        ModelAndView modelAndView = new ModelAndView(templateName);

        return modelAndView;
    }

    @GetMapping(path = "/getUser/{email}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInformationDto> getUser(@PathVariable String email) throws UserException {
        return new ResponseEntity(userService.getUser(email), HttpStatus.OK);
    }

    @PostMapping(path = "/loginUser",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> loginUser(@Valid @RequestBody LoginDto loginDto) throws UserException {
        return new ResponseEntity(userService.loginUser(loginDto), HttpStatus.OK);
    }
}
