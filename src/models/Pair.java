package models;

public class Pair {
    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public Pair(ParkingFloor parkingFloor, ParkingSpot parkingSpot) {
        this.parkingFloor = parkingFloor;
        this.parkingSpot = parkingSpot;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    private ParkingFloor parkingFloor;
    private ParkingSpot parkingSpot;

}
