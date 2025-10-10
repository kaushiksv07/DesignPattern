package Stratergy;

import model.ParkingPlot;
import model.Slots;
import model.enums.VehicleType;

public interface SlotAllotmentTypeStratergy {
    Slots alloteSlot(VehicleType vehicleType, ParkingPlot parkingPlot);
}
