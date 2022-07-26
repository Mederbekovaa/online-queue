package kg.itacademy.onlinequeue.repository;

import kg.itacademy.onlinequeue.entity.UslugaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UslugaRepository extends JpaRepository<UslugaEntity, Long > {
    UslugaEntity getByName(String uslugaName);
}
