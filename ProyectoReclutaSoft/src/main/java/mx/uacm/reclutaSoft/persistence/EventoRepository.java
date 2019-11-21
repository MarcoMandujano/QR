package mx.uacm.reclutaSoft.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mx.uacm.reclutaSoft.domain.Evento;
import mx.uacm.reclutaSoft.domain.Habilidad;

public interface EventoRepository extends CrudRepository<Evento, Long> {
	
	@Query(value="SELECT * FROM EVENTO", nativeQuery=true)
	List<Evento> findAllEvent();
	
	@Query(value="SELECT * FROM EVENTO where id = :id", nativeQuery=true)
	Evento findEvent(@Param("id") int id);
	
}
