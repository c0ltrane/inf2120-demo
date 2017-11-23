package Trivia.blockchain;

import java.security.PublicKey;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by thomas on 11/9/17.
 */
public class Transaction {
    public String source;
    public String destinataire;
    public long nonceId;
    public long quantite;

    public Transaction(PublicKey source, PublicKey destinataire, long quantite) {
        this.source = bytesToHex(source.getEncoded());
        this.destinataire = bytesToHex(destinataire.getEncoded());
        this.quantite = quantite;
        this.nonceId = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
    }

    private String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    @Override
    public String toString() {
        return "\n\t\tTransaction {" +
                "\n\t\t\tclee publique <source>='" + source + '\'' +
                ",\n\t\t\tclee publique <destinataire>='" + destinataire + '\'' +
                ",\n\t\t\tquantite=" + quantite +
                ",\n\t\t\tID=" + nonceId +
                "\n\t\t}";
    }

    // on redefini la methode hashCode pour que le hash reflete le contenu de la transaction
    // si on modifie ulterieurement une transaction le hash sera modifie et on saura qui'il y a eu modification de la chaine de transactions
    // cela permet de maintenir la propriete d'immutabilite sur la transaction
    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (destinataire != null ? destinataire.hashCode() : 0);
        result = 31 * result + (int) (nonceId ^ (nonceId >>> 32));
        result = 31 * result + (int) (quantite ^ (quantite >>> 32));
        return result;
    }

}
