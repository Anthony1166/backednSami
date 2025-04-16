package rudys.tstsami.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rudys.tstsami.entities.Rudys;

public interface RudysRepository extends JpaRepository<Rudys, Long> {
}
