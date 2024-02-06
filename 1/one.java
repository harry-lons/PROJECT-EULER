/*
    PROJECT EULER #1 : Multiples of 3 or 5
https://projecteuler.net/problem=1

Status: SOLVED , solution = 233168
 */

public class one{
    public static void main(String[] args){
        int ct = 0;
        for(int i = 1; i<1000; i++){
            if(i%3 == 0 || i%5 == 0){ct+=i;}
        }
        System.out.println(ct);
    }
}