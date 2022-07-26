package kg.itacademy.onlinequeue.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "usluges")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UslugaEntity extends BaseEntity {

    @Column(name = "name" , nullable = false, unique = true)
    String name;

//    @ManyToMany
//    @JoinColumn(name = "branches_id", nullable = false)
//    BranchEntity branchEntity;
}
