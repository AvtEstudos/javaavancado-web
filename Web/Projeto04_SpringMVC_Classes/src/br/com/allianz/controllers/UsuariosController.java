package br.com.allianz.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.allianz.dao.UsuariosDao;
import br.com.allianz.models.Usuario;

@Controller
@Transactional
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuariosDao usuariosDao;	
	
	@RequestMapping("/cadastro")
	public String incluir() {
		return "usuarios/incluirUsuario";
	}	
	
	@RequestMapping(value="/cadusuario", method = RequestMethod.POST)
	public String incluir(@Valid Usuario usuario, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			//chamada via rota e não pagina
			return "forward:/usuarios/cadastro";
		}
		
		try {			
			
			usuariosDao.save(usuario);
			model.addAttribute("mensagem", "Evento Incluído");
			return "usuarios/incluirUsuario";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}		
		
	}		
	

}
