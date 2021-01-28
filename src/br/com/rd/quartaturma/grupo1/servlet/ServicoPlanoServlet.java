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

  //M�TODO GET **************************************************
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
  	
  	//M�TODO GET LISTAR
  	protected void listarServPlano(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		RequestDispatcher rd = null;
  		
  		//receber dados do banco com query especial
          Query query = em.createNamedQuery("ServicoPlano.findAll", ServicoPlanoEntity.class);
  		
          //criar lista
          List<ServicoPlanoEntity> servPlanoEntity = query.getResultList();
          
          //passar lista para a p�gina
          request.setAttribute("servPlano", servPlanoEntity);
  		
  		rd = request.getRequestDispatcher("/pages/consulta-servico-plano.jsp");
  		rd.forward(request, response);
  	}
  	
  	//M�TODO GET EDITAR
  	protected void editarServPlano(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		RequestDispatcher rd = null;
  		
  		String id = request.getParameter("id");
  		
  		try {
  		//pegar o servi�o
  		ServicoPlanoEntity servPlanoEntity = em.find(ServicoPlanoEntity.class, new BigInteger(id));
  		request.setAttribute("servPlano", servPlanoEntity);
  		
  		// Chamar JSP
  		rd = request.getRequestDispatcher("/pages/alterar-servico-plano.jsp");
  		rd.forward(request, response);
  		
  		}catch (Exception e) {
  			request.setAttribute("erro", "Erro ao servi�o do plano.");
  			rd = request.getRequestDispatcher("/pages/erro.jsp");
  			rd.forward(request, response);
  			e.printStackTrace();
  		}

  	}
  	
  	//M�TODO GET EXCLUIR
  	protected void excluirServPlano(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		RequestDispatcher rd = null;
  		
  		String id = request.getParameter("id");
  		
  		try {
  		//pegar o servi�o
  		ServicoPlanoEntity servicoPlanoEntity = em.find(ServicoPlanoEntity.class, new BigInteger(id));
  		request.setAttribute("servPlano", servicoPlanoEntity);
  		
  		//excluir a cidade
  		em.getTransaction().begin();
  		em.remove(servicoPlanoEntity);
  		em.getTransaction().commit();
  		
  		this.listarServPlano(request, response);
  		
  		}catch (Exception e) {
  			request.setAttribute("erro", "Erro ao excluir servi�o do plano.");
  			rd = request.getRequestDispatcher("/pages/erro.jsp");
  			rd.forward(request, response);
  			e.printStackTrace();
  		}
  	}
  	
  	
  	//M�TODO POST **************************************************
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
  	
  	//M�TODO POST ALTERAR - MONIQUE
  	private void alteraServPlano(HttpServletResponse response, HttpServletRequest request) {
	  		
		RequestDispatcher rd = null;
		  			
		String idServicoPlano = request.getParameter("idServicoPlano");
		String dsServico = request.getParameter("dsServico");
	
		
		try {
		ServicoPlanoEntity servicoPlano = em.find(ServicoPlanoEntity .class, new BigInteger(idServicoPlano));
		servicoPlano.setDsServico(dsServico);
				  		
		em.getTransaction().begin();
		em.merge(servicoPlano);
		em.getTransaction().commit();
		
		listarServPlano(request, response);
	  	  			
		}catch (Exception e) {
			request.setAttribute("erro", "Erro ao alterar Servi�o-Plano.");
			rd = request.getRequestDispatcher("/pages/erro.jsp");
			e.printStackTrace();
		}
  		

  	}
  	
  	//M�TODO POST INSERIR - JEMIMA
  	private void insereServPlano(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
  		RequestDispatcher rd = null;

		
		String dsPlano = request.getParameter("dsServico");
	
		ServicoPlanoEntity servicoPlanoEntity = new ServicoPlanoEntity();
		
		servicoPlanoEntity.setIdServicoPlano(null);
		servicoPlanoEntity.setDsServico(dsPlano);
	
		em.getTransaction().begin();
		em.persist(servicoPlanoEntity);
		em.getTransaction().commit();

		rd = request.getRequestDispatcher("/pages/cadastro-servico-plano.jsp");
		rd.forward(request, response);
		
			this.listarServPlano(request, response);
		
		
		}
  	
}


