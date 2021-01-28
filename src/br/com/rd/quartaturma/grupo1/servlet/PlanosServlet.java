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
    

	// Metodo GET -----------------------------
	protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
	
		
		if(acao == null) {
			this.listarPlanos(request, response);
		}else if(acao.equals("editar")) {
			this.editarPlano(request, response);
		}else if(acao.equals("excluir")){
			this.excluirPlano(request, response);
		}else if(acao.equals("novo")) {
			RequestDispatcher rd = request.getRequestDispatcher("/pages/cadastro-plano.jsp");
			rd.forward(request, response);
		}
	}
	
	// LISTAR PLANOS - Jemima
	protected void listarPlanos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;

		Query query = em.createNamedQuery("Planos.findAll", PlanosEntity.class);

		List<PlanosEntity> planosEntity = query.getResultList();

		request.setAttribute("planos", planosEntity);

		rd = request.getRequestDispatcher("/pages/consulta-planos.jsp");
		rd.forward(request, response);
	}


	// Metodo POST -----------------------------
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String acao = request.getParameter("acao");
		if (acao.equals("novo"))
			this.cadastrarPlano(response, request);
		if (acao.equals("excluir"))
			this.excluirPlano(request, response);
		if (acao.equals("alterar"))
			this.atualizaPlano(response, request);
		
			listarPlanos(request,response);
	}
	
	//Atualizar Plano Jemima
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
			PlanosEntity planosEntity = em.find(PlanosEntity.class, new BigInteger(id));
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
				request.setAttribute("erro", "Erro ao alterar plano.");
				rd = request.getRequestDispatcher("/pages/erro.jsp");
				e.printStackTrace();
			}
		}
		

		private void editarPlano( HttpServletRequest request ,HttpServletResponse response)throws ServletException, IOException {
			RequestDispatcher rd = null;
				
				String id = request.getParameter("id");
				
				try {
				
				PlanosEntity planosEntity = em.find(PlanosEntity.class, new BigInteger(id));
				request.setAttribute("plano", planosEntity);
				
				
				rd = request.getRequestDispatcher("/pages/alterar-plano.jsp");
				rd.forward(request, response);
				
				}catch (Exception e) {
					request.setAttribute("erro", "Erro ao editar plano.");
					rd = request.getRequestDispatcher("/pages/erro.jsp");
					rd.forward(request, response);
					e.printStackTrace();
				}

			}
	
		// EXCLUIR PLANO - Monique
		protected void excluirPlano(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			RequestDispatcher rd = null;
			String id = request.getParameter("id");

			try {
				PlanosEntity planoEntity = em.find(PlanosEntity.class, new BigInteger(id));
				request.setAttribute("plano", planoEntity);

				em.getTransaction().begin();
				em.remove(planoEntity);
				em.getTransaction().commit();

				this.listarPlanos(request, response);

			} catch (Exception e) {
				request.setAttribute("erro", "Erro ao excluir plano.");
				e.printStackTrace();
			}
		}

		
		
	
		// CADASTRAR PLANO - Monique
		private void cadastrarPlano(HttpServletResponse response, HttpServletRequest request)
				throws ServletException, IOException {

			RequestDispatcher rd = null;

			String nmPlano = request.getParameter("nmPlano");
			String dsPlano = request.getParameter("dsPlano");
			String vlPlano = request.getParameter("vlPlano");
			Double vlPlanoDouble = Double.valueOf(vlPlano);
			String idSPlano = request.getParameter("idServicoPlano");
			// String id = request.getParameter("id");

			PlanosEntity planosEntity = new PlanosEntity();
			ServicoPlanoEntity servicoPlanoEntity = em.find(ServicoPlanoEntity.class, new BigInteger(idSPlano));

			planosEntity.setIdPlano(null);
			planosEntity.setNmPlano(nmPlano);
			planosEntity.setDsPlano(dsPlano);
			planosEntity.setVlPlano(vlPlanoDouble);
			planosEntity.setServicoPlano(servicoPlanoEntity);

			em.getTransaction().begin();
			em.persist(planosEntity);
			em.getTransaction().commit();

			//rd = request.getRequestDispatcher("/pages/cadastro-plano.jsp");
			//rd.forward(request, response);
			
			listarPlanos(request, response);

		}
	
		
}
