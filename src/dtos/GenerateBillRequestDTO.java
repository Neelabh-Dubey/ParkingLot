package dtos;

import models.ExitGate;
import models.Operator;
import models.Ticket;

public class GenerateBillRequestDTO {
    private Ticket ticket;
    private Operator operator;
    private ExitGate exitGate;

    public ExitGate getExitGate() {
        return exitGate;
    }

    public void setExitGate(ExitGate exitGate) {
        this.exitGate = exitGate;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
