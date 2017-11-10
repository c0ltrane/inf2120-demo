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

    @Override
    public String toString() {
        return "Block {" +
                ",\n\tindex=" + index +
                "\n\ttransactions=" + transactions +
                ",\n\tpreuveDeTravail=" + preuveDeTravail +
                ",\n\thashPrecedente=" + hashPrecedent +
                ",\n\ttimestamp=" + timestamp +
                "\n}";
    }

}
