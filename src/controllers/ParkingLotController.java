package controllers;

import dtos.AddFloorRequestDTO;
import dtos.AddFloorResponseDTO;
import dtos.CreateParkingLotRequestDTO;
import dtos.CreateParkingLotResponseDTO;
import models.Gate;
import models.ParkingFloor;
import models.ParkingLot;
import models.SpotType;
import services.ParkingLotService;

import java.util.List;
import java.util.Map;

public class ParkingLotController {
    private final ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService){
        this.parkingLotService = parkingLotService;
    }
    public CreateParkingLotResponseDTO createParkingLot(CreateParkingLotRequestDTO request){
        String address = request.getAddress();
        List<ParkingFloor> parkingFloors = request.getParkingFloors();
        List<Gate> gates = request.getGates();
        Map<SpotType, Integer> hourlyRate = request.getHourlyRate();

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setAddress(address);
        parkingLot.setParkingFloors(parkingFloors);
        parkingLot.setGates(gates);
        parkingLot.setHourlyRate(hourlyRate);

        Long parkingLotId = parkingLotService.createParkingLot(parkingLot);

        CreateParkingLotResponseDTO createParkingLotResponseDTO = new CreateParkingLotResponseDTO();
        createParkingLotResponseDTO.setParkingLotId(parkingLotId);

        return createParkingLotResponseDTO;
    }

    public AddFloorResponseDTO addFloor(AddFloorRequestDTO addFloorRequestDTO){
        Long parkingLotId = addFloorRequestDTO.getParkingLotId();
        ParkingFloor parkingFloor = addFloorRequestDTO.getParkingFloor();
        AddFloorResponseDTO addFloorResponseDTO = new AddFloorResponseDTO();
        parkingLotService.addParkingFloor(parkingLotId, parkingFloor);
        addFloorResponseDTO.setParkingLotId(parkingLotId);
        return addFloorResponseDTO;
    }

}
