package dtos;

import models.Gate;
import models.ParkingFloor;
import models.ParkingSpot;
import models.SpotType;

import java.util.List;
import java.util.Map;

public class CreateParkingLotRequestDTO {
    private String address;
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;

    private Map<SpotType, Integer> hourlyRate;

    public Map<SpotType, Integer> getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Map<SpotType, Integer> hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }
}
