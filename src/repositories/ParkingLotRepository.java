package repositories;

import models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Long currentParkingLotId = 1L;
    private Map<Long, ParkingLot> parkingLots= new HashMap<>();
    public Long save(ParkingLot parkingLot){
        Long parkingLotId = currentParkingLotId;
        currentParkingLotId++;
        parkingLot.setId(parkingLotId);
        parkingLots.put(parkingLotId, parkingLot);
        return parkingLotId;
    }

    public ParkingLot getParkingLotById(Long id){
        return parkingLots.get(id);
    }

    public void update(Long id, ParkingLot parkingLot){
        parkingLots.put(id, parkingLot);
    }
}
