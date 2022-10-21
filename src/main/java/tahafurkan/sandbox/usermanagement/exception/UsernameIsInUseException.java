package tahafurkan.sandbox.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UsernameIsInUseException extends RuntimeException {

    public UsernameIsInUseException(String message) {
        super(message);
    }
}
