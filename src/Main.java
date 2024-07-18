import controllers.BillController;
import controllers.ParkingLotController;
import controllers.TicketController;
import dtos.*;
import models.*;
import repositories.BillRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import services.BillService;
import services.ParkingLotService;
import services.TicketService;
import strategies.spotassigningstrategies.OrderAssignmentStrategy;
import strategies.spotassigningstrategies.SpotAssignmentStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //Creating Parking Lot
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository);
        ParkingLotController parkingLotController = new ParkingLotController(parkingLotService);

        CreateParkingLotRequestDTO createParkingLotRequestDTO = new CreateParkingLotRequestDTO();
        createParkingLotRequestDTO.setAddress("221-B Baker's Street");

        EntryGate gate1 = new EntryGate();
        gate1.setGateType(GateType.ENTRY);
        gate1.setNumber(1);

        ExitGate gate2 = new ExitGate();
        gate2.setGateType(GateType.EXIT);
        gate2.setNumber(2);

        createParkingLotRequestDTO.setGates(List.of(gate1, gate2));

        ParkingFloor parkingFloor1 = new ParkingFloor();
        parkingFloor1.setNumber(1);
        ParkingSpot parkingSpot1 = new ParkingSpot();
        parkingSpot1.setNumber(1);
        parkingSpot1.setSpotType(SpotType.BIKE);
        parkingSpot1.setParkingSpotStatus(ParkingSpotStatus.VACANT);
        ParkingSpot parkingSpot2 = new ParkingSpot();
        parkingSpot2.setNumber(2);
        parkingSpot2.setSpotType(SpotType.SUV);
        parkingSpot2.setParkingSpotStatus(ParkingSpotStatus.VACANT);
        parkingFloor1.setParkingSpots(List.of(parkingSpot1, parkingSpot2));

        createParkingLotRequestDTO.setParkingFloors(List.of(parkingFloor1));

        Map<SpotType, Integer> rateMap = new HashMap<>();
        rateMap.put(SpotType.SEDAN, 20);
        rateMap.put(SpotType.SUV, 30);
        rateMap.put(SpotType.BIKE, 10);

        createParkingLotRequestDTO.setHourlyRate(rateMap);

        CreateParkingLotResponseDTO responseDTO = parkingLotController.createParkingLot(createParkingLotRequestDTO);
        Long parkingLotId = responseDTO.getParkingLongId();

        //1)- Parking Lot Details
        System.out.println(parkingLotRepository.getParkingLotById(parkingLotId).getAddress());

        //Generate Ticket
        TicketRepository ticketRepository = new TicketRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new OrderAssignmentStrategy(parkingLotRepository);
        TicketService ticketService = new TicketService(spotAssignmentStrategy, ticketRepository, parkingLotRepository);
        TicketController ticketController = new TicketController(ticketService);

        CreateTicketRequestDTO createTicketRequestDTO = new CreateTicketRequestDTO();
        createTicketRequestDTO.setEntryGate(gate1);
        createTicketRequestDTO.setParkingLotId(responseDTO.getParkingLongId());

        Operator operator = new Operator();
        operator.setName("Mike");
        createTicketRequestDTO.setOperator(operator);

//        Vehicle vehicle = new Vehicle();
//        vehicle.setIdentifier("123");
//        vehicle.setVehicleType(VehicleType.SUV);

        Vehicle vehicle = new Vehicle();
        vehicle.setIdentifier("12345");
        vehicle.setVehicleType(VehicleType.SEDAN);
        createTicketRequestDTO.setVehicle(vehicle);

        createTicketRequestDTO.setParkingLotId(parkingLotId);

        CreateTicketResponseDTO createTicketResponseDTO = ticketController.createTicket(createTicketRequestDTO);
        Ticket ticket = createTicketResponseDTO.getTicket();
        if(ticket == null){
            System.out.println("No Spot Assigned!");
        }

        //2)- Ticket Details
        System.out.println(ticket.getOperator().getName() + " " + ticket.getEntryTime() + " " + ticket.getEntryGate().getNumber() + " "
                + ticket.getVehicle().getIdentifier());

        //Generate Bill
        BillRepository billRepository = new BillRepository();
        BillService billService = new BillService(billRepository, parkingLotRepository);
        BillController billController = new BillController(billService);

        Operator operator1 = new Operator();
        operator1.setName("Ross");

        GenerateBillRequestDTO generateBillRequestDTO = new GenerateBillRequestDTO();
        generateBillRequestDTO.setExitGate(gate2);
        generateBillRequestDTO.setTicket(ticket);
        generateBillRequestDTO.setOperator(operator1);

        GenerateBillResponseDTO generateBillResponseDTO = billController.generateBill(generateBillRequestDTO);
        Bill bill = generateBillResponseDTO.getBill();

        //3)- Bill Details
        System.out.println(bill.getExitGate().getNumber() + " " + bill.getTicket().getEntryGate().getNumber() + " " + bill.getAmount());


    }
}