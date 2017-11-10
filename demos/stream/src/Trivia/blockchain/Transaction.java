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
}
