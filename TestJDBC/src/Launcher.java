import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Launcher {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost/biblio";
		String user = "postgres";
		String password = "678";
		
		Connection con = null;
		Statement sta = null;
		ResultSet rs = null;
		
		//Lister les auteurs 

		try {
			  Class.forName("org.postgresql.Driver");
			  con = DriverManager.getConnection(url, user, password);
			  
			  sta = con.createStatement();
			  String query = "SELECT * FROM Auteur";
			  System.out.println("query: "+query);
			  rs = sta.executeQuery(query);
			  
		      while ( rs.next() ) {
		    	  Long id = rs.getLong("id");
		    	  String nom = rs.getString("nom");
		    	  String prenom = rs.getString("prenom");
		    	  String telephone= rs.getString("telephone");
		    	  String email = rs.getString("email");
		    	  
		    	  System.out.println(id+ " " +nom+ " " +prenom+ " " +telephone+ " " +email);
		    	  
		      }
		      
		      rs.close();
		      sta.close();
		      
			  
	    } catch(SQLException ex) {
	    	ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("-------------------");
		
		//Récupérer un auteur à partir d'un ID
		Auteur auteur = new Auteur();
		try {
			  Class.forName("org.postgresql.Driver");
			  con = DriverManager.getConnection(url, user, password);
			  
			  

			  sta = con.createStatement();
			  String query = "SELECT * FROM Auteur where id=2";
			  System.out.println("query: "+query);
			  rs = sta.executeQuery(query);
		      if( rs.next() ) {
		    	  Long id = rs.getLong("id");
		    	  String nom = rs.getString("nom");
		    	  String prenom = rs.getString("prenom");
		    	  String telephone= rs.getString("telephone");
		    	  String email = rs.getString("email");
		    	  
		    	  System.out.println(id+ " " +nom+ " " +prenom+ " " +telephone+ " " +email);
		    	   
		      }
		      
		      rs.close();
		      sta.close();	  
			  
	    } catch(SQLException ex) {
	    	ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		System.out.println("-------------------");
		
		//Ajouter un auteur
		/*
		auteur = new Auteur("Anouar", "Sao", "0607080900", "anouar@sao.xyz");
		try {
			  Class.forName("org.postgresql.Driver");
			  con = DriverManager.getConnection(url, user, password);
			  
			  
			  sta = con.createStatement();
			  String query = "Insert into auteur(nom, prenom, telephone, email) VALUES ('"+auteur.getNom()+"', '"+auteur.getPrenom()+"', '"+auteur.getTelephone()+"', '"+auteur.getEmail()+"')";
		      System.out.println(query);
		      
			  sta.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			  
			  rs = sta.getGeneratedKeys();
			  if( rs.next() ) {
				  auteur.setId(rs.getLong(1));
			  }

		      rs.close();
		      sta.close();
		      
			  System.out.println(auteur);
			  
			  
			  
			  
			  
	    } catch(SQLException ex) {
	    	ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("-------------------");
		*/
		
		//Modifier un auteur
		/*
		try {
			  Class.forName("org.postgresql.Driver");
			  con = DriverManager.getConnection(url, user, password);
			  
			  sta = con.createStatement();
		      
			  auteur.setPrenom("Anouar");
			  
			  String query = "UPDATE Auteur SET nom='"+auteur.getNom()+"', prenom='"+auteur.getPrenom()+"', telephone='"+auteur.getTelephone()+"', email='"+auteur.getEmail()+"' WHERE id="+auteur.getId();

			  System.out.println(query);
			  sta.executeUpdate(query);
		      sta.close();
		      
			  System.out.println(auteur);
			  
			  
			  
	    } catch(SQLException ex) {
	    	ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("-------------------");
		*/
		
		//Supprimer un auteur
		/*
		try {
			  Class.forName("org.postgresql.Driver");
			  con = DriverManager.getConnection(url, user, password);
			  
			  
			  sta = con.createStatement();
			  String query ="DELETE FROM auteur WHERE id=6";
			  System.out.println(query);
			  
			  int statut = sta.executeUpdate(query);

		      sta.close();
		      
			  System.out.println(statut);
			  
			  
			  
			  
	    } catch(SQLException ex) {
	    	ex.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		
		
	}

}
