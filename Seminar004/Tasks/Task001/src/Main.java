import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
            LinkedList<Integer> linkList = new LinkedList<Integer>();
            ArrayList<Integer> arrayList = new ArrayList<Integer>();

            var s = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                arrayList.add(i);
            }
            linkList.addAll(arrayList);
            System.out.println(System.currentTimeMillis() - s);
        System.out.println(arrayList);
        System.out.println(linkList);

//            var m = System.currentTimeMillis();
//            for (int i = 0; i < 10; i++) {
//                linkList.add(i);
//            }
//            System.out.println(System.currentTimeMillis() - m);

        }

    }