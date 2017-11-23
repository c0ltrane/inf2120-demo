package Trivia.blockchain;

import java.io.IOException;
import java.security.*;

/**
 * Created by thomas on 11/17/17.
 */
public class TransactionWrapper {

    private Transaction transaction;
    private SignedObject signature;

    public TransactionWrapper(Transaction transaction, SignedObject sig)  throws IOException, NoSuchAlgorithmException, SignatureException, InvalidKeyException{
        this.transaction = transaction;
        this.signature = sig;
    }

    public boolean verifierSignature(PublicKey cleePublique) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature sig = Signature.getInstance(cleePublique.getAlgorithm());
        return signature.verify(cleePublique, sig);
    }

    @Override
    public int hashCode() {
        int result = transaction != null ? transaction.hashCode() : 0;
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n" + transaction +
                ", signature=" + signature.getSignature().toString();
    }

    public Transaction getTransaction() {
        return transaction;
    }
}
