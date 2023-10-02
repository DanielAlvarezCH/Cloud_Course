package unam.diplomado.pixup.discoservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.pixup.discoservice.domain.Disco;

public interface DiscoRepository 
	extends MongoRepository<Disco, String>{

}
