package rudys.tstsami.entities;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rudys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rudysId;
    private int rudysPower;
    @ManyToOne
    @JoinColumn(name= "ropa_id")
    private Ropa ropa;
}
