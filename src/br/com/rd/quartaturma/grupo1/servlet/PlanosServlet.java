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


@WebServlet("/planos")
public class PlanosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EntityManager em = CrudEntityManager.getEntityManager();
 
    public PlanosServlet() {
        super();
        
    }
    RequestDispatcher rd = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		
		if(acao == null) {
			this.listarPlanos(request, response);
	//	}else if(acao.equals("editar")) {
	//		this.editarPlanos(request, response);
	//	}else if(acao.equals("excluir")){
	//		this.excluirPlanos(request, response);
		}else if(acao.equals("novo")) {
			RequestDispatcher rd = request.getRequestDispatcher("/pages/nova-cidade.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void listarPlanos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		
        Query query = em.createNamedQuery("Planos.findAll", PlanosEntity.class);
		
      
        List<PlanosEntity> planosEntity = query.getResultList();
        
       
        request.setAttribute("planos", planosEntity);
		
		rd = request.getRequestDispatcher("/pages/consulta-planos.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlanosEntity planosEntity = new PlanosEntity();
		String acao = request.getParameter("acao");

		if (acao.equals("novo"))
			this.inserirPlano(planosEntity, request);
		
		//listarPlanos(request, response);
	}
	

	
	private void inserirPlano(PlanosEntity planoEntity, HttpServletRequest request) {
			
			String nmPlano = request.getParameter("nmPlano");
			String dsPlano = request.getParameter("dsPlano");
			Double vlPlano = Double.valueOf("vlPlano");
			String idSPlano =request.getParameter("idServicoPlano");
			//String id = request.getParameter("id");		
			
			PlanosEntity planosEntity = new PlanosEntity();
			ServicoPlanoEntity servicoPlanoEntity =  em.find(ServicoPlanoEntity.class, new BigInteger(idSPlano));
			
			planosEntity.setServicoPlano(servicoPlanoEntity);
			
			planosEntity.setIdPlano(null);
			planosEntity.setNmPlano(nmPlano);
			planosEntity.setDsPlano(dsPlano);
			planosEntity.setVlPlano(vlPlano);
			
				
			em.getTransaction().begin();
			em.persist(planosEntity);
			em.getTransaction().commit();
		
	}

}
