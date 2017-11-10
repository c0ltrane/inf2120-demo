package Trivia.blockchain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by thomas on 11/9/17.
 */
public class Blockchain {

    private List<Block> chaine;
    private List<Transaction> transactionsCourantes;
    private int index;

    public Blockchain() {
        chaine = new ArrayList<>();
        transactionsCourantes = new ArrayList<>();
        index = 0;

        System.out.println("/****  Creation de la Blcokchain  ****/");
        creerBlockGenese();
    }

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

    public long preuveDeTravail(long preuvePrecedente){
        long nouvellePreuve = preuvePrecedente + 1;

        while(!(preuveEstValide(preuvePrecedente, nouvellePreuve))){
            nouvellePreuve += 1;
        }
        return nouvellePreuve;
    }

    public boolean preuveEstValide(long preuvePrecedente, long preuveCourante){
        if(!(preuveCourante % 9 == 0 && preuveCourante % preuvePrecedente == 0)){
           return false;
        }
        return true;
    }

    public Block dernierBlock(){
        return chaine.get(chaine.size()-1);
    }

    // verifie que la blockchain est valide et qu'un block frauduleux n'a pas ete ajoute
    public boolean chaineEstValide(){

        return IntStream.range(1, chaine.size())
                .allMatch(i -> chaine.get(i).getHashPrecedente() == chaine.get(i-1).hashCode()
                        && preuveEstValide(chaine.get(i-1).getPreuveDeTravail(), chaine.get(i).getPreuveDeTravail()));
    }

    // Cette methode fait la meme chose que la precedente d'une facon alternative sans utiliser les streams
    public boolean chaineEstValideAlt(){
        Block blockPrecedent = chaine.get(0);
        int indexCourant = 1;

        while(indexCourant < chaine.size()){
            Block blockCourant = chaine.get(indexCourant);

            if(blockCourant.getHashPrecedente() != blockPrecedent.hashCode()){
                return false;
            }

            if(!preuveEstValide(blockPrecedent.getPreuveDeTravail(), blockCourant.getPreuveDeTravail())){
                return false;
            }
            blockPrecedent = blockCourant;
            indexCourant++;
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
}
