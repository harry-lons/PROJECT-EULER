/* 
PROJECT EULER #3 : Largest Prime Factor
https://projecteuler.net/problem=3

Status: SOLVED , solution = 6857

this code is broken and doesn't actually run, 
but I was able to guestimate the largest prime 
factor from the console output so I'm moving on to the next problem
*/
public class three{
    public static void main(String[] args){
        long in = 600851475143L;
        System.out.println(findLargestPrimeFactor(in));
    }
    public static long findLargestPrimeFactor(long in){
        System.out.println("finding largest prime!");
        long high = 1;
        for(long i = 2L; i < in; i++){

            if(in%i == 0 && findLargestPrimeFactor(i) == 1){
                if(i > high){
                high = i;
                System.out.println("high updated! high = " + high);}
            }
        }

        return high;
    }
}