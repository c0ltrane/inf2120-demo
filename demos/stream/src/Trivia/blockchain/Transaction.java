package Trivia.blockchain;

/**
 * Created by thomas on 11/9/17.
 */
public class Transaction {
    public String source;
    public String destinataire;
    public long quantite;

    public Transaction(String source, String destinataire, long quantite) {
        this.source = source;
        this.destinataire = destinataire;
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "\n\t\tTransaction {" +
                "\n\t\t\tsource='" + source + '\'' +
                ",\n\t\t\tdestinataire='" + destinataire + '\'' +
                ",\n\t\t\tquantite=" + quantite +
                "\n\t\t}";
    }


    // on redefini la methode hashCode pour que le hash reflete le contenu de la transaction
    // si on modifie ulterieurement une transaction le hash sera modifie et on saura qui'il y a eu modification de la chaine de transactions
    // cela permet de maintenir la propriete d'immutabilite sur la transaction
    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (destinataire != null ? destinataire.hashCode() : 0);
        result = 31 * result + (int) (quantite ^ (quantite >>> 32));
        return result;
    }
}
