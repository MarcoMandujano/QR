package mx.uacm.reclutaSoft.persistence;

import org.springframework.data.repository.CrudRepository;

import mx.uacm.reclutaSoft.domain.Evento;

public interface EventoRepository extends CrudRepository<Evento, Long> {

}
