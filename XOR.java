import java.util.*;

class XOR{

    public static void main(String[] args)
    {
       Scanner in = new Scanner(System.in);
       int n = in.nextInt();
       int[] values = new int[n];
       for( int i = 0 ; i < n ; i++) {
           values[i] = in.nextInt();
       }
       int answer = minXor(values,n);
       System.out.println(answer);
    }

    static int minXor(int arr[], int n)
    {
        Vector<Integer> sec = new Vector<Integer>();
        for(int j = 0 ; j < n ; j++)
            sec.add(arr[j]);
        return find_min_xor(sec, 10);
    }

    static int find_min_xor(Vector<Integer> section, int possible)
    {

        if (possible < 0)
            return 0;

        Vector<Integer> l_sec = new Vector<Integer>(),
                r_sec = new Vector<Integer>();

        for(int element : section)
        {
            if ((element >> possible) == 0)
                r_sec.add(element);
            else
                l_sec.add(element);
        }

        if (l_sec.size() == 0) {
            return find_min_xor(r_sec, possible - 1);
        }
        if (r_sec.size() == 0) {
            return find_min_xor(l_sec, possible - 1);
        }

        int num = Math.min(find_min_xor(r_sec, possible - 1),find_min_xor(l_sec, possible - 1));

        return num + (1 << possible);
    }




}


