import java.util.Scanner;

public class employment {

    static int[] find(int[] years,int[][] start_finish , int d ) {
        int start , finish , new_length ;
        int[] answer = new int[d];
        int[] arr;
         for ( int i = 0 ; i < d ; i++) {
             start = start_finish[i][0];
             finish = start_finish[i][1];
             new_length = finish - start + 1 ;
             arr = new int[new_length];
             for ( int j = 0 ; j < new_length ; j++) {

                     if (start <= finish) {
                         arr[j] = years[start];
                         start++;
                     }

             }
            answer[i]= findMinDiff(arr,new_length);

         }

         return answer;
    }

    static int findMinDiff(int[] arr, int n)
    {

        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (Math.abs((arr[i] - arr[j])) < diff)
                    diff = Math.abs((arr[i] - arr[j]));

        return diff;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] years = new int[n];
        int[][] start_finish = new int[d][2];
        for (int i = 0; i < n; i++) {
            years[i] = in.nextInt();
        }
        for (int j = 0; j < d ; j++ ) {
            start_finish[j][0]= in.nextInt() - 1;
            start_finish[j][1]= in.nextInt() - 1;
        }

        int[] answers = new int[d];
        answers = find(years , start_finish , d);
        for ( int i = 0 ; i < d ; i++) {
            System.out.println(answers[i]);
        }


    }
}
