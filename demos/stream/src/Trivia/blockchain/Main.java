package Trivia.blockchain;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

/**
 * Created by thomas on 11/9/17.
 */
public class Main {
    public static void main(String[] args) {

        Utilisateur vitalik = new Utilisateur();
        Utilisateur bill = new Utilisateur();
        Utilisateur linus = new Utilisateur();
        Utilisateur satoshi = new Utilisateur();

        Blockchain blockchain = new Blockchain();
        Mineur mineur = new Mineur(blockchain);

        try{
            blockchain.ajouterTransaction(satoshi, vitalik, 50);
            blockchain.ajouterTransaction(satoshi, bill, 400);
            blockchain.ajouterTransaction(bill, vitalik, 40);
            blockchain.ajouterTransaction(vitalik, satoshi, 1000);
            blockchain.ajouterTransaction(satoshi, linus, 4000);
        } catch (SignatureException e) {
        } catch (InvalidKeyException e) {
        } catch (NoSuchAlgorithmException e) {
        } catch (IOException e) {
        }


//        long preuveBidon = 1;
//        blockchain.ajouterBlock(preuveBidon, blockchain.dernierBlock().hashCode()); // donnera une erreur ! la chaine ne sera pas valide dans ce cas

//        PS: Dans notre code on peut toujours ajouter un bloc avec une preuve non valide mais dans un reseau distribue ce bloc est rejete par les autres mineurs!

        long preuveDeTravail = mineur.miner();
        blockchain.ajouterBlock(preuveDeTravail, blockchain.dernierBlock().hashCode());

        System.out.println("\n/****  Verification de la validite de la BlockChain  ****/");
        System.out.println("\t>>>>>>>>> Cette chaine est " + (mineur.chaineEstValide() ? "valide" : "invalide") + " !");

        if(mineur.chaineEstValide())
            blockchain.afficher();


        try{
            blockchain.ajouterTransaction(satoshi, bill, 1000);
            blockchain.ajouterTransaction(satoshi, vitalik, 1000);
            blockchain.ajouterTransaction(bill, vitalik, 1000);
            blockchain.ajouterTransaction(linus, satoshi,1000);
            blockchain.ajouterTransaction(linus, vitalik, 1);
        } catch (SignatureException e) {
        } catch (InvalidKeyException e) {
        } catch (NoSuchAlgorithmException e) {
        } catch (IOException e) {
        }


        preuveDeTravail = mineur.miner();
        blockchain.ajouterBlock(preuveDeTravail, blockchain.dernierBlock().hashCode());

        System.out.println("\n/****  Verification de la validite de la BlockChain  ****/");
        System.out.println("\t>>>>>>>>> Cette chaine est " + (mineur.chaineEstValide() ? "valide" : "invalide") + " !");

        if(mineur.chaineEstValide())
            blockchain.afficher();

        System.out.println("!!! Un hacker s'est introduit dans le systeme !!!");
        blockchain.getChaine().get(1).getTransactions().get(0).getTransaction().quantite = 0; // ici on suppose qu'un agent malveillant tente de modifier une transaction ulterieure

        System.out.println("\n/****  Verification de la validite de la BlockChain  ****/");
        System.out.println("\t>>>>>>>>> Cette chaine est " + (mineur.chaineEstValide() ? "valide" : "invalide") + " !");

    }

}
