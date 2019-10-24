package mx.uacm.reclutaSoft.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mx.uacm.reclutaSoft.domain.Proyecto;

public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {
	
	@Query(value="select * from proyecto", nativeQuery=true)
	List<Proyecto> findAllProjects();
}
