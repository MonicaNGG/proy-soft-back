package ucentral.edu.co.mikaza.repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ucentral.edu.co.mikaza.model.User;
import ucentral.edu.co.mikaza.repository.UserRepository;
import ucentral.edu.co.mikaza.util.UserUtilTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class UserRepositoryTest {
    @Mock
    private UserRepository userRepository;

    @Test
    public void saveUserTest() {
        given(userRepository.save(UserUtilTest.USER_MODEL)).willReturn(UserUtilTest.USER_MODEL);
        User user = userRepository.save(UserUtilTest.USER_MODEL);

        assertNotNull(user);
    }

    @Test
    public void findByVerificationCodeTest() {
        given(userRepository.findByVerificationCode(UserUtilTest.VERIFICATION_CODE)).willReturn(UserUtilTest.USER_MODEL);
        User user = userRepository.findByVerificationCode(UserUtilTest.VERIFICATION_CODE);

        assertNotNull(user);
    }

    @Test
    public void findByEmailTest() {
        given(userRepository.findByEmail(UserUtilTest.EMAIL)).willReturn(UserUtilTest.USER_MODEL);
        User user = userRepository.findByEmail(UserUtilTest.EMAIL);

        assertNotNull(user);
    }

    @Test
    public void existsByEmailTest() {
        given(userRepository.existsByEmail(UserUtilTest.EMAIL)).willReturn(true);
        boolean exists = userRepository.existsByEmail(UserUtilTest.EMAIL);

        assertNotNull(exists);
    }

    @Test
    public void existsByDocumentNumberTest() {
        given(userRepository.existsByDocumentNumber(UserUtilTest.DOCUMENT_NUMBER)).willReturn(true);
        boolean exists = userRepository.existsByDocumentNumber(UserUtilTest.DOCUMENT_NUMBER);

        assertNotNull(exists);
    }
}
