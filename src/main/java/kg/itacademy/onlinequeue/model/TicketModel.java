package kg.itacademy.onlinequeue.model;

import kg.itacademy.onlinequeue.entity.BranchEntity;
import kg.itacademy.onlinequeue.entity.UslugaEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketModel {
    @NotNull
    private Long id;
    private String name;
    BranchEntity branchEntity;
    UslugaEntity uslugaEntity;
}
