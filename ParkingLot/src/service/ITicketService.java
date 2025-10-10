package service;

import model.Ticket;
import model.enums.VehicleType;

public interface ITicketService {
    public Ticket createTicket(String vehicleNo, int parkingPlotNo, VehicleType vehicleType, int gateId, int operatorId);
}
