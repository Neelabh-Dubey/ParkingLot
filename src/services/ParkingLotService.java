package services;

import models.Gate;
import models.ParkingFloor;
import models.ParkingLot;
import repositories.ParkingLotRepository;

import java.util.List;

public class ParkingLotService {
    private final ParkingLotRepository parkingLotRepository;
    public ParkingLotService(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }

    public Long createParkingLot(ParkingLot parkingLot){
        return parkingLotRepository.save(parkingLot);
    }

    public void addParkingFloor(Long parkingLotId, ParkingFloor parkingFloor){
        ParkingLot parkingLot = parkingLotRepository.getParkingLotById(parkingLotId);
        parkingLot.getParkingFloors().add(parkingFloor);
        parkingLotRepository.update(parkingLotId, parkingLot);
    }
}
