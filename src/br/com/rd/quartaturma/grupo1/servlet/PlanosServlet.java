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
	protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
	
		
		if(acao == null) {
			this.listarPlanos(request, response);
		}else if(acao.equals("editar")) {
			this.editarPlano(request, response);
	//	}else if(acao.equals("excluir")){
		//	this.excluirPlanos(request, response);
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

		if (acao.equals("alterar"))
			this.atualizaPlano(response, request);
	//	else if(acao.equals("novo"))
	// 		this.inserirPlano(response, request);
		
		listarPlanos(request, response);
	}
	
	//MÉTODO POST ATUALIZAR
		private void atualizaPlano(HttpServletResponse response, HttpServletRequest request) {
			RequestDispatcher rd = null;
			
			//capturar dados passados pelo form
			String nmPlano = request.getParameter("nmPlano");
			String dsPlano = request.getParameter("dsPlano");
			String vlPlano = request.getParameter("vlPlano");
			Double vlPlanoDouble =  Double.valueOf(vlPlano);
			String idSPlano =request.getParameter("idServicoPlano");
			String id = request.getParameter("id");
			try {
			//pegar a cidade
			PlanosEntity planosEntity = em.find(PlanosEntity.class, new String(id));
			planosEntity.setNmPlano(nmPlano);
			planosEntity.setDsPlano(dsPlano);
			planosEntity.setVlPlano(vlPlanoDouble);
			
			ServicoPlanoEntity servicoPlanoEntity =  em.find(ServicoPlanoEntity.class, new BigInteger(idSPlano));
			
			planosEntity.setServicoPlano(servicoPlanoEntity);
			
			//alterar a cidade
			em.getTransaction().begin();
			em.merge(planosEntity);
			em.getTransaction().commit();
			
			//mostrar a lista novamente
			this.listarPlanos(request, response);
			
			}catch (Exception e) {
				request.setAttribute("erro", "Erro ao alterar cidade.");
				rd = request.getRequestDispatcher("/SCREENS/erro.jsp");
				e.printStackTrace();
			}
		}
	

		private void editarPlano( HttpServletRequest request ,HttpServletResponse response)throws ServletException, IOException {
			RequestDispatcher rd = null;
				
				String id = request.getParameter("id");
				
				try {
				
				PlanosEntity planosEntity = em.find(PlanosEntity.class, new BigInteger(id));
				request.setAttribute("plano", planosEntity);
				
				
				rd = request.getRequestDispatcher("/pages/editar-planos.jsp");
				rd.forward(request, response);
				
				}catch (Exception e) {
					request.setAttribute("erro", "Erro ao editar plano.");
					rd = request.getRequestDispatcher("/pages/erro.jsp");
					rd.forward(request, response);
					e.printStackTrace();
				}

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
