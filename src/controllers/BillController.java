package controllers;

import dtos.GenerateBillRequestDTO;
import dtos.GenerateBillResponseDTO;
import models.*;
import services.BillService;

public class BillController {

    private final BillService billService;
    public BillController(BillService billService){
        this.billService = billService;
    }
    public GenerateBillResponseDTO generateBill(GenerateBillRequestDTO generateBillRequestDTO){
        Ticket ticket = generateBillRequestDTO.getTicket();
        Operator operator = generateBillRequestDTO.getOperator();
        ExitGate gate = generateBillRequestDTO.getExitGate();
        GenerateBillResponseDTO responseDTO = new GenerateBillResponseDTO();
        responseDTO.setBill(billService.generateBill(ticket, operator, gate));
        return responseDTO;
    }
}
