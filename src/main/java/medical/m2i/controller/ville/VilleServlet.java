package medical.m2i.controller.ville;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.dao.VilleDao;
import medical.m2i.model.Ville;

/**
 * Servlet implementation class VilleServlet
 */
@WebServlet("/VilleServlet")
public class VilleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VilleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Je suis bien dans la méthode post");
		String nom = request.getParameter("nom");
		String pays = request.getParameter("pays");

		int code_postal = Integer.parseInt( request.getParameter("code_postal") );


		Ville ville = new Ville();
		ville.setNom(nom);
		ville.setPays(pays);
		ville.setCode_postal(code_postal);
		
		VilleDao villeDao = new VilleDao();
		villeDao.registerVille(ville);
		
		response.sendRedirect(request.getContextPath() + "/ListVilleServlet");
	}
}
