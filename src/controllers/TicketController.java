package controllers;

import dtos.CreateTicketRequestDTO;
import dtos.CreateTicketResponseDTO;
import models.*;
import services.TicketService;

import java.util.Date;

public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public CreateTicketResponseDTO createTicket(CreateTicketRequestDTO requestDTO){
        Vehicle vehicle = requestDTO.getVehicle();
        Operator operator = requestDTO.getOperator();
        EntryGate entryGate = requestDTO.getEntryGate();
        Long parkingLotId = requestDTO.getParkingLotId();
        Ticket ticket = ticketService.generateTicket(vehicle, operator, entryGate, parkingLotId);
        CreateTicketResponseDTO createTicketResponseDTO = new CreateTicketResponseDTO();
        createTicketResponseDTO.setTicket(ticket);
        return createTicketResponseDTO;
    }

}
