package medical.m2i.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import medical.m2i.model.Patient;
import medical.m2i.model.Ville;

public class VilleDao {

	EntityManager em;

	public VilleDao() {
		em = DbConnection.getInstance(); 
	}

	public List<Ville> getVilles() throws ClassNotFoundException {
		return em.createQuery("from Ville").getResultList();
	}
	
	public List<Ville> getVillesByPays( String pays ) throws ClassNotFoundException {
		return em.createNamedQuery("Ville.findByPaysName", Ville.class).setParameter("name", pays).getResultList(); 
	}

	public void deleteVilles(int id) {
		
		Ville v = em.find(Ville.class,id);
		// Récupération d’une transaction
				EntityTransaction tx = em.getTransaction();
				// Début des modifications
				try {
					tx.begin();
					em.remove(v);
					tx.commit();
				} catch (Exception e) {

					tx.rollback();
				} finally {
					// em.close();
					// emf.close();
				}
				System.out.println("id de la ville supprimé: " + id);
		
	}

	public Ville getVille(int id) {
		return em.find(Ville.class,id);
	}

	public void editVille(int id, String nom, Integer code_postal, String pays) {
		Ville v = em.find( Ville.class , id );
		EntityTransaction tx = em.getTransaction();
		
		v.setNom(nom);
		v.setCode_postal(code_postal);
		v.setPays(pays);
		
		System.out.println( "edit ville" + nom + ", " + code_postal + " : " + pays );
		
		
		// Début des modifications
		try {
			tx.begin();
			em.persist(v);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Erreur" );
			e.getStackTrace(); 
		} finally {
			// em.close(); 
			// emf.close();
		}
		
	}

	public int registerVille(Ville ville) {
		int id = 0;

		// Récupération d’une transaction
		EntityTransaction tx = em.getTransaction();
		// Début des modifications
		try {
			tx.begin();
			em.persist(ville);
			tx.commit();
			id = ville.getId();
		} catch (Exception e) {

			tx.rollback();
		} finally {
			// em.close();
			// emf.close();
		}
		System.out.println("id de la ville : " + id);
		return id;
		
	}

}