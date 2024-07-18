package models;

import java.util.Date;

public class Bill extends BaseModel{
    private Ticket ticket;
    private Date exitTime;
    private int amount;
    private BillPaymentStatus billPaymentStatus;
    private ExitGate exitGate;
    private Operator operator;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BillPaymentStatus getBillPaymentStatus() {
        return billPaymentStatus;
    }

    public void setBillPaymentStatus(BillPaymentStatus billPaymentStatus) {
        this.billPaymentStatus = billPaymentStatus;
    }

    public ExitGate getExitGate() {
        return exitGate;
    }

    public void setExitGate(ExitGate exitGate) {
        this.exitGate = exitGate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
