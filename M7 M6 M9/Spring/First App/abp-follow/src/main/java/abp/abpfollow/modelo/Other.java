package abp.abpfollow.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Other {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private String other;

}
