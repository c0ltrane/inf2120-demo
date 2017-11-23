package Trivia.blockchain;

import java.io.IOException;
import java.security.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by thomas on 11/9/17.
 */
public class Blockchain {

    private LinkedList<Block> chaine;
    private List<TransactionWrapper> transactionsCourantes;
    private int index;

    public Blockchain() {
        chaine = new LinkedList<>();
        transactionsCourantes = new ArrayList<>();
        index = 0;

        System.out.println("/****  Creation de la Blockchain  ****/");
        creerBlockGenese();
    }

    // ici on cree le premier bloc de la blockchain
    private void creerBlockGenese(){
        ajouterBlock(100, 1);
    }


    public void ajouterBlock(long preuveDeTravail, long hashPrecedente){

        Block nouveauBlock = new Block(preuveDeTravail, hashPrecedente, transactionsCourantes, index);
        transactionsCourantes = new ArrayList<>();
        index++;
        chaine.add(nouveauBlock);
        System.out.println("/****  Ajout d'un bloc  ****/");

    }

    public void ajouterTransaction(Utilisateur source, Utilisateur destinataire, long quantite) throws SignatureException, IOException, NoSuchAlgorithmException, InvalidKeyException{
        Transaction nouvelleTransaction = new Transaction(source.cleePublique, destinataire.cleePublique, quantite);
        transactionsCourantes.add(new TransactionWrapper(nouvelleTransaction, source.signer(nouvelleTransaction)));
    }


    public Block dernierBlock(){
        return chaine.getLast();
    }


    public void afficher(){
        System.out.println();
        System.out.println("Blockchain: ");
        System.out.println("\n****************\n****************\n");
        chaine.stream()
                .forEach(block -> {
                    System.out.println(block);
                    System.out.println("\n****************\n");
                });
        System.out.println();
    }

    public LinkedList<Block> getChaine(){
        return chaine;
    }

    public List<TransactionWrapper> getTransactions(){
        return transactionsCourantes;
    }
}
