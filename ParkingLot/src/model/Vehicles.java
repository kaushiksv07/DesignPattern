package model;

import lombok.Getter;
import lombok.Setter;
import model.enums.VehicleType;

@Setter
@Getter
public class Vehicles extends BaseModel {
    private String licensePlate;
    private VehicleType vehicleType;
}
