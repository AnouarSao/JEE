package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuteurDao;
import dao.DaoException;
import dao.DaoFactory;
import dao.LivreDao;


@WebServlet("/supprimerLivre")
public class SupprimerLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LivreDao livreDao;
    
       
  
    public SupprimerLivre() {
        super();
        livreDao = DaoFactory.getInstance().getLivreDao();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long id = Long.parseLong(request.getParameter("id"));
		
		try {
			 livreDao.supprimer(id);
			 
			 request.getSession().setAttribute("confirmMessage", "Le livre a bien été supprimé !");
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		
		response.sendRedirect(request.getContextPath() + "/listeLivres");
	}

}
