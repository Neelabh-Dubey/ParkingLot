package services;

import models.*;
import repositories.BillRepository;
import repositories.ParkingLotRepository;

import java.util.Date;

public class BillService {
    private final BillRepository billRepository;
    private final ParkingLotRepository parkingLotRepository;
    public BillService(BillRepository billRepository, ParkingLotRepository parkingLotRepository){
        this.billRepository = billRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Bill generateBill(Ticket ticket, Operator operator, ExitGate gate){
        ParkingLot parkingLot = parkingLotRepository.getParkingLotById(ticket.getId());
        int hourlyParkingRate = getHourlyRate(ticket.getParkingSpot().getSpotType(), parkingLot);
        Date exitTime = new Date();
        long totalParkedDuration = (exitTime.getTime() - ticket.getEntryTime().getTime());
        int durationInHour = Math.max((int)(totalParkedDuration/3600), 1);
        int amount = durationInHour * hourlyParkingRate;
        Bill bill = new Bill();
        bill.setOperator(operator);
        bill.setTicket(ticket);
        bill.setExitGate(gate);
        bill.setExitTime(exitTime);
        bill.setAmount(amount);
        billRepository.save(bill);
        return bill;
    }

    private int getHourlyRate(SpotType spotType, ParkingLot parkingLot){
        return parkingLot.getHourlyRate().get(spotType);
    }
}
