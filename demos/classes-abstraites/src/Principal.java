/**
 * Created by thomas on 9/16/17.
 */

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Principal {
    public static void main(String[] args) {

        double x = 3.14555;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.FLOOR);

        Forme3D[] formes = {
                new Sphere(2.0),
                new CylindreDroit(new Cercle(5.0), 4.0),
                new CylindreDroit(new Rectangle(6.0, 6.0), 10.0)
        };

        for(Forme3D forme : formes){
            System.out.println(forme + " volume: " + new Double(df.format(forme.volume())) );
        }
    }
}
