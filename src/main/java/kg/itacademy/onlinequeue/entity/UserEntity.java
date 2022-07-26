package kg.itacademy.onlinequeue.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    String name;

    @Column(name = "role_name", nullable = false, unique = true)
    String role_name;

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Column(name = "login", nullable = true, unique = true)
    String login;

    @Column(name = "password", nullable = false, unique = true)
    String password;

    @Column(name = "is_active", nullable = false,length = 3)
    Boolean isActive;


}
