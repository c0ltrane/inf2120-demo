package Trivia.blockchain;

import java.io.IOException;
import java.security.*;

/**
 * Created by thomas on 11/17/17.
 */
public class Utilisateur {
    private PrivateKey cleePrivee;

    public PublicKey cleePublique;

    public Utilisateur(){
       genererCles();
    }


    public void genererCles(){
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
            keyPairGenerator.initialize(1024);
            KeyPair keyPair = keyPairGenerator.genKeyPair();
            cleePrivee = keyPair.getPrivate();
            cleePublique = keyPair.getPublic();

        }catch (NoSuchAlgorithmException e) {
        }
    }

    public SignedObject signer(Transaction unsignedTransaction) throws IOException, NoSuchAlgorithmException, SignatureException, InvalidKeyException{

        Signature signature = Signature.getInstance(cleePrivee.getAlgorithm());
        SignedObject signedTransaction = new SignedObject(unsignedTransaction.toString(), cleePrivee, signature);
        return signedTransaction;
    }

}
