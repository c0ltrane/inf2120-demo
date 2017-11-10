package Trivia.blockchain;

/**
 * Created by thomas on 11/9/17.
 */
public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        blockchain.ajouterTransaction("Satoshi Nakamoto", "Elon Musk", 50);
        blockchain.ajouterTransaction("Satoshi Nakamoto", "Barack Obama", 400);
        blockchain.ajouterTransaction("Barack Obama", "Elon Musk", 40);
        blockchain.ajouterTransaction("Satoshi Nakamoto", "Linus Torvalds", 1000);
        blockchain.ajouterTransaction("Satoshi Nakamoto", "Barack Obama", 400);


//        blockchain.ajouterBlock(1, blockchain.dernierBlock().hashCode()); // donnera une erreur ! la chaine ne sera pas valide dans ce cas

        blockchain.ajouterBlock(miner(blockchain), blockchain.dernierBlock().hashCode());

        System.out.println("Cette chaine est " + (blockchain.chaineEstValide() ? "valide" : "invalide"));

        blockchain.afficher();
    }

    private static long miner(Blockchain blockchain){
        return blockchain.preuveDeTravail(blockchain.dernierBlock().getPreuveDeTravail());
    }
}
