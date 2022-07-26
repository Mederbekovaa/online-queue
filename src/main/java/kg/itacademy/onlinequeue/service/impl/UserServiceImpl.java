package kg.itacademy.onlinequeue.service.impl;

import kg.itacademy.onlinequeue.entity.UserEntity;
import kg.itacademy.onlinequeue.entity.UserRoleEntity;
import kg.itacademy.onlinequeue.exceptions.user.UserNameNotFoundException;
import kg.itacademy.onlinequeue.exceptions.user.UserSignInException;
import kg.itacademy.onlinequeue.model.UserAuthModel;
import kg.itacademy.onlinequeue.model.UserModel;
import kg.itacademy.onlinequeue.repository.RoleRepository;
import kg.itacademy.onlinequeue.repository.UserRepository;
import kg.itacademy.onlinequeue.repository.UserRoleRepository;
import kg.itacademy.onlinequeue.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {
        final UserRepository userRepository;

        final RoleRepository roleRepository;


        final UserRoleRepository userRoleRepository;


        final PasswordEncoder passwordEncoder;

        @Override
        public String getToken(UserAuthModel userAuthDto) {
            UserEntity userEntity = userRepository
                    .getByEmail(userAuthDto.getLogin());
            if(userEntity==null){
                throw new UserNameNotFoundException("Username not found");
            }
            boolean isMatches = passwordEncoder.matches(userAuthDto.getPassword(), userEntity.getPassword());
            if (isMatches) {
                return "Basic " + new String (Base64.getEncoder()
                        .encode((userEntity.getLogin() + ":" + userAuthDto.getPassword()).getBytes()));
            } else {
                throw new UserSignInException("Неправильный логин или пароль!", HttpStatus.UNAUTHORIZED);
            }
        }

        @Override
        public String createUser(UserModel userModel) {
            UserEntity userEntity = new UserEntity();
            //Маппинг user
            userEntity.setLogin(userModel.getLogin());
            userEntity.setEmail(userModel.getEmail());
            //
            userEntity.setPassword(passwordEncoder.encode(userModel.getPassword()));
            userEntity.setIsActive(true);

            UserRoleEntity userRoleEntity = new UserRoleEntity();
            if (userModel.getLogin().contains("admin")) {
                userRoleEntity.setRole(roleRepository.getByNameRole("Admin"));
            } else {
                userRoleEntity.setRole(roleRepository.getByNameRole("User"));
            }
            userRoleEntity.setUser(userRepository.save(userEntity));
            userRoleRepository.save(userRoleEntity);
            return "created";
        }
    }

