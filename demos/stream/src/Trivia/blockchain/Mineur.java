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

    public void miner(){

//        long preuveBidon = 1;
//        blockchain.ajouterBlock(preuveBidon, blockchain.dernierBlock().hashCode()); // donnera une erreur ! la chaine ne sera pas valide dans ce cas

//        PS: Dans notre code on peut toujours ajouter un bloc avec une preuve non valide mais dans un reseau distribue ce bloc est rejete par les autres mineurs!

        long preuveDeTravail = preuveDeTravail(blockchain.dernierBlock().getPreuveDeTravail());
        blockchain.ajouterBlock(preuveDeTravail, blockchain.dernierBlock().hashCode());
    }

    private long preuveDeTravail(long preuvePrecedente){
        long nouvellePreuve = preuvePrecedente + 1;

        while(!(blockchain.preuveEstValide(preuvePrecedente, nouvellePreuve))){
            nouvellePreuve += 1;
        }
        return nouvellePreuve;
    }
}
