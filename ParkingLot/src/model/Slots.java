package model;

import lombok.Getter;
import lombok.Setter;
import model.enums.SlotStatus;

@Setter
@Getter
public class Slots extends  BaseModel {
    private String slotNumber;
    private SlotStatus slotStatus;

}
