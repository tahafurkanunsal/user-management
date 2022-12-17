package tahafurkan.sandbox.usermanagement.service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import tahafurkan.sandbox.usermanagement.dto.UserDto;
import tahafurkan.sandbox.usermanagement.entities.Address;
import tahafurkan.sandbox.usermanagement.entities.User;
import tahafurkan.sandbox.usermanagement.exception.UsernameIsInUseException;
import tahafurkan.sandbox.usermanagement.exception.UsernameUnavailableException;
import tahafurkan.sandbox.usermanagement.repository.UserRepository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;


@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /*@Test
    void create() {
        User user = new User(1,
                "Taha Furkan",
                "Unsal",
                "t.furkanunsal.gmail.com",
                "TFU",
                Collections.singletonList(new Address(1, "Home", "Istanbul", "Bahcelievler")));
        Mockito.when(userRepository.save(user)).thenReturn(user);
        assertThat(userService.create(user));
    }*/

    @Test
    void checkUsername_GivenUsernameObama_ThrowsException() {
        assertThrows(UsernameUnavailableException.class, () -> {
            String username = "obama";
            userService.checkUsername(username);
        });
    }

    @Test
    void checkUsername_GivenUsernameUppercaseObama_ThrowsException() {
        assertThrows(UsernameUnavailableException.class, () -> {
            String username = "Obama";
            userService.checkUsername(username);
        });
    }

    @Test
    void checkUsername_GivenUsernameAlreadyExistInDb_ThrowsException() {
        assertThrows(UsernameIsInUseException.class, () -> {
            String username = "taha.furkan";
            given(userRepository.existsByUsername(username)).willReturn(true);
            userService.checkUsername(username);
        });
    }

    @Test
    void checkUsername_GivenUsernameDoesNotExistInDb_DoNothing() {
        String username = "another-username";
        given(userRepository.existsByUsername(username)).willReturn(false);
        userService.checkUsername(username);
    }

}
