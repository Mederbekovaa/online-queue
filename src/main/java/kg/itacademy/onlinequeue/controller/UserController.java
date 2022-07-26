package kg.itacademy.onlinequeue.controller;

import kg.itacademy.onlinequeue.model.UserAuthModel;
import kg.itacademy.onlinequeue.model.UserModel;
import kg.itacademy.onlinequeue.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = "*")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {
    final UserService userService;

    @PostMapping(path = "/sign-in")
    public String getAuthToken(@RequestBody UserAuthModel userAuthDto) {
        return userService. getToken(userAuthDto);
    }

    @PostMapping(path = "/sign-up")
    public String register(@RequestBody UserModel userModel)  {
        return userService.createUser(userModel);
    }
}
