package model;

import java.time.LocalDateTime;
import java.util.Date;

public class Bill extends BaseModel {
    private Ticket ticket;
    private LocalDateTime exitTime;
    private Gate exitGate;
    private Double amount;
    private List<Payments> payments;
}
