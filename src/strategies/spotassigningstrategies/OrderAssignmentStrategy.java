package strategies.spotassigningstrategies;

import models.*;
import repositories.ParkingLotRepository;

public class OrderAssignmentStrategy implements SpotAssignmentStrategy{
    private final ParkingLotRepository parkingLotRepository;
    public OrderAssignmentStrategy(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }
    @Override
    public Pair assignSpot(SpotType spotType, Long parkingLotId) {
        ParkingLot parkingLot = parkingLotRepository.getParkingLotById(parkingLotId);
        for(ParkingFloor parkingFloor : parkingLot.getParkingFloors()){
            for(ParkingSpot parkingSpot : parkingFloor.getParkingSpots()){
                if(parkingSpot.getSpotType() == spotType && parkingSpot.getParkingSpotStatus() == ParkingSpotStatus.VACANT){
                    return new Pair(parkingFloor, parkingSpot);
                }
            }
        }
        return null;
    }
}
