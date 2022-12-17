package tahafurkan.sandbox.usermanagement.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import tahafurkan.sandbox.usermanagement.entities.Address;
import tahafurkan.sandbox.usermanagement.entities.User;
import tahafurkan.sandbox.usermanagement.exception.UsernameIsInUseException;
import tahafurkan.sandbox.usermanagement.exception.UsernameUnavailableException;
import tahafurkan.sandbox.usermanagement.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;


@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {

    @Spy
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

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

    @Test
    void create_GivenProhibitedUsername_ThrowsException() {
        String username = "obama";
        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address(1, "home", "New York", "New York"));
        addressList.add(new Address(2, "work", "Texas", "Texas"));

        User user = new User(1, "Barrack", "Obama", "barrack.obama@hotmail.com", username, addressList);

        assertThrows(UsernameUnavailableException.class, () -> {
            userService.create(user);
        });
    }

    @Test
    void create_GivenAllowedUsername_ReturnsSavedUser() {
        String username = "taha.furkan";
        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address(1, "home", "Istanbul", "Turkey"));
        addressList.add(new Address(2, "work", "Istanbul", "Turkey"));
        User user = new User(1, "Taha", "Unsal", "taha.f.unsal@gmail.com", username, addressList);
        userService.create(user);
        Mockito.verify(userRepository, times(1)).save(user);
    }

}
