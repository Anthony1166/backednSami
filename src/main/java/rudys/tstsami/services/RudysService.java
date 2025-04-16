package rudys.tstsami.services;

import rudys.tstsami.entities.Rudys;

import java.util.List;

public interface RudysService {
    public Rudys guardarRudys(Rudys rudys);
    public List<Rudys> listarRudys();
    public Rudys obtenerRudysPorId(Long id);
    public Rudys actualizarRudys(Long id, Rudys rudysActualizado);
    public void eliminarRudys(Long id);
}
