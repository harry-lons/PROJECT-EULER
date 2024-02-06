/* 
PROJECT EULER #2 : Even Fibonacci Numbers
https://projecteuler.net/problem=2

Status: SOLVED , solution = 4613732
*/

public class two {
    public static void main(String[] args){
        int last = 1; int last2 = 1; int next = 0; int cap = 4000000; int sum = 0;
        while(next<cap){
            last2 = last;
            last = next;
            next = last+last2;
            if(next%2==0){sum+=next;}
        }
        System.out.println(sum);
    }
}
