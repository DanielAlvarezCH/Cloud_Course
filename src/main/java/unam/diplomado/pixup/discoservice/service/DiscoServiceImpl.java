package unam.diplomado.pixup.discoservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.diplomado.pixup.discoservice.domain.Disco;
import unam.diplomado.pixup.discoservice.repository.DiscoRepository;

@Service
public class DiscoServiceImpl implements DiscoService {
	
	@Autowired
	private DiscoRepository discoRepository;

	@Override
	public Disco actualizarDisco(String id, Disco disco) {
		Optional<Disco> discoExistente = discoRepository.findById(id);
		if (discoExistente.isPresent()) {
			Disco discoActualizar = discoExistente.get();
			discoActualizar.setNombre(disco.getNombre());
			discoRepository.save(discoActualizar);
			return discoActualizar;
		}
		return null;
	}

}
