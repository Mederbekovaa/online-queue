package kg.itacademy.onlinequeue.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "companies")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyEntity extends BaseEntity {

    @Column(name = "name", nullable = false , unique = true)
    String name;

    @Column(name = "contact" , nullable = false)
    Integer contact;
}
