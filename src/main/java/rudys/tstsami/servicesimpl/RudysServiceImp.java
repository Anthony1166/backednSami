package rudys.tstsami.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rudys.tstsami.entities.Rudys;
import rudys.tstsami.repositories.RudysRepository;
import rudys.tstsami.services.RudysService;

import java.util.List;
@Service
public class RudysServiceImp implements RudysService {
    @Autowired
    private RudysRepository rudysRepository;

    @Override
    public Rudys guardarRudys(Rudys rudys) {
        return rudysRepository.save(rudys);
    }

    @Override
    public List<Rudys> listarRudys() {
        return rudysRepository.findAll();
    }

    @Override
    public Rudys obtenerRudysPorId(Long id) {
        return rudysRepository.findById(id).orElse(null);
    }

    @Override
    public Rudys actualizarRudys(Long id, Rudys rudysActualizado) {
        Rudys rudys = rudysRepository.findById(id).orElse(null);
        if (rudys != null) {
            rudys.setRudysPower(rudysActualizado.getRudysPower());
            rudys.setRopa(rudysActualizado.getRopa());
            return rudysRepository.save(rudys);
        }
        return null;
    }

    @Override
    public void eliminarRudys(Long id) {
        rudysRepository.deleteById(id);
    }
}
