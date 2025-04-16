package rudys.tstsami.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rudys.tstsami.entities.Ropa;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RudysDto {
    private Long rudysId;
    private int rudysPower;
    private Ropa ropa;
}
