package mx.uacm.reclutaSoft.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mx.uacm.reclutaSoft.domain.Evento;

public interface EventoRepository extends CrudRepository<Evento, Long> {
	
	@Query(value="select * from evento", nativeQuery=true)
	List<Evento> findAllEventos();
}
