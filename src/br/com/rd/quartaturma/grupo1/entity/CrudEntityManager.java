package br.com.rd.quartaturma.grupo1.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CrudEntityManager {

	 private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("BD_PI_QUARTA_TURMA");  
	 
	    public static EntityManager getEntityManager() {
	        return emFactory.createEntityManager();
	    }
}
