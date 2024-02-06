/*
 * Project Euler #10 : Summation of Primes
 * https://projecteuler.net/problem=10
 * 
 * Status: SOLVED
 * solution: 142913828922
 */


import java.util.Scanner;
public class ten {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long total = 0L;
        int j = Integer.parseInt(args[0]);
        sc.close();
        for(int i = 2; i < j; i++){
            // System.out.println("checking " + i);
            if(isPrime(i)){
                total += i;
            }
        }
        System.out.println(total);
    }
    public static boolean isPrime(int i){
        int j = 2;
        if(i == 2){System.out.print("2 \t");
            return true;}
        while(j<i){
            if(i % j == 0){
                // System.out.println("false! " + i + " % " + j + "!= 0");
                return false;
            }
            j++;
        }
        System.out.print(i +" \t");
        return true;
    }
}
