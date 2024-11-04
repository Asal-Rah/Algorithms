import java.util.Scanner;
import java.util.HashMap;


public class St {
    public static void main (String[] args) {
        int[] answer;
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n,m;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for ( int i = 0 ; i < t ; i++) {
            Integer a = in.nextInt();
            Integer b = in.nextInt();

            hmap.put(a, b);

        }

    }
}
