package br.com.allianz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.allianz.models.Usuario;

@WebServlet(
		urlPatterns = { "/login" }, 
		initParams = { 
				@WebInitParam(name = "user", value = "admin"), 
				@WebInitParam(name = "password", value = "admin")
		})
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;     
   
    public ServletLogin() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("index.jsp");
		
		//		PrintWriter out = response.getWriter();
		//		response.setContentType("text/html"); //MIME Type
		//		out.print("<h1>Exemplo de requisição GET</h1>");		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		try {
			String sNome = request.getParameter("nome");
			String sSenha = request.getParameter("senha");
			
			ServletConfig config = this.getServletConfig();
			String sUser = config.getInitParameter("user");
			String sPassword = config.getInitParameter("password");			
			
			response.setContentType("text/html"); //MIME Type
			
			if(sNome.equals(sUser) && sSenha.equals(sPassword) ) {
				
				Usuario usuario = new Usuario();
				usuario.setNomeUsuario(sNome);
				usuario.setSenhaUsuario(sSenha);
				
				request.setAttribute("nome_usuario", usuario);
				request.getRequestDispatcher("/WEB-INF/sucesso.jsp").forward(request, response);
				
			}else {
				//out.print("Usuário ou senha inválidos!");
				throw new IllegalArgumentException("Usuário ou senha inválidos");
			}
		} catch (Exception e) {			
			//out.print("Erro: " + e.getMessage());
			
			request.setAttribute("mensagem_error", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/erro.jsp").forward(request, response);
			
		}		
	}

}
