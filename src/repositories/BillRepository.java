package repositories;

import models.Bill;

import java.util.HashMap;
import java.util.Map;

public class BillRepository {
    private Map<Long, Bill> bills = new HashMap<>();
    private Long billId = 1L;
    public void save(Bill bill){
        Long currentBillId = billId;
        billId++;
        bill.setId(currentBillId);
        bills.put(currentBillId, bill);
    }
}
