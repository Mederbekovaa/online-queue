package kg.itacademy.onlinequeue.repository;

import kg.itacademy.onlinequeue.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Long > {
    TicketEntity getByName(String ticketName);


}
