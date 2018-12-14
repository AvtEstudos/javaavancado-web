package br.com.allianz.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.allianz.dao.UsuariosDao;

import br.com.allianz.models.Usuario;
import br.com.allianz.repository.RepositorioDao;

@WebServlet({"/admin/cadusuarios", "/login"})
public class ServletUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;       

    public ServletUsuarios() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path =request.getRequestURI();
		String destino;
		if(path.endsWith("cadusuarios")) {			
			destino = "/WEB-INF/views/cadUsuario.jsp";
		}else {
			destino = "/WEB-INF/views/validarUsuario.jsp";
		}
		
		request.getRequestDispatcher(destino).forward(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {			
			
			String path =request.getRequestURI();
			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");			
			
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setSenha(senha);
			
			if(path.endsWith("cadusuarios")) {			
			
				int nivel = Integer.parseInt(request.getParameter("nivel"));				
				usuario.setNivel(nivel);
				
				UsuariosDao dao = RepositorioDao.getUsuariosDao();				
				dao.Incluir(usuario);
				
				request.setAttribute("mensagem", "Usuário incluído com sucesso");	
				request.getRequestDispatcher("/WEB-INF/views/cadUsuario.jsp").forward(request, response);
			}else {
				
				UsuariosDao dao = RepositorioDao.getUsuariosDao();
				usuario = dao.Buscar(nome, senha);
				
				if (usuario == null) {
					request.setAttribute("mensagem", "Senha ou usuário inválido");	
					request.getRequestDispatcher("/WEB-INF/views/validarUsuario.jsp").forward(request, response);					
				}else {
					HttpSession session = request.getSession();
					session.setAttribute("sessao_usuario", usuario);
					
					//List<Evento> listaEventos = RepositorioDao.getEventosDao().ListarEventos();
					//request.setAttribute("lista_eventos", listaEventos);					
					//request.getRequestDispatcher("/WEB-INF/views/cadEventos.jsp").include(request, response);	
					
					response.sendRedirect("/Projeto02_Eventos/admin/eventos");
					
				}					
				
			}				
			
		} catch (Exception e) {
			
			request.setAttribute("erro","ERRO: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/erro.jsp").forward(request, response);

		}		

	}

}
