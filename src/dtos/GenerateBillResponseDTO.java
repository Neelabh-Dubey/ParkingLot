package dtos;

import models.Bill;

public class GenerateBillResponseDTO {
    private Bill bill;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
