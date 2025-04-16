package rudys.tstsami.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rudys.tstsami.entities.Ropa;
import rudys.tstsami.repositories.RopaRepository;
import rudys.tstsami.services.RopaService;

import java.util.List;

@Service
public class RopaServiceImp implements RopaService {
    @Autowired
    private RopaRepository ropaRepository;

    @Override
    public Ropa insertarRopa(Ropa ropa) {
        return ropaRepository.save(ropa);
    }

    @Override
    public List<Ropa> listarRopas() {
        return ropaRepository.findAll();
    }

    @Override
    public Ropa actualizarRopa(Long id, Ropa ropaActualizada) {
        Ropa ropa = ropaRepository.findById(id).orElse(null);
        if (ropa != null) {
            ropa.setNombreRopa(ropaActualizada.getNombreRopa());
            return ropaRepository.save(ropa);
        }
        return null;
    }

    @Override
    public void eliminarRopa(Long id) {
        ropaRepository.deleteById(id);
    }

    @Override
    public Ropa obtenerRopaPorId(Long id) {
        return ropaRepository.findById(id).orElse(null);
    }
}
