package service;

import exceptions.ResourseNotFoundExceptions;
import model.Gate;
import model.Ticket;
import model.enums.VehicleType;
import repository.GateRepository;
import repository.OperatorRepository;
import repository.SlotRepository;
import repository.VehicleRepository;

import java.util.Optional;

public class TicketServiceImpl implements ITicketService {

    private VehicleRepository vehicleRepository;
    private GateRepository gateRepository;
    private SlotRepository slotRepository;
    private OperatorRepository operatorRepository;

    public TicketServiceImpl() {
        vehicleRepository = new VehicleRepository();
        gateRepository = new GateRepository();
        slotRepository = new SlotRepository();
        operatorRepository = new OperatorRepository();
    }

    @Override
    public Ticket createTicket(String vehicleNo, int parkingPlotNo, VehicleType vehicleType, int gateId, int operatorId) {
        return generateTicket(vehicleNo, parkingPlotNo, vehicleType, gateId, operatorId);
    }

    public Ticket generateTicket(String vehicleNo, int parkingPlotNo, VehicleType vehicleType, int gateId, int operatorId) {



    }
    public Gate getGateDetais(int gateId){
        Optional<Gate> gate = gateRepository.getGate(gateId);
        if(gate.isEmpty()) {
            throw new ResourseNotFoundExceptions("Gate not found with id " +  gateId);
        }
    }
}
