package MasterCrud.SpringCrud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import MasterCrud.SpringCrud.repository.UsuarioRepository;
import MasterCrud.SpringCrud.util.Usuario;

@Controller
public class UserController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping( method = RequestMethod.GET, value = "**/user")
	public ModelAndView userIndex() {
		ModelAndView modelAndView = new ModelAndView("homeUser");
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
		modelAndView.addObject("usuarios", usuarios);
		modelAndView.addObject("usuarioEdit", new Usuario());
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/salvarUser")
	public String salvarUsuario(@Valid Usuario usuario, BindingResult bindingResult) {
		usuarioRepository.save(usuario);
		return "redirect:/user";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/editarUsuario/{idUsuario}")
	public ModelAndView editarUsuario(@PathVariable("idUsuario") Long id) {
		ModelAndView modelo = new ModelAndView("homeUser");
		Optional<Usuario> user = usuarioRepository.findById(id);
		modelo.addObject("usuarioEdit", user.get());
		return modelo;
	}
	@RequestMapping(method = RequestMethod.GET, value = "/excluirUsuario/{idUsuario}")
	public ModelAndView excluirUsuario(@PathVariable("idUsuario") Long id) {
		ModelAndView modelo = new ModelAndView("homeUser");
		usuarioRepository.deleteById(id);
		modelo.addObject("usuarioEdit", new Usuario());
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
		modelo.addObject("usuarios", usuarios);
		return modelo;
	}
	
	@PostMapping("/pesquisaPorNome")
	public ModelAndView pesquisaPorNome(@RequestParam("nomeUsuario") String nomeUsuario) {
		ModelAndView modelo = new ModelAndView("homeUser");
		List<Usuario> user = usuarioRepository.findUserByName(nomeUsuario);
		modelo.addObject("usuarioEdit", new Usuario());
		modelo.addObject("usuarios", user);
		return modelo;
	}
}
