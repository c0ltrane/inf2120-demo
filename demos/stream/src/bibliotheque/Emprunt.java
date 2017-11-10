package bibliotheque;

/**
 * Created by thomas on 11/8/17.
 */
public class Emprunt {
    private Livre livre;
    private Client client;

    public Emprunt( Livre livre, Client client ) {
        this.livre = livre;
        this.client = client;
    }

    public Livre getLivre() {
        return livre;
    }

    public Client getClient() {
        return client;
    }
}
