/**
 * Created by thomas on 10/11/17.
 */
public class Principale {
    public static void main(String[] args) {
        String document1 = "RTFM";
        String document2 = "BIOS";
        String document3 = "AFK";


        File<String> imprimante = new File<>();
        if(!imprimante.estVide()) {
            System.out.println( "erreur, la nouvelle imprimante.le n'est pas vide." );
        }



        imprimante.enfiler( document1 );
        if(imprimante.taille() != 1 ){
            System.out.println( "erreur, il devrait y avoir un element." );
        }
        try {
            if(imprimante.tete() != document1 ){
                System.out.println( "erreur, le premier element devrait etre le document 1." );
            }
        } catch( FileVide e ) {
            System.out.println( "erreur, l'exception ne devrait pas etre lance." );
        }



        imprimante.enfiler( document2 );
        if(imprimante.taille() != 2 ){
            System.out.println( "erreur, il devrait y avoir deux elements." );
        }
        try {
            if(imprimante.tete() != document1 ){
                System.out.println( "erreur, le deuxieme element devrait etre le document 2." );
            }
        } catch( FileVide e ) {
            System.out.println( "erreur, l'exception ne devrait pas etre lance." );
        }



        imprimante.enfiler( document3 );
        if(imprimante.taille() != 3 ){
            System.out.println( "erreur, il devrait y avoir trois elements." );
        }
        try {
            if(imprimante.tete() != document1 ){
                System.out.println( "erreur, le premier element devrait etre le document 1." );
            }
        } catch( FileVide e ) {
            System.out.println( "erreur, l'exception ne devrait pas etre lance." );
        }



        try {
            imprimante.defiler();
            if(imprimante.taille() != 2 ){
                System.out.println( "erreur, il devrait y avoir deux elements." );
            }
            if(imprimante.tete() != document2 ){
                System.out.println( "erreur, le premier element devrait etre le document 2." );
            }
        } catch( FileVide e ) {
            System.out.println( "erreur, l'exception ne devrait pas etre lance." );
        }



        try {
            imprimante.defiler();
            if(imprimante.taille() != 1 ){
                System.out.println( "erreur, il devrait y avoir un element." );
            }
            if(imprimante.tete() != document3 ){
                System.out.println( "erreur, le premier element devrait etre le document 3." );
            }
        } catch( FileVide e ) {
            System.out.println( "erreur, l'exception ne devrait pas etre lance." );
        }



        try {
            imprimante.defiler();
            if(imprimante.taille() != 0 ){
                System.out.println( "erreur, il devrait y avoir zero element." );
            }
        } catch( FileVide e ) {
            System.out.println( "erreur, l'exception ne devrait pas etre lance." );
        }
    }
}
