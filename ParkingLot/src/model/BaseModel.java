package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseModel {
    private int id;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
