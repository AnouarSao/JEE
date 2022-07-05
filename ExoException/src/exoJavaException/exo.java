package exoJavaException;

import java.util.Scanner;
import java.util.ArrayList;

public class exo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Integer> listeNombres = new ArrayList<>();
        boolean isContinuer=true;
        System.out.println("Veuiller entrer des nombres un à un, entrer q pour quitter.");

        while (isContinuer) {
            System.out.print("Entrer un nombre : ");
            String entree = input.nextLine();
            try {
                int entreChiffree=Integer.valueOf(entree);
                if(!listeNombres.contains(entreChiffree)){
                    listeNombres.add(entreChiffree);
                }else {
                    System.out.println("Le chiffre "+entreChiffree+" a deja ete entre à la saisie "+ listeNombres.indexOf(entreChiffree)+1+". Veuillez entrer un autre chiffre." );
                }
            } catch (Exception e){
                if(entree.equals("q")){
                    System.out.println("Vous venez de quitter.");
                    isContinuer=false;
                }else{
                    System.out.println("Entre non valide. Recommencez.");
                }
            }
        }
        System.out.println("La liste de nombres est la suivante : "+listeNombres);
        System.out.println("Vous avez saisi "+listeNombres.size()+" nombres.");
    }
}
