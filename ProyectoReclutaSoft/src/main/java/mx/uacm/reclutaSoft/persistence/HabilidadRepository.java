package mx.uacm.reclutaSoft.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mx.uacm.reclutaSoft.domain.Habilidad;

public interface HabilidadRepository extends CrudRepository<Habilidad, Long> {
	
	@Query(value="SELECT * FROM Habilidad where usuario_id = (SELECT id FROM Usuario where nombre = :nombre)", nativeQuery=true)
	List<Habilidad> findHabilidadesByUserName(@Param("nombre") String nombre);
}
