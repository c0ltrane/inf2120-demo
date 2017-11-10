package bibliotheque;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomas on 11/8/17.
 */
public class Bibliotheque {
    private List< Client > clients;
    private List< Livre > livres;
    private List< Emprunt > emprunts;

    public static final long LIMITE_PAR_CLIENT = 5;

    public Bibliotheque() {
        this.clients = new ArrayList< Client >();
        this.livres = new ArrayList< Livre >();
        this.emprunts = new ArrayList< Emprunt >();
    }

    public Bibliotheque(List<Client> clients, List<Livre> livres){
        this.clients = clients;
        this.livres = livres;
        this.emprunts = new ArrayList< Emprunt >();
    }

    public boolean estEmprunte (Livre livre){
        return this.emprunts.stream()
                .filter(unLivre -> unLivre.getLivre().equals(livre) )
                .count() > 0;
    }

    public boolean estEmprunteAlternatif (Livre livre){
        return this.emprunts.stream()
                .anyMatch(unLivre -> livre.equals(unLivre.getLivre()) );
    }

    public long nombreEmprunt (Client client){
        return this.emprunts.stream()
                .filter(emprunt -> emprunt.getClient().equals(client))
                .count();
    }

    public void emprunter (Client client, Livre livre) throws LivreDejaEmprunte, ClientAtteintLimite{
        if(estEmprunte(livre)){
            throw new LivreDejaEmprunte();
        }
        if(nombreEmprunt(client) > LIMITE_PAR_CLIENT){
           throw new ClientAtteintLimite();
        }
        this.emprunts.add(new Emprunt(livre, client));
    }

    public void afficherLivresDisponibles() {
        this.livres.stream()
                .filter(livre -> !estEmprunte(livre))
                .forEach(livre -> System.out.println("\t** " + livre.getTitre()));
    }

    public Object[] listeEmprunt (Client client){
        return this.emprunts.stream()
                .filter(emprunt -> emprunt.getClient().equals(client))
                .map(emprunt -> emprunt.getLivre())
                .toArray();
    }

    public double valeurInventaire(){
        return this.livres.stream()
                .mapToDouble(livre-> livre.getPrix())
                .sum();
    }

    public void devaloriser (double perte){
        this.livres.stream()
                .forEach(livre -> livre.setPrix(livre.getPrix()*(1-perte)));
    }


}
