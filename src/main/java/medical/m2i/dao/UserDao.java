package medical.m2i.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import medical.m2i.model.User;

public class UserDao {

	EntityManager em;

	public UserDao() {
		em = DbConnection.getInstance(); 
	}

	public List<User> getUsers() throws ClassNotFoundException {
		return em.createQuery("from User" , User.class).getResultList();
	}
	
	public List<User> getUsersByUsernameAndPassword( String pusername, String ppassword ) throws ClassNotFoundException {
		return em.createNamedQuery("User.findByUsernameAndPassword", User.class)
				.setParameter("username", pusername)
				.setParameter("password", ppassword)
				.getResultList(); 
	}

	public int registerUser(User user) {
		int id = 0;

		// Récupération d’une transaction
		EntityTransaction tx = em.getTransaction();
		// Début des modifications
		try {
			tx.begin();
			em.persist(user);
			tx.commit();
			id = user.getId();
		} catch (Exception e) {

			tx.rollback();
		} finally {
			// em.close();
			// emf.close();
		}
		System.out.println("id du user : " + id);
		return id;
		
		
	}

}