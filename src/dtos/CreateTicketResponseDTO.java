package dtos;

import models.Ticket;
import services.TicketService;

public class CreateTicketResponseDTO {
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
