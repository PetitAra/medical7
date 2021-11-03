package medical.m2i.controller.ville;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.dao.PatientDao;
import medical.m2i.dao.VilleDao;
import medical.m2i.model.Patient;
import medical.m2i.model.Ville;

/**
 * Servlet implementation class EditVilleServlet
 */
@WebServlet("/EditVilleServlet")
public class EditVilleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditVilleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		VilleDao villeDao = new VilleDao();
		Ville v = villeDao.getVille(id);
		request.setAttribute("villeparam",v);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/villeedit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupérer les infos soumises

		System.out.println("Je suis bien dans la méthode post");
		String nom = request.getParameter("nom");
		String pays = request.getParameter("pays");

		int code_postal = Integer.parseInt( request.getParameter("code_postal") );
		int id = Integer.parseInt(request.getParameter("id"));

		// Mettre à jour le patient en question
		VilleDao villeDao = new VilleDao();
		System.out.println("ok dans edit ville" + id);
		villeDao.editVille(id, nom, code_postal, pays);

		response.sendRedirect(request.getContextPath() + "/ListVilleServlet");
	}
}
