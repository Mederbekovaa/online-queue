package kg.itacademy.onlinequeue.repository;

import kg.itacademy.onlinequeue.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BranchRepository extends JpaRepository<BranchEntity, Long > {
    BranchEntity getByName( String branchName);
}
