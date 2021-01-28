package br.com.rd.quartaturma.grupo1.servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rd.quartaturma.grupo1.entity.CrudEntityManager;
import br.com.rd.quartaturma.grupo1.entity.PlanosEntity;
import br.com.rd.quartaturma.grupo1.entity.ServicoPlanoEntity;

/**
 * Servlet implementation class ServicoPlanoServlet
 */
@WebServlet("/servicos-plano")
public class ServicoPlanoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EntityManager em = CrudEntityManager.getEntityManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServicoPlanoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    RequestDispatcher rd = null;
  //MÉTODO GET **************************************************
  	/**
  	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  	 */
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		String acao = request.getParameter("acao");
  		

		
  		if(acao == null) {
  			this.listarServPlano(request, response);
  		}else if(acao.equals("editar")) {
  			this.editarServPlano(request, response);
  		}else if(acao.equals("excluir")){
  			this.excluirServPlano(request, response);
  		}else if(acao.equals("novo")) {
  			RequestDispatcher rd = request.getRequestDispatcher("/pages/cadastro-servico-plano.jsp");
  			rd.forward(request, response);
  		}
  	}
  	
  	//MÉTODO GET LISTAR
  	protected void listarServPlano(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		RequestDispatcher rd = null;
  		
  		//receber dados do banco com query especial
          Query query = em.createNamedQuery("ServicoPlano.findAll", ServicoPlanoEntity.class);
  		
          //criar lista
          List<ServicoPlanoEntity> servPlanoEntity = query.getResultList();
          
          //passar lista para a página
          request.setAttribute("servPlano", servPlanoEntity);
  		
  		rd = request.getRequestDispatcher("/pages/consulta-servico-plano.jsp");
  		rd.forward(request, response);
  	}
  	
  	//MÉTODO GET EDITAR
  	protected void editarServPlano(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		RequestDispatcher rd = null;
  		
  		String id = request.getParameter("id");
  		
  		try {
  		//pegar o serviço
  		ServicoPlanoEntity servPlanoEntity = em.find(ServicoPlanoEntity.class, new BigInteger(id));
  		request.setAttribute("servPlano", servPlanoEntity);
  		
  		// Chamar JSP
  		rd = request.getRequestDispatcher("/pages/alterar-servico-plano.jsp");
  		rd.forward(request, response);
  		
  		}catch (Exception e) {
  			request.setAttribute("erro", "Erro ao serviço do plano.");
  			rd = request.getRequestDispatcher("/pages/erro.jsp");
  			rd.forward(request, response);
  			e.printStackTrace();
  		}

  	}
  	
  	//MÉTODO GET EXCLUIR
  	protected void excluirServPlano(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		RequestDispatcher rd = null;
  		
  		String id = request.getParameter("id");
  		
  		try {
  		//pegar o serviço
  		ServicoPlanoEntity servicoPlanoEntity = em.find(ServicoPlanoEntity.class, new BigInteger(id));
  		request.setAttribute("servPlano", servicoPlanoEntity);
  		
  		//excluir a cidade
  		em.getTransaction().begin();
  		em.remove(servicoPlanoEntity);
  		em.getTransaction().commit();
  		
  		this.listarServPlano(request, response);
  		
  		}catch (Exception e) {
  			request.setAttribute("erro", "Erro ao excluir serviço do plano.");
  			rd = request.getRequestDispatcher("/pages/erro.jsp");
  			rd.forward(request, response);
  			e.printStackTrace();
  		}
  	}
  	
  	
  	//MÉTODO POST **************************************************
  	/**
  	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  	 */
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		String acao = request.getParameter("acao");
  		
  		if(acao.equals("alterar"))
  			this.alteraServPlano(response, request);
  		else if(acao.equals("novo"))
  			this.insereServPlano(response, request);
  		
  		listarServPlano(request, response);
  	}
  	
  	//MÉTODO POST ALTERAR - MONIQUE
  	private void alteraServPlano(HttpServletResponse response, HttpServletRequest request) {
  		//TODO
  		

  	}
  	
  	//MÉTODO POST INSERIR - JEMIMA
  	private void insereServPlano(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
  		RequestDispatcher rd = null;

		
		String dsServico = request.getParameter("dsServico");
	
		
		
		ServicoPlanoEntity servicoplanoEntity = new ServicoPlanoEntity();

		servicoplanoEntity.setIdServicoPlano(null);
		servicoplanoEntity.setDsServico(dsServico);
		

	
		em.getTransaction().begin();
		em.persist(servicoplanoEntity);
		em.getTransaction().commit();

	//	rd = request.getRequestDispatcher("/pages/cadastro-servico-plano.jsp");
	//	rd.forward(request, response);
		
			this.listarServPlano(request, response);
		
		
		}
  	
}


