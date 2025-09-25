package dto;

import model.enums.PaymentStatus;
import model.enums.PaymentType;
import model.enums.VehicleType;

import java.time.LocalDateTime;
import java.util.List;

public class IssueTicketResponseDto {
    private String ticketId;
    private String billId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private VehicleType vehicleType;
    private Double amount;
    private List<PaymentType> paymentTypes;
    private IssueTicketStatus ticketStatus;
}
