package model;

import lombok.Getter;
import lombok.Setter;
import model.enums.FloorStatus;
import model.enums.VehicleType;

import java.util.List;

@Setter
@Getter
public class Floor extends BaseModel {
    private String floorNumber;
    private List<Slots> slots;
    private List<Vehicles> vehicle;
    private FloorStatus floorStatus;

}
