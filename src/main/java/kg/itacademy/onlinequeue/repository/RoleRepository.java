package kg.itacademy.onlinequeue.repository;

import kg.itacademy.onlinequeue.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<RoleEntity,Long > {
    RoleEntity getByNameRole(String nameRole);
}
