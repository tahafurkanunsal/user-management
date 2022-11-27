package tahafurkan.sandbox.usermanagement.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tahafurkan.sandbox.usermanagement.entities.Address;
import tahafurkan.sandbox.usermanagement.entities.User;
import tahafurkan.sandbox.usermanagement.repository.UserRepository;

import java.lang.reflect.Method;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;
    @Test
    void shouldCheckTheAvailabilityOfTheUsername() throws Throwable {
        Method method = UserService.class.getDeclaredMethod("checkUsername", String.class);
        method.setAccessible(true);
        String username = "Dummy";
        User user = new User();
        user.setUsername(username);

        User availability = userService.create(user);
        assertThat(availability);

    }
    @Test
    void shouldCheckIfUsernameExists() throws Throwable{
        Method method = UserService.class.getDeclaredMethod("checkUsername", String.class);
        method.setAccessible(true);
        String username = "Joker";
        User user = new User();
        user.setUsername(username);

        boolean exists = userRepository.existsByUsername(username);
        assertThat(exists);
    }

    @Test
    void create() {
        User user = new User(1,
                "Taha Furkan",
                "Unsal",
                "t.furkanunsal.gmail.com",
                "TFU",
                Collections.singletonList(new Address(1, "Home", "Istanbul", "Bahcelievler")));
        Mockito.when(userRepository.save(user)).thenReturn(user);
        assertThat(userService.create(user));


    }
}
