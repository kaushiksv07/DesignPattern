package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Ticket extends BaseModel {
    private long id;
    private Vehicles vehicles;
    private LocalDateTime entryTime;
    private Gate  entryGate;
}
