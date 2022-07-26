package kg.itacademy.onlinequeue.exceptions.user;

import org.springframework.security.core.AuthenticationException;

public class UserNameNotFoundException extends AuthenticationException {
    public UserNameNotFoundException(String msg) {
        super(msg);
    }
    public UserNameNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
