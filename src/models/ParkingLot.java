package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot extends BaseModel{
    private String address;
    private Map<SpotType, Integer> hourlyRate = new HashMap<>();

    public void setHourlyRate(Map<SpotType, Integer> hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Map<SpotType, Integer> getHourlyRate() {
        return hourlyRate;
    }

    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;

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
