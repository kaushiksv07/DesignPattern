package dto;

import model.enums.VehicleType;

public class IssueTicketRequestDto {
    private int parkingPlotId;
    private String licenseId;
    private VehicleType vehicleType;
    private int gateId;
    private int operatorId;
}
