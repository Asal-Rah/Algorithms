import java.util.*;

class subarrays{

    static int find_sub_array(int arr[], int n, int sum)
    {
        int current_sum, i, j;
        int counter = 0;
        for (i = 0; i < n; i++) {
            current_sum = 0;

            for (j = i; j < n; j++) {
                current_sum = current_sum + arr[j];

                if (current_sum <= sum) {
                    counter++;
                }
            }
        }



        return counter;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0 ; i < n ; i ++) {
            arr[i] = in.nextInt();
        }
        int sum = t -1 ;

       int answer = find_sub_array(arr, n, sum);
       System.out.println(answer);
    }
}
