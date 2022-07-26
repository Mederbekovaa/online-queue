package kg.itacademy.onlinequeue.service;

import kg.itacademy.onlinequeue.entity.RoleEntity;
import kg.itacademy.onlinequeue.model.UserAuthModel;
import kg.itacademy.onlinequeue.model.UserModel;

public interface UserService {
    String getToken(UserAuthModel userAuthDto);
    String createUser(UserModel userAuthDto);
}
