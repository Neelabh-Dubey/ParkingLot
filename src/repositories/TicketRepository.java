package repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private long ticketId = 1L;
    private Map<Long, Ticket> tickets = new HashMap<>();

    public void save(Ticket ticket){
        long currentTicketId = ticketId;
        ticketId++;
        ticket.setId(currentTicketId);
        tickets.put(currentTicketId, ticket);
    }
}
