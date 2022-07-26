package kg.itacademy.onlinequeue.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyModel {
    @NotNull
    private Long id;
    private String name;
    private Integer contact;
    private List<BranchModel> branchModels;


}
