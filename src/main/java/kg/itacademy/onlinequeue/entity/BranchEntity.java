package kg.itacademy.onlinequeue.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "branches")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchEntity extends BaseEntity {

    @Column(name = "name" , nullable = false, unique = true)
    String name;

    @Column(name = "contact", nullable = false )
    Integer contact;

    @Column(name = "place_branch", nullable = false, unique = true)
    String placeBranch;

    @Column
    LocalDateTime beginWorkTime;

    @Column
    LocalDateTime endWorkTime;

    @ManyToOne
    @JoinColumn(name = "companies_id", nullable = false)
    CompanyEntity companyId;

    @ManyToOne
    @JoinColumn(name = "usluga_id", nullable = false)
    UslugaEntity uslugaId;
}