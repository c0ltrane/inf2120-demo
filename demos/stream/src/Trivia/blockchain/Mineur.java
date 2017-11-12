package Trivia.blockchain;

import java.util.LinkedList;

/**
 * Created by thomas on 11/11/17.
 */
public class Mineur {

    private Blockchain blockchain;

    public Mineur(Blockchain chain) {
        this.blockchain = chain;
    }

    public long miner(){


        long preuvePrecedente = blockchain.dernierBlock().getPreuveDeTravail() + 1;
        long nouvellePreuve = preuvePrecedente + 1;

        while(!(blockchain.preuveEstValide(preuvePrecedente, nouvellePreuve))){
            nouvellePreuve += 1;
        }
        return nouvellePreuve;
    }

}
