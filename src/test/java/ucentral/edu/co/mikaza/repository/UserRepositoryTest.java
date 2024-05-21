package ucentral.edu.co.mikaza.repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ucentral.edu.co.mikaza.model.User;
import ucentral.edu.co.mikaza.util.UserUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;

@SpringBootTest
 class UserRepositoryTest {
    @Mock
    private UserRepository userRepository;

    @Test
     void saveUserTest() {
        given(userRepository.save(UserUtil.USER_MODEL)).willReturn(UserUtil.USER_MODEL);
        User user = userRepository.save(UserUtil.USER_MODEL);

        assertNotNull(user);
    }

    @Test
     void findByVerificationCodeTest() {
        given(userRepository.findByVerificationCode(UserUtil.VERIFICATION_CODE)).willReturn(UserUtil.USER_MODEL);
        User user = userRepository.findByVerificationCode(UserUtil.VERIFICATION_CODE);

        assertNotNull(user);
    }

    @Test
     void findByEmailTest() {
        given(userRepository.findByEmail(UserUtil.EMAIL)).willReturn(UserUtil.USER_MODEL);
        User user = userRepository.findByEmail(UserUtil.EMAIL);

        assertNotNull(user);
    }

    @Test
     void existsByEmailTest() {
        given(userRepository.existsByEmail(UserUtil.EMAIL)).willReturn(true);
        boolean exists = userRepository.existsByEmail(UserUtil.EMAIL);

        assertEquals(true,exists );
    }

    @Test
     void existsByDocumentNumberTest() {
        given(userRepository.existsByDocumentNumber(UserUtil.DOCUMENT_NUMBER)).willReturn(true);
        boolean exists = userRepository.existsByDocumentNumber(UserUtil.DOCUMENT_NUMBER);

        assertEquals(true,exists);
    }
}
