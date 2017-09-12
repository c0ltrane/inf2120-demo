package pointeurs;

/**
 * Created by thomas on 9/10/17.
 */
public class Couleur {

    private int rouge;
    private int vert;
    private int bleu;

    public Couleur(){
        setRouge(0);
        setBleu(0);
        setVert(0);
    }

    public Couleur( int rouge, int vert, int bleu ) {
        setRouge( rouge );
        setVert( vert );
        setBleu( bleu );
    }

    public Couleur( Couleur couleur){
        setRouge(couleur.getRouge());
        setVert(couleur.getVert());
        setBleu(couleur.getBleu());
    }

    public int getBleu(){
        return bleu;
    }

    public int getRouge(){
        return rouge;
    }

    public int getVert(){
        return vert;
    }

    public boolean couleurEstValide( int couleur ){
        return couleur >= 0 && couleur <= 255;
    }

    public void setBleu( int bleu ) {
        if(this.couleurEstValide(bleu)){
            this.bleu = bleu;
        }
    }

    public void setRouge( int rouge ) {
        if(this.couleurEstValide(rouge)){
            this.rouge = rouge;
        }
    }

    public void setVert( int vert ){
        if(this.couleurEstValide(rouge)){
            this . vert = vert;
        }
    }

    public void blanchir(){
        rouge = ( rouge + 255 ) / 2;
        vert = ( vert + 255 ) / 2;
        bleu = ( bleu + 255 ) / 2;
    }

    @Override
    public String toString(){
        return "[#" + rouge + ", #" + vert + ", #" + bleu + "]";
    }
}
