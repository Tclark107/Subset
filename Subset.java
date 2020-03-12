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

    // setToString(B)
    // Called from recursive function printSubsets and returns a String
    static String setToString(int[] B){
        // create a string a that will print out the out put
        String rstr = "{";
        // create a string that will make it easier to add "," after each iter
        String a = "";
        for(int i = 1; i < B.length; i++){
            if(B[i] == 1){
                a += i;   
            }
        }
        for(int i = 0; i < a.length() - 1; i ++) {
            char c = a.charAt(i);
            rstr += c + ", ";
        }
        rstr += a.charAt(a.length()-1);
        rstr += "}";
        return rstr;
    }

    // printSubsets(B,k,i)
    // Recursively finds the solutions to n choose k and prints them.
    static void printSubsets(int[] B, int k, int i) {
        //if k is 0 then print out the solution
        //if k is greater than the array then go back up a level
        if(k==0){
            System.out.println(setToString(B));
            return;
        }
        if(k>B.length-i){
            return;
        }

        // clone A so we can change it and pass in the correct array
        // to the next recursive level
        int[] A = B.clone();
        A[i] = 1;

        // call the correct function recursively
        printSubsets(A, k-1, i+1);
        printSubsets(B,k,i+1);
    }

    public static void main(String[] args){
        int n = 0;
        int k = 0;

        // make sure the proper input is put in
        if(args.length != 2){
            printErr();
            System.exit(1);
        }
        try{
            n = Integer.parseInt(args[0]);
        } catch(NumberFormatException e){
            printErr();
            System.exit(1);
        }
        try{
            k = Integer.parseInt(args[1]);
        } catch(NumberFormatException e){
            printErr();
            System.exit(1);
        }
        if(n < k) {
            printErr();
            System.exit(1);
        }

        // initialize array and call recursive function
        int[] B = new int[n+1];
        printSubsets(B, k, 1);
    }
}