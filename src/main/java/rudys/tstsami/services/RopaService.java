package rudys.tstsami.services;

import rudys.tstsami.entities.Ropa;

import java.util.List;

public interface RopaService {
    public Ropa insertarRopa(Ropa ropa);
    public List<Ropa> listarRopas();
    public Ropa actualizarRopa(Long id, Ropa ropaActualizada);
    public void eliminarRopa(Long id);
    public Ropa obtenerRopaPorId(Long id);
}
