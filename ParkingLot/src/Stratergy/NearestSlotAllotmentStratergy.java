package Stratergy;

import model.Floor;
import model.ParkingPlot;
import model.Slots;
import model.enums.FloorStatus;
import model.enums.SlotStatus;
import model.enums.VehicleType;

public class NearestSlotAllotmentStratergy implements SlotAllotmentTypeStratergy {

    @Override
    public Slots alloteSlot(VehicleType vehicleType, ParkingPlot parkingPlot) {
        for(Floor floor: parkingPlot.getFloors()){
            if(floor.getFloorStatus() == FloorStatus.EMPTY){
                for(Slots slots: floor.getSlots()){
                    if(slots.getSlotStatus() == SlotStatus.AVAILABLE){
                        slots.setSlotStatus(SlotStatus.FILLED);
                        return slots;
                    }
                }
                floor.setFloorStatus(FloorStatus.FILLED);
            }
        }
        return null;
    }
}
