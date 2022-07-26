package kg.itacademy.onlinequeue.repository;

import kg.itacademy.onlinequeue.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
}
