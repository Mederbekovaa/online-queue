package kg.itacademy.onlinequeue.repository;

import kg.itacademy.onlinequeue.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity getByEmail(String email);
}