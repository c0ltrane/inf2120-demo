package Trivia.blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * Created by thomas on 11/11/17.
 */
public class Mineur {

    private Blockchain blockchain;
    private MessageDigest digest;

    public Mineur(Blockchain blockchain) {
        this.blockchain = blockchain;
        try{
            // on definit le type d'algorithme de hashage (ici SHA-256) utilise pour le probleme de preuve de travail (proof of work)
            this.digest = MessageDigest.getInstance("SHA-256");
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public long miner(){

        long preuvePrecedente = blockchain.dernierBlock().getPreuveDeTravail();
        long nouvellePreuve = preuvePrecedente + 1;

        String preuvePrecedenteString = blockchain.dernierBlock().getPreuveDeTravailStringFormat();
        String nouvellePreuveString = Long.toString(preuvePrecedente + 1);

        while(!(preuveEstValide(preuvePrecedenteString + nouvellePreuveString))){
            nouvellePreuve += 1;
            nouvellePreuveString = Long.toString(nouvellePreuve);
        }
        return nouvellePreuve;
    }

    private String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    // cette methode verifie si la preuve de travail est valide
    // la preuve est valide ssi le hash de la concatenation de l'ancienne et de la nouvelle preuve a un prefixe compose de n zeros (sous representation hexadeciamle)
    private boolean preuveEstValide(String originalString){

        byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
        String hexDigest = bytesToHex(encodedhash);
        return hexDigest.substring(0,5).equals("00000"); // ici on peut changer la difficulte de l'algorithme a resoudre en augmentant la taille du prefixe de hexDigest
                                                              // ( plus on rajoute de zeros plus le probleme est difficile a resoudre )
    }

    // ici on utilise un stream pour verifier que la blockchain est valide et qu'un block frauduleux n'a pas ete ajoute ou que les donnees d'un bloc n'ont pas ete modifiees
    public boolean chaineEstValide(){

        return IntStream.range(1, blockchain.getChaine().size())
                .allMatch(i -> blockchain.getChaine().get(i).getHashPrecedente() == blockchain.getChaine().get(i-1).hashCode()
                        && preuveEstValide(blockchain.getChaine().get(i-1).getPreuveDeTravailStringFormat()
                            + blockchain.getChaine().get(i).getPreuveDeTravailStringFormat()));
    }

    // Cette methode fait la meme chose que la precedente d'une facon alternative en utilisant un iterateur
    public boolean chaineEstValideAlt(){

        Iterator<Block> it = blockchain.getChaine().iterator();
        Block blockPrecedent = it.next();

        while(it.hasNext()){
            Block blockCourant = it.next();

            if(blockCourant.getHashPrecedente() != blockPrecedent.hashCode()){
                System.out.println("hash false");
                return false;
            }

            if(!preuveEstValide(blockPrecedent.getPreuveDeTravailStringFormat() + blockCourant.getPreuveDeTravailStringFormat())){

                System.out.println("preuve false");
                return false;
            }
            blockPrecedent = blockCourant;
        }
        return true;
    }


}
