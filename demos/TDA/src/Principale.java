/**
 * Created by thomas on 10/11/17.
 */
public class Principale {
    public static void main(String[] args) {
        String document1 = "RTFM";
        String document2 = "BIOS";
        String document3 = "AFK";


        Imprimante<String> imprimante = new Imprimante<>();

        imprimante.ajouterDocumentAImprimer(document1);
        imprimante.ajouterDocumentAImprimer(document2);
        imprimante.ajouterDocumentAImprimer(document3);

        while(true){
            try {
                String document = imprimante.imprimerProchainDocument();
                System.out.println(document);
            }catch (FileVide e){
                System.out.println("Aucun document a imprimer !");
                break;
            }
        }

    }
}
