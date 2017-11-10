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
    private long hashPrecedente;
    private Timestamp timestamp;
    private int index;


    public Block(long preuveDeTravail, long hashPrecedente, List<Transaction> transactions, int index) {
        this.preuveDeTravail = preuveDeTravail;
        this.hashPrecedente = hashPrecedente;
        this.transactions = transactions;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public long getHashPrecedente() {
        return hashPrecedente;
    }

    public long getPreuveDeTravail() {
        return preuveDeTravail;
    }

    @Override
    public String toString() {
        return "Block {" +
                ",\n\tindex=" + index +
                "\n\ttransactions=" + transactions +
                ",\n\tpreuveDeTravail=" + preuveDeTravail +
                ",\n\thashPrecedente=" + hashPrecedente +
                ",\n\ttimestamp=" + timestamp +
                "\n}";
    }

}
