package rudys.tstsami.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rudys.tstsami.dtos.RopaDto;
import rudys.tstsami.entities.Ropa;
import rudys.tstsami.services.RopaService;

import java.util.Arrays;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/Sami")
public class RopaController {
    @Autowired
    private RopaService ropaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/Ropa")
    public ResponseEntity<RopaDto> insertarRopa(@RequestBody RopaDto ropaDto) {
        Ropa ropa = modelMapper.map(ropaDto, Ropa.class);
        ropa = ropaService.insertarRopa(ropa);
        ropaDto = modelMapper.map(ropa, RopaDto.class);
        return ResponseEntity.ok(ropaDto);
    }

    @GetMapping("/Ropas")
    public List<RopaDto> listarRopas() {
        List<Ropa> ropas = ropaService.listarRopas();
        List<RopaDto> ropaDto = Arrays.asList(modelMapper.map(ropas, RopaDto[].class));
        return ropaDto;
    }

    @GetMapping("/Ropa/{id}")
    public ResponseEntity<RopaDto> obtenerRopaPorId(@PathVariable Long id) {
        Ropa ropa = ropaService.obtenerRopaPorId(id);
        RopaDto ropaDto = modelMapper.map(ropa, RopaDto.class);
        return ResponseEntity.ok(ropaDto);
    }

    @PutMapping("/Ropa/{id}")
    public ResponseEntity<RopaDto> actualizarRopa(@PathVariable Long id, @RequestBody RopaDto ropaDto) {
        Ropa ropa = modelMapper.map(ropaDto, Ropa.class);
        ropa = ropaService.actualizarRopa(id, ropa);
        ropaDto = modelMapper.map(ropa, RopaDto.class);
        return ResponseEntity.ok(ropaDto);
    }

    @DeleteMapping("/Ropa/{id}")
    public void eliminarRopa(@PathVariable Long id) {
        ropaService.eliminarRopa(id);
    }
}
