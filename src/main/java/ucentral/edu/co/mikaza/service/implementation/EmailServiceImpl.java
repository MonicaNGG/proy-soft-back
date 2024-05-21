package ucentral.edu.co.mikaza.service.implementation;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import ucentral.edu.co.mikaza.dto.user.UserDto;
import ucentral.edu.co.mikaza.service.EmailService;

import java.io.UnsupportedEncodingException;

@Service
public class EmailServiceImpl implements EmailService {
    @Value("${spring.mail.username}")
    private String mail;

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    public EmailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendVerificationMail(UserDto userDto, String siteURL) throws MessagingException, UnsupportedEncodingException {
        String toAddress = userDto.getEmail();
        String fromAddress = mail;
        String senderName = "Mikaza";
        String subject = "Verifica tu correo electrónico";
        String content = "Hola [[name]], <br>"
                + "<p>Verifica tu cuenta para tener acceso a más funcionalidades en Mikaza <br>"
                + "¡Haz clic en el enlace de abajo para verificar tu correo electrónico!</p>"
                + "<a href=\"[[URL]]\" target=\"_self\">Verifica tu cuenta</a><br>"
                + "<br>Muchas gracias,<br>"
                + "Mikaza.";

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", userDto.getName());
        String verifyURL = siteURL + "/api/user/verifyUser/" + userDto.getVerificationCode();
        content = content.replace("[[URL]]", verifyURL);

        Context contenido = new Context();
        contenido.setVariable("content", content);
        String emailContent = templateEngine.process("email-verification", contenido);

        helper.setText(emailContent, true);

        javaMailSender.send(message);
    }
}
