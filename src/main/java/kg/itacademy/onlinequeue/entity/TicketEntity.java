package kg.itacademy.onlinequeue.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@Table(name = "tickets")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketEntity extends BaseEntity {
  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @OneToOne
  @JoinColumn(name = "branch_id", nullable = false)
  BranchEntity branchEntity;

  @OneToOne
  @JoinColumn(name = "usluga_id", nullable = false)
  UslugaEntity uslugaEntity;

  @Column
  LocalDateTime assignedTime;

  // история
}
