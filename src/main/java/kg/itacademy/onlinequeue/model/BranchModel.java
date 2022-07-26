package kg.itacademy.onlinequeue.model;

import kg.itacademy.onlinequeue.entity.CompanyEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchModel {
    @NotNull
    private Long id;
    private String name;
    private Integer contact;
    private String placeBranch;
    CompanyEntity company;


}
