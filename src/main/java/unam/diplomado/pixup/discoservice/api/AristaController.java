package unam.diplomado.pixup.discoservice.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.pixup.discoservice.domain.Disco;
import unam.diplomado.pixup.discoservice.repository.DiscoRepository;
import unam.diplomado.pixup.discoservice.service.DiscoService;

@RestController
@RequestMapping(path="api/artistas", produces="application/json")
@CrossOrigin(origins="*")
public class AristaController {
	
	@Autowired
	private DiscoRepository discoRepository;
	@Autowired
	private DiscoService discoService;
	
	@GetMapping
	public List<Disco> obtenerDiscos() {
		return discoRepository.findAll();
	}
	
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Disco crearDisco(@RequestBody Disco disco) {
		return discoRepository.save(disco);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Disco> obtenerDiscoPorId(@PathVariable("id") String id) {
		Optional<Disco> disco = discoRepository.findById(id);
		if (disco.isPresent()) {
			return new ResponseEntity<>(disco.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(path="{id}", consumes="application/json")
	public ResponseEntity<Disco> actualizarDisco(
			@PathVariable("id") String id, @RequestBody Disco disco) {
		Disco discoActualizado = discoService.actualizarDisco(id, disco);
		if (discoActualizado != null) {
			return new ResponseEntity<>(discoActualizado, HttpStatus.OK) ;
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarDisco(@PathVariable("id") String id) {
		discoRepository.deleteById(id);
	}

}

