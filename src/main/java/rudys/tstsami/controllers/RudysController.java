package rudys.tstsami.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rudys.tstsami.dtos.RudysDto;
import rudys.tstsami.entities.Rudys;
import rudys.tstsami.services.RudysService;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Sami")
public class RudysController {
    @Autowired
    private RudysService rudysService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/Rudy")
    public ResponseEntity<RudysDto> guardarRudys(@RequestBody RudysDto rudysDto) {
        Rudys rudys = modelMapper.map(rudysDto, Rudys.class);
        rudys = rudysService.guardarRudys(rudys);
        rudysDto = modelMapper.map(rudys, RudysDto.class);
        return ResponseEntity.ok(rudysDto);
    }

    @GetMapping("/Rudys")
    public List<RudysDto> listarRudys() {
        List<Rudys> lista = rudysService.listarRudys();
        List<RudysDto> listaDtos = Arrays.asList(modelMapper.map(lista, RudysDto[].class));
        return listaDtos;
    }

    @GetMapping("/Rudy/{id}")
    public ResponseEntity<RudysDto> obtenerRudysPorId(@PathVariable Long id) {
        Rudys rudys = rudysService.obtenerRudysPorId(id);
        RudysDto dto = modelMapper.map(rudys, RudysDto.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/Rudy/{id}")
    public ResponseEntity<RudysDto> actualizarRudys(@PathVariable Long id, @RequestBody RudysDto rudysDto) {
        Rudys rudys = modelMapper.map(rudysDto, Rudys.class);
        rudys = rudysService.actualizarRudys(id, rudys);
        rudysDto = modelMapper.map(rudys, RudysDto.class);
        return ResponseEntity.ok(rudysDto);
    }

    @DeleteMapping("/Rudy/{id}")
    public void eliminarRudys(@PathVariable Long id) {
        rudysService.eliminarRudys(id);
    }
}
