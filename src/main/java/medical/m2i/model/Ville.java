package medical.m2i.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@NamedQuery(name="Ville.findAllByPays",query="SELECT "
public class Ville implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 150)
	private String nom;

	@Column(nullable = false, length = 150)
	private Integer code_postal;

	@Column
	private String pays;
	
	public Ville() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nom
	 * @param code_postal
	 */
	public Ville(Integer id, String nom, Integer code_postal, String pays) {
		super();
		this.id = id;
		this.nom = nom;
		this.code_postal = code_postal;
		this.pays = pays;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the code_postal
	 */
	public Integer getCode_postal() {
		return code_postal;
	}

	/**
	 * @param code_postal the code_postal to set
	 */
	public void setCode_postal(Integer code_postal) {
		this.code_postal = code_postal;
	}

	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	
}
