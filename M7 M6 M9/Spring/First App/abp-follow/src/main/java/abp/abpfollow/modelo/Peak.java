package abp.abpfollow.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "Peak") //No hace falta si el nombre es el mismo que el de la clase
public class Peak {

    @Id
    @Column(name = "peak", unique = true, nullable = false)
    private String peak;
    @Column
    private int height;
    @Column
    private String category;
    @Column
    private String zone;

    @OneToMany
    @JoinColumn
    private List<Other> other;

    @OneToOne
    @JoinColumn(name = "main_peak_id")
    private Other mainOther;

    public Peak() {

    }

}
