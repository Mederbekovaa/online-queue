package kg.itacademy.onlinequeue.service;

import kg.itacademy.onlinequeue.model.TicketModel;

public interface TicketService {
    TicketModel create(TicketModel ticketModel);

    boolean update(TicketModel ticketModel);

    boolean delete(TicketModel ticketModel);

}
