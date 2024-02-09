/*
    PROJECT EULER #53
    https://projecteuler.net/problem=53

    Status: SOLVED , Solution: 4075
 */


public class fiftythree{
    public static void main(String[] args){
        int ct = 0;
        for(int n = 1; n <= 100; n++){
            for(int r = 1; r <= n; r++){
                ct += choose(n,r);
            }
        }
        System.out.println(ct);

    }
    static int choose(int n,int r){
        // save variables (for print statement debugging)
        int saven = n; int saver = r;
        // choose operation only defined on n > r
        if(n <= r){return 0;}
        double result = 1;
        // declare nr to keep hold of n - r
        int nr = n - r;
        while(n >= 1){
            // if the result is over a million, break out to stop unnecessary computations
            if(result >= 1000000){break;}
            // multiply by choose formula
            result *= n;
            result /= (nr);
            result /= (r);
            // decrement r if it's greater than 1. If it's 1, we can keep multiplying by 1
            if(r != 1){r--;}
            // decrement n-r if it's greater than 1. If it's 1, we can keep multiplying by 1
            if(nr != 1){nr--;}
            // safe to just increment r because we're checking it in the loop condition
            n--;
        }
        if(result > 1000000){
            // System.out.println(saven + " choose " + saver + " is greater than a million!");
            return 1;
        }
        else{return 0;}
    }
}