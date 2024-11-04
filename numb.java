import java.io.*;
import java.util.*;
public class numb{
    //define needed variable for our class
    public static int answer = 0;
    public static int a = 30;
    public static int[] arr;
    public static int[] DO_XOR;
    public static int[] L;
    public static int[] R;
    public static void main(String[] args) throws IOException{
        //define the reader and writer that we need
        PrintWriter outs = new PrintWriter(System.out);
        BufferedReader ins = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(ins.readLine());

        for(int counter = 1; counter <= num; counter = counter + 1){
            int n = Integer.parseInt(ins.readLine());
            StringTokenizer str = new StringTokenizer(ins.readLine());
            arr = new int[n+1];
            for(int i = 1 ; i <= n; i++) {

                arr[i] = Integer.parseInt(str.nextToken());

            }
            //do the bitwise xor
            DO_XOR = new int[n+1];
            DO_XOR[0] = 0;
            for(int i = 1; i <= n; i++){

                DO_XOR[i] = DO_XOR[i-1] ^ arr[i];

            }
            //define the left and right parts
            L = new int[n+1];
            R = new int[n+1];
            Arrays.fill(L,-1);
            Arrays.fill(R,-1);
            //define a stack
            Stack<Integer> stack = new Stack<>();
            for(int j = 1 ; j <= n ; j++) {

                while(!stack.isEmpty() && arr[stack.peek()] <= arr[j]) {
                    //get i from our stack
                    int i = stack.pop();
                    //add to left array
                    L[j] = i;

                }

                if(!stack.isEmpty()) {
                    //if it is not empty add it to the right one
                    R[stack.peek()] = j;

                }

                stack.push(j);

            }

            int head_of_stack = stack.pop();
            while(!stack.isEmpty()) {
                head_of_stack = stack.pop();
            }
            //define a variable for our output
            answer = 0;

            dfs(head_of_stack,1,n);
            //print the result for user
            outs.println(answer);
        }
        //now we close the writer since we're done
        outs.close();

    }

    public static Tree dfs(int num1, int num2, int c) {
        //check all different cases

        if( L[num1] == -1 && R[num1] == -1) {
            Tree tree = new Tree();
            addition(tree, DO_XOR[num1-1]);
            addition(tree, DO_XOR[num1]);
            return tree;

        }

        Tree left_one = null;
        Tree right_one = null;
        if(L[num1] != -1) left_one = dfs(L[num1],num2,num1-1);
        if(R[num1] != -1) right_one = dfs(R[num1],num1+1,c);


        if(L[num1] == -1)
        {
            answer = Math.max(answer, def(right_one, arr[num1], DO_XOR[num1-1]));
            addition(right_one, DO_XOR[num1-1]);
            return right_one;

        }
        if(R[num1] == -1) {
            answer = Math.max(answer, def(left_one, arr[num1], DO_XOR[num1]));
            addition(left_one, DO_XOR[num1]);
            return left_one;

        }
        if(c-num1 + 1 >= num1 - num2+1) {

            answer = Math.max(answer, def(right_one, arr[num1], DO_XOR[num1-1]));
            int k = num2 - 1;
            while(k < num1) {

                answer = Math.max(answer, def(right_one, arr[num1], DO_XOR[k]));
                k = k + 1;
            }
            k = num2 -1 ;
            while( k < num1) {
                addition(right_one, DO_XOR[k]);
                k = k +1;
            }

            return right_one;

        }

        else {

            answer = Math.max(answer, def(left_one, arr[num1], DO_XOR[num1]));
            int k = num1;
            while(k <= c) {

                answer = Math.max(answer, def(left_one, arr[num1], DO_XOR[k]));
                k = k + 1;
            }
            k = num1;
            while(k <= c) {
                addition(left_one, DO_XOR[k]);
                k = k +1 ;
            }



            return left_one;

        }

    }

    public static void addition(Tree tree, int n) {
        //this function checks if the tree's children is null or not then creates new one using it

        Tree C = tree;
        for(int i = (1 << a); i >= 1; i >>= 1) {

            if((n&i) == 0) {

                if(C.children[0] == null) {

                    C.children[0] = new Tree();
                }
                C = C.children[0];

            }
            else {
                if(C.children[1] == null) {

                    C.children[1] = new Tree();
                }
                C = C.children[1];

            }

        }

    }

    public static int def(Tree tree, int A, int b) {
        int Y = A^b;
        Tree C = tree;
        int answer = 0;
        for(int k = (1 << a); k >= 1; k >>= 1) {
            //check all possible cases

            if((Y&k) == 0) {

                if(C.children[1] == null) {

                    C = C.children[0];

                }

                else {

                    answer = answer + k;

                    C = C.children[1];

                }

            }

            else {
                if(C.children[0] != null) {

                    answer = answer + k;

                    C = C.children[0];

                }
                else {

                    C = C.children[1];
                }

            }

        }

        return answer;

    }


    //have a public class tree that is used in the other class
    public static class Tree {

        Tree[] children;
        public Tree(){

            children = new Tree[2];

        }

    }


}

