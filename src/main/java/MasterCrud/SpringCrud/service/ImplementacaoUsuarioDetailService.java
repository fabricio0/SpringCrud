package MasterCrud.SpringCrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import MasterCrud.SpringCrud.repository.UsuarioRepository;
import MasterCrud.SpringCrud.util.Usuario;

@Transactional
@Service
public class ImplementacaoUsuarioDetailService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public ImplementacaoUsuarioDetailService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = (Usuario) usuarioRepository.findUserById(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("usuário não encontrado");
		}else {
			return new User(usuario.getLogin(), usuario.getPassword(), usuario.isEnabled(), true, true, true, usuario.getAuthorities());
		}
	}

}
