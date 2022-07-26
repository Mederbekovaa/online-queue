package kg.itacademy.onlinequeue.service.impl;

import kg.itacademy.onlinequeue.entity.TicketEntity;
import kg.itacademy.onlinequeue.mapper.BranchMapper;
import kg.itacademy.onlinequeue.mapper.TicketMapper;
import kg.itacademy.onlinequeue.model.CompanyModel;
import kg.itacademy.onlinequeue.model.TicketModel;
import kg.itacademy.onlinequeue.repository.TicketRepository;
import kg.itacademy.onlinequeue.service.TicketService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketServiceImpl implements TicketService {
    final TicketRepository ticketRepository;

    @Override
    public TicketModel create(TicketModel ticketModel) {
        TicketEntity ticketEntity = TicketMapper.INSTANCE.toEntity(ticketModel);
        return TicketMapper.INSTANCE.toModel(ticketRepository.save(ticketEntity));
    }

    @Override
    public boolean update(TicketModel ticketModel) {

        TicketEntity ticketEntity = TicketMapper.INSTANCE.toEntity(ticketModel);
        return ticketRepository.save(ticketEntity).getId() != null;
    }
    @Override
    public boolean delete(TicketModel ticketModel) {
        try {
            ticketRepository.delete(ticketRepository.getByName(ticketModel.getName()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
