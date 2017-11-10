package Trivia.blockchain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomas on 11/9/17.
 */
public class Block {

    private List<Transaction> transactions;
    private long preuveDeTravail;
    private long hashPrecedent;
    private Timestamp timestamp;
    private int index;


    public Block(long preuveDeTravail, long hashPrecedent, List<Transaction> transactions, int index) {
        this.preuveDeTravail = preuveDeTravail;
        this.hashPrecedent = hashPrecedent;
        this.transactions = transactions;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public long getHashPrecedente() {
        return hashPrecedent;
    }

    public long getPreuveDeTravail() {
        return preuveDeTravail;
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

    @Override
    public String toString() {
        return "Block {" +
                "\n\tindex=" + index +
                ",\n\thashPrecedent=" + hashPrecedent +
                ",\n\tpreuveDeTravail=" + preuveDeTravail +
                ",\n\ttimestamp=" + timestamp +
                ",\n\ttransactions=" + transactions +
                "\n}";
    }

    // ici comme pour une transaction on redefini le hash du bloc pour garantir l'immutabilite de celui-ci
    // si un agent malveillant modifie ulterieurement un element du bloc le hash sera aussi modifie et ne correspondra
    // plus au hash dans le bloc suivant
    @Override
    public int hashCode() {
        int result = transactions != null ? transactions.hashCode() : 0;
        result = 31 * result + (int) (preuveDeTravail ^ (preuveDeTravail >>> 32));
        result = 31 * result + (int) (hashPrecedent ^ (hashPrecedent >>> 32));
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + index;
        return result;
    }
}
