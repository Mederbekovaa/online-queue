package kg.itacademy.onlinequeue.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class  UserModel {
    private String name;
    private String role_name;
    private String email;
    private String login;
    private String password;
    private boolean isActive;
}
