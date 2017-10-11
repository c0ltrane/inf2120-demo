/**
 * Created by thomas on 10/11/17.
 */
public class Imprimante<T> {
    private File<T> documentsAImprimer;

    public Imprimante(){
        documentsAImprimer = new File<>();
    }

    public void ajouterDocumentAImprimer(T document){
       documentsAImprimer.enfiler(document);
    }

    public T imprimerProchainDocument() throws FileVide{
        T documentImprime = documentsAImprimer.tete();
        documentsAImprimer.defiler();

        return documentImprime;
    }
}
