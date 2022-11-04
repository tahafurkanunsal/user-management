package tahafurkan.sandbox.usermanagement.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tahafurkan.sandbox.usermanagement.entities.User;
import tahafurkan.sandbox.usermanagement.exception.UsernameIsInUseException;
import tahafurkan.sandbox.usermanagement.exception.UsernameUnavailableException;
import tahafurkan.sandbox.usermanagement.repository.UserRepository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;
    @Test
    void checkUsername() throws UsernameUnavailableException, UsernameIsInUseException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method =UserService.class.getDeclaredMethod("checkUsername", String.class);
        method.setAccessible(true);
        method.invoke(userService , "Joker");
    }

    @Test
    void create(){
        User user = new User();
        user.setUsername("Joker");
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assertions.assertEquals(user, userService.create(user));
    }

}