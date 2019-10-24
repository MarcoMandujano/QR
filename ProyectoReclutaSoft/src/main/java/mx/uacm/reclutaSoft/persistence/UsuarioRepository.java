package mx.uacm.reclutaSoft.persistence;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import mx.uacm.reclutaSoft.domain.Usuario;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	
	@Query(value="select * from Usuario where correo = :correo", nativeQuery=true)
	Usuario findByEmail(@Param("correo") String email);
	
	
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value="UPDATE usuario SET usuario.reputacion = :reputacion where usuario.correo = :correo", nativeQuery=true)
	int updateReputacionToUserByEmail(@Param("correo") String email, @Param("reputacion") int reputacion) throws AppExcepcion;
	
	
	@Query(value="select * from Usuario where correo = :correo AND contrasenia = MD5(:contrasenia)", nativeQuery=true)
	Usuario findByEmailAndPassword(@Param("correo") String email,@Param("contrasenia") String password);
	
	@Query(value="select * from pruebas.Usuario", nativeQuery=true)
	List<Usuario> findAllUsers();
	
	@Query(value="SELECT * FROM Usuario where id in (select usuario_id from Habilidad where tipo = :tipo and nombre = :nombreHabilidad)", nativeQuery=true)
	List<Usuario> findUsersByHabilidadTipoAndNombre(@Param("tipo") String tipo, @Param("nombreHabilidad") String nombreHabilidad);
}
