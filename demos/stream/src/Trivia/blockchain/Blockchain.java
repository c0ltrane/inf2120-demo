package Trivia.blockchain;

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
    private List<Transaction> transactionsCourantes;
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

    public void ajouterTransaction(String source, String destinataire, long quantite){
       transactionsCourantes.add(new Transaction(source, destinataire, quantite));
    }



    // ici on verifie que la valeur utilisee comme preuve de travail est valide
    public boolean preuveEstValide(long preuvePrecedente, long preuveCourante){
        if(!(preuveCourante % 9 == 0 && preuveCourante % preuvePrecedente == 0)){
           return false;
        }
        return true;
    }

    public Block dernierBlock(){
        return chaine.getLast();
    }

    // ici on utilise un stream pour verifier que la blockchain est valide et qu'un block frauduleux n'a pas ete ajoute ou que les donnees d'un bloc n'ont pas ete modifiees
    public boolean chaineEstValide(){

        return IntStream.range(1, chaine.size())
                .allMatch(i -> chaine.get(i).getHashPrecedente() == chaine.get(i-1).hashCode()
                        && preuveEstValide(chaine.get(i-1).getPreuveDeTravail(), chaine.get(i).getPreuveDeTravail()));
    }

    // Cette methode fait la meme chose que la precedente d'une facon alternative en utilisant un iterateur
    public boolean chaineEstValideAlt(){

        Iterator<Block> it = chaine.iterator();
        Block blockPrecedent = it.next();

        while(it.hasNext()){
            Block blockCourant = it.next();

            if(blockCourant.getHashPrecedente() != blockPrecedent.hashCode()){
                return false;
            }

            if(!preuveEstValide(blockPrecedent.getPreuveDeTravail(), blockCourant.getPreuveDeTravail())){
                return false;
            }
            blockPrecedent = blockCourant;
        }
        return true;
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

    public List<Transaction> getTransactions(){
        return transactionsCourantes;
    }
}
