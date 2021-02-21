package MasterCrud.SpringCrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import MasterCrud.SpringCrud.util.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
//	@Query("select u from Usuario u where u.login = ?1")
//	public Usuario findUserById(String login);

}
