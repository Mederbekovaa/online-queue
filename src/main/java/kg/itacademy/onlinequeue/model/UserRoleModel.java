package kg.itacademy.onlinequeue.model;

import kg.itacademy.onlinequeue.entity.RoleEntity;
import kg.itacademy.onlinequeue.entity.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRoleModel {
  UserEntity user;
  RoleEntity role;
}
