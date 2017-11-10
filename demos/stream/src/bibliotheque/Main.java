package bibliotheque;

import java.util.Arrays;
import java.util.List;
import static java.lang.System.out;

/**
 * Created by thomas on 11/8/17.
 */
public class Main {
    public static void main(String[] args) {
        List<Client> clients = Arrays.asList(
                new Client("Jimmy", "Hendrix", "JH001"),
                new Client("Jimmy", "Page", "JP002"),
                new Client("Eddie", "Van Halen", "EV003"),
                new Client("David", "Gilmour", "DG004"),
                new Client("Jeff", "Beck", "JB005"),
                new Client("Brian", "May", "BM006")
        );

        List<Livre> livres = Arrays.asList(
                new Livre("Godel Escher Bach", "xxx01", 40),
                new Livre("Data Intensive Applications", "xxx02", 40),
                new Livre("Building Microservices", "xxx03", 50),
                new Livre("Hacking, the art of exploitation", "xxx04", 30),
                new Livre("An introduction to statistical learning", "xxx05", 50),
                new Livre("How to read a film", "xxx06", 20)
        );

        Bibliotheque bibli = new Bibliotheque(clients, livres);

        try{

            bibli.emprunter(clients.get(0), livres.get(0));
            bibli.emprunter(clients.get(1), livres.get(2));
            bibli.emprunter(clients.get(0), livres.get(1));
            bibli.emprunter(clients.get(2), livres.get(3));

        } catch(Exception e){

            out.println("erreur d'emprunt");
        }

        out.println("Livres disponibles:");
        bibli.afficherLivresDisponibles();

        estDispo(bibli.estEmprunte(livres.get(5)), livres.get(5));

        try{

            bibli.emprunter(clients.get(2), livres.get(5));

        } catch(Exception e){

            out.println("erreur d'emprunt");
        }

        out.println();
        out.println("Livres disponibles:");
        bibli.afficherLivresDisponibles();
        estDispo(bibli.estEmprunte(livres.get(5)), livres.get(5));

        out.println();
        Client eddie = clients.get(2);
        String nomEddie = eddie.getPrenom() + " " + eddie.getNom();
        out.println(nomEddie + " a emprunte " + bibli.nombreEmprunt(eddie) + " livres");
        out.println("Les livres empruntes par " + nomEddie+ " sont:");
        Object[] livresEmpruntes = bibli.listeEmprunt(eddie);
        for (int i = 0; i < livresEmpruntes.length; i++){
            out.println("\t** " + ((Livre)livresEmpruntes[i]).getTitre());
        }

        out.println();
        out.println("La valeur totale de l'inventaire est de: " + bibli.valeurInventaire());
        double perte = 0.1;
        bibli.devaloriser(perte);
        out.println("Apres une devalorisation de " + perte*100 + "% la valeur totale de l'inventaire est de: " + bibli.valeurInventaire());
    }


    public static void estDispo (boolean disponible, Livre livre){
        String disponibilite = !disponible ? "disponible" : "indisponible";
        out.println("Le livre '" + livre.getTitre() + "' est " + disponibilite);
    }
}
