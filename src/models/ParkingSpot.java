package models;

public class ParkingSpot extends BaseModel{
    private int number;
    private SpotType spotType;
    private EVCharger evCharger;
    private Operator operator;

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    private ParkingSpotStatus parkingSpotStatus;

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public EVCharger getEvCharger() {
        return evCharger;
    }

    public void setEvCharger(EVCharger evCharger) {
        this.evCharger = evCharger;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }
}
