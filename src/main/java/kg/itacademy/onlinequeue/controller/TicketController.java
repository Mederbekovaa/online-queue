package kg.itacademy.onlinequeue.controller;

import kg.itacademy.onlinequeue.model.CompanyModel;
import kg.itacademy.onlinequeue.model.TicketModel;
import kg.itacademy.onlinequeue.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/ticket")
@Slf4j
@CrossOrigin(maxAge = 3600, origins = "*")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping(path = "/create")
    public ResponseEntity<TicketModel> createNewTicket( @RequestBody TicketModel ticketModel) {
        TicketModel result = ticketService.create(ticketModel);

        if (result.getId() != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
    @PutMapping(path = "/update")
    public ResponseEntity<Boolean> updateTicket( @Valid @RequestBody TicketModel ticketModel) {
        try {
            return ResponseEntity.ok(ticketService.update(ticketModel));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
    @DeleteMapping(path = "/delete")
    public ResponseEntity<Boolean> deleteTicket( @Valid @RequestBody TicketModel ticketModel) {
        try {
            return ResponseEntity.ok(ticketService.delete(ticketModel));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
