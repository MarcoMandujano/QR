package mx.uacm.reclutaSoft.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mx.uacm.reclutaSoft.domain.Taller;

public interface TallerRepository extends CrudRepository<Taller, Long> {

	@Query(value="select * from taller", nativeQuery=true)
	List<Taller> findAllTalleres();
}
