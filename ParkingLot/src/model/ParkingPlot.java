package model;

import Stratergy.SlotAllotmentTypeStratergy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingPlot {
    private List<Floor> floors;
    private List<Gate> entryGates;
    private List<Gate> exitGates;
    private int maxCapacity;
    private List<Vehicles> vehicles;
    private SlotAllotmentTypeStratergy slotAllotmentTypeStratergy;
}
