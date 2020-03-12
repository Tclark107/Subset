//------------------------------------------------------------------------------------------------------------------------------
// Subset.java
// Tristan Clark
//------------------------------------------------------------------------------------------------------------------------------

class Subset{

    // printErr()
    // Is a helper function that prints the error message and exits when the user enters the 
    // wrong thing at the command line.
    static void printErr(){
        System.err.println("Usage: Subset <int> <int>");
        System.exit(0);
    }

    static String setToString(int[] B){
        String a = "{";
        //System.out.print("{");
        //for(int i = 1; i < B.length; i++){
        //    System.out.print(B[i]);
        //}
        //System.out.println("}");
        for(int i = 1; i < B.length; i++){
            if(B[i] == 1){
                a += i;
            }
        }
        a += "}";
        //System.out.println("a is: " + a);
        return a;
    }

    static void printSubsets(int[] B, int k, int i) {
        //System.out.println("I am on iter " + i);
        //System.out.println("k = "+k);
        //System.out.println("B.length: "+B.length);
        if(k==0){
            System.out.println(setToString(B));
            return;
        }
        if(k>B.length-i){
            return;
        }
        int[] A = B.clone();
        A[i] = 1;
        /*System.out.print("A is: ");
        for(int x = 1; x < B.length; x++){
            System.out.print(A[x]);
        }
        System.out.println();
        System.out.print("B is: ");
        for(int x = 1; x < B.length; x++){
            System.out.print(B[x]);
        }
        System.out.println();*/
        printSubsets(A, k-1, i+1);
        printSubsets(B,k,i+1);
    }
    public static void main(String[] args){
        /*int[] arr = {1,2,3,4};
        System.out.println(arr);
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i]);
        }
        arr[1] = 10;
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i]);
        }*/
        int[] B = {0,0,0,0};
        printSubsets(B, 0, 1);
    }
}