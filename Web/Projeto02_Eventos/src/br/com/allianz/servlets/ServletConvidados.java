package br.com.allianz.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.allianz.dao.ConvidadosDao;
import br.com.allianz.models.Convidado;
import br.com.allianz.models.Evento;
import br.com.allianz.repository.RepositorioDao;



@WebServlet({"/admin/convidados","/busca"})
public class ServletConvidados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletConvidados() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
			String path =request.getRequestURI();			
			
			List<Evento> listaEventos = RepositorioDao.getEventosDao().ListarEventos();			
			request.setAttribute("lista_eventos", listaEventos);
			
			List<Convidado> listaConvidados; 
			
			if(path.endsWith("busca")) {
				String id = request.getParameter("id");
				
				if (id != null) {
					
					listaConvidados = RepositorioDao.getConvidadosDao().ListarConvidados(Integer.parseInt(id));
					request.setAttribute("id_selected", id);
				}else {
					listaConvidados = RepositorioDao.getConvidadosDao().ListarConvidados();
				}				
			
				request.setAttribute("lista_convidados", listaConvidados);
				request.getRequestDispatcher("/WEB-INF/views/listaConvidados.jsp").include(request, response);
			
			}else {
			
				listaConvidados = RepositorioDao.getConvidadosDao().ListarConvidados();				
				request.setAttribute("lista_convidados", listaConvidados);			
				
				request.getRequestDispatcher("/WEB-INF/views/cadConvidados.jsp").include(request, response);
			}
		} catch (Exception e) {		
			
			request.setAttribute("erro", "ERRO: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/erro.jsp").forward(request, response);
		}	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			request.setAttribute("link_retorno","convidados" );
			
			int idEvento = Integer.parseInt(request.getParameter("evento"));
			String cpf = request.getParameter("cpf");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String telefone = request.getParameter("telefone");
			
			Convidado convidado = new Convidado();
			convidado.setCpf(cpf); 
			convidado.setNome(nome); 
			convidado.setEmail(email); 
			convidado.setTelefone(telefone);			
			Evento evento = new Evento();
			evento.setId(idEvento );
			convidado.setEvento(evento);
			
			ConvidadosDao dao = RepositorioDao.getConvidadosDao();
			
			dao.Incluir(convidado);
			
			request.setAttribute("mensagem", "Evento incluído com sucesso");			
			request.getRequestDispatcher("/WEB-INF/views/sucesso.jsp").forward(request, response);
			
		} catch (Exception e) {
			
			request.setAttribute("erro","ERRO: " + e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/erro.jsp").forward(request, response);

		}		
	}

}
