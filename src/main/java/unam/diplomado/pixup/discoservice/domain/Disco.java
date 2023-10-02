package unam.diplomado.pixup.discoservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection="discos")
public class Disco {

	@Id
	private String id;
	private String nombre;
	
}