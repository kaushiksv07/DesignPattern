package model;

import lombok.Getter;
import lombok.Setter;
import model.enums.SoltStatus;

@Setter
@Getter
public class Slots extends  BaseModel {
    private String slotNumber;
    private SoltStatus slotStatus;

}
