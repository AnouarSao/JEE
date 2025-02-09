package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LivreDao;
import dao.AuteurDao;
import dao.DaoException;
import dao.DaoFactory;
import model.Auteur;
import model.Livre;

/**
 * Servlet implementation class modifierLivre
 */
@WebServlet("/modifierLivre")
public class ModifierLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AuteurDao auteurDao;
	private LivreDao livreDao;
  
	
    public ModifierLivre() {
        super();
        auteurDao = DaoFactory.getInstance().getAuteurDao();
        livreDao = DaoFactory.getInstance().getLivreDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		try {
			request.setAttribute("auteurs",auteurDao.lister());
			request.setAttribute("livre", livreDao.trouver(id));
	
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierLivre.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		String titre = request.getParameter("titreLivre");
		int nbPages = Integer.parseInt(request.getParameter("nbPagesLivre"));
		String categorie = request.getParameter("categorieLivre");
		
		long idAuteur = Long.parseLong(request.getParameter("idAuteur"));
		
		long id = Long.parseLong(request.getParameter("id"));
		
		
		try {
			Auteur auteur = auteurDao.trouver(idAuteur);
	
			Livre livre = livreDao.trouver(id);
			
			livre.setAuteur(auteur);
			livre.setTitre(titre);
			livre.setNbPages(nbPages);
			livre.setCategorie(categorie);
			
			livreDao.modifier(livre);
			
			request.getSession().setAttribute("confirmMessage", "Le livre a bien été modifié !");
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
	
		response.sendRedirect( request.getContextPath() + "/listeLivres" );
	}

}

