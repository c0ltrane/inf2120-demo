import java.util.Iterator;

/**
 * Created by af491150 on 2017-10-26.
 */
public class Main {
    public static void main(String[] args) {
        File<Integer> superFile = new File<>();
        superFile.enfiler(3);
        superFile.enfiler(5);
        superFile.enfiler(7);
        superFile.enfiler(11);
        superFile.enfiler(13);
        superFile.enfiler(17);

        for(Integer item: superFile){
            System.out.println(item);
        }

        Iterator<Integer> iter = superFile.iterator();

        while(iter.hasNext()){
           System.out.println(iter.next());
        }
    }
}
