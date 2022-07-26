package kg.itacademy.onlinequeue.repository;

import kg.itacademy.onlinequeue.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long > {
   CompanyEntity getByName( String companyName);
}

