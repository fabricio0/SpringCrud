package MasterCrud.SpringCrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import MasterCrud.SpringCrud.util.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	@Query("select a from Usuario a where a.nome like %?1%")
	List<Usuario> findUserByName(String nome);

	@Query("select u from Usuario u where u.login = ?1")
	public Usuario findUserById(String login);
}
