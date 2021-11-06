package medical.m2i.beans;

import java.util.List;

import medical.m2i.dao.UserDao;
import medical.m2i.model.User;

public class UsersBean {
	private List<User> listeUsers;
	private User user;

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getListeUsers() {
		return listeUsers;
	}

	public void setListeUsers(List<User> listeUsers) {
		this.listeUsers = listeUsers;
	}

	public UsersBean() throws ClassNotFoundException {
		// TODO Auto-generated constructor stub
		UserDao udao = new UserDao();
		listeUsers = udao.getUsers();

		user = new User();
		System.out.println("Je suis dans init bean user , taille de la liste = " + listeUsers.size());
	}

	public String saveUser() throws ClassNotFoundException {
		UserDao udao = new UserDao();
		//user.setUsername("admin2");
		udao.registerUser(user);
		// System.out.println(user.getNom());
		return "/done.xhtml?faces-redirect=true";
	}


}
