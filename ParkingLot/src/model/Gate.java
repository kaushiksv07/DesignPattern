package model;

import lombok.Getter;
import lombok.Setter;
import model.enums.GateStatus;
import model.enums.GateType;

@Getter
@Setter
public class Gate extends BaseModel{
    private String gateNumber;
    private GateType gateType;
    private GateStatus gateStatus;
    private Operator operator;
}
