package br.com.rd.quartaturma.grupo1.servlet;

import java.io.IOException;
import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rd.quartaturma.grupo1.entity.CrudEntityManager;
import br.com.rd.quartaturma.grupo1.entity.PlanosEntity;


@WebServlet("/planos")
public class PlanosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EntityManager em = CrudEntityManager.getEntityManager();
 
    public PlanosServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			Long idServicoPlano = Long.parseLong(idSPlano);
			//String id = request.getParameter("id");		
			
			PlanosEntity planosEntity = new PlanosEntity();
			planoEntity.setIdPlano(null);
			planoEntity.setNmPLano(nmPlano);
			planosEntity.setDsPlano(dsPlano);
			planosEntity.setVlPlano(vlPlano);
			planosEntity.setIdServicoPlano(BigInteger.valueOf(idServicoPlano));
				
			em.getTransaction().begin();
			em.persist(planosEntity);
			em.getTransaction().commit();
		
	}

}
