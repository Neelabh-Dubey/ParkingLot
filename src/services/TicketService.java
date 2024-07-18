package services;

import models.*;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import strategies.spotassigningstrategies.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    private final SpotAssignmentStrategy spotAssignmentStrategy;
    private final TicketRepository ticketRepository;

    private final ParkingLotRepository parkingLotRepository;

    public TicketService(
            SpotAssignmentStrategy spotAssignmentStrategy,
            TicketRepository ticketRepository,
            ParkingLotRepository parkingLotRepository
    ){
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket generateTicket(Vehicle vehicle, Operator operator, EntryGate entryGate, Long parkingLotId){
        SpotType spotType = getSpotType(vehicle.getVehicleType());
        Pair parkingSpace = spotAssignmentStrategy.assignSpot(spotType, parkingLotId);
        if(parkingSpace == null) return  null;
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setEntryGate(entryGate);
        ticket.setOperator(operator);
        ticket.setVehicle(vehicle);
        ticket.setParkingSpot(parkingSpace.getParkingSpot());
        ticket.setParkingFloor(parkingSpace.getParkingFloor());
        ticket.setParkingLot(parkingLotRepository.getParkingLotById(parkingLotId));
        ticketRepository.save(ticket);
        return ticket;
    }

    private SpotType getSpotType(VehicleType vehicleType){
        return switch (vehicleType){
            case SUV, XUV -> SpotType.SUV;
            case BIKE -> SpotType.BIKE;
            case SEDAN, HATCHBACK -> SpotType.SEDAN;
        };
    }

}
